package com.manishab.straydogsapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by priyanka on 3/5/17.
 */

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        TextView textView;
        textView = (TextView) findViewById(R.id.contact);
        textView.setText("Mail us at dogsclub101@gmail.com");
    }
}
