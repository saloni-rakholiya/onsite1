package com.example.myrectangle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    //private customview mcustom;
    private custom2 cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // customview customview=new customview(this);

      //  mcustom=findViewById(R.id.customview);
      cus=findViewById(R.id.customview);



    }
}
