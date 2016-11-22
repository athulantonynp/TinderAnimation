package com.athul.tinderanim;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private ActionBar actionBar;
    final boolean status=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo=(ImageView)findViewById(R.id.imageView);
        //Hiding the action bar, since it is a splash screen activity
        actionBar = getSupportActionBar();
        actionBar.hide();
        //adding animation to image
        final AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(SplashActivity.this, R.animator.animation);
        set.setTarget(ivLogo);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, SplashActivity.class);
                startActivity(i);
                if(status){
                    set.start();
                    Intent mainAct=new Intent(SplashActivity.this,HomeScreen.class);
                    mainAct.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainAct);

                }




            }
        }, 3000);
    }
}
