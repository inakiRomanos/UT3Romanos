package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashscreenActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        /* New Handler to star DashboardActivity
        *and close this Splshscreen after some seconds. */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create a Intent will star DashboarActivity */
                Intent intent = new Intent(SplashscreenActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}