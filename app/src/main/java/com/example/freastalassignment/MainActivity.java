package com.example.freastalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

  private ImageView imageView;
  private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageViewIcon);
        imageView.setAlpha((float) 0);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setMax(4000);
        startCounter();
    }

    private void startCounter() {
        new CountDownTimer(4000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((4000-(int)millisUntilFinished));
                imageView.setAlpha((float)(4000-millisUntilFinished)/4000);
            }
            @Override
            public void onFinish() {
                Intent intent=new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
