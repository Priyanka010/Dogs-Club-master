package com.manishab.straydogsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.manishab.straydogsapp.adapter.ViewPagerAdapter;
import com.manishab.straydogsapp.fragment.BreedFragment;
import com.manishab.straydogsapp.fragment.CenterFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    NavigationView navigationview;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationview = (NavigationView) findViewById(R.id.navigation);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        navigationview.setNavigationItemSelectedListener(this);

        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new BreedFragment(), "Breeds");
        viewPagerAdapter.addFragment(new CenterFragment(), "Centers");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.About:
                Intent intent=new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.contact:
                Intent intent1=new Intent(MainActivity.this,Contact.class);
                startActivity(intent1);
            default:
                Toast.makeText(MainActivity.this, " ", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
