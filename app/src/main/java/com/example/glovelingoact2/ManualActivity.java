package com.example.glovelingoact2;



import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

    public class ManualActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manual);

            ImageView manualImageView = findViewById(R.id.manualImageView);
            manualImageView.setImageResource(R.drawable.manual_image); // Load your image here
        }
    }

}
