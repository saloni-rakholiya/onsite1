package com.example.myrectangle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView img;
Animation anim2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);*/
        img=findViewById(R.id.textView);
        anim2= AnimationUtils.loadAnimation(this,R.anim.anim);

        img.setAnimation(anim2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
