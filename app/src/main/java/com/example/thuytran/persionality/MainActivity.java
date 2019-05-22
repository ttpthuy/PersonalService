package com.example.thuytran.persionality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText phoneTxt;
     Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneTxt = (EditText) findViewById(R.id.phone);
        btnNext = (Button) findViewById(R.id.btnNext);
    }
}
