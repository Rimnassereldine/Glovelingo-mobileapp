package com.example.glovelingoact1;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.glovelingoact2.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView splashImage;
    private ProgressBar loadingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImage = findViewById(R.id.splash_image);
        loadingSpinner = findViewById(R.id.loading_spinner);

        splashImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show loading spinner
                loadingSpinner.setVisibility(View.VISIBLE);

                // Simulate loading process with a delay
                splashImage.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Hide loading spinner and move to second activity
                        loadingSpinner.setVisibility(View.GONE);
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }, 3000); // Delay of 3 seconds
            }
        });
    }
}
