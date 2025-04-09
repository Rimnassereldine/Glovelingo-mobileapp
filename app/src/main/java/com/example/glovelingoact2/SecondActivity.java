
package com.example.glovelingoact2;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.glovelingoact1.R;

public class SecondActivity extends AppCompatActivity {

    private TextView aboutText;
    private TextView chooseLanguageText;
    private Button englishButton, arabicButton, frenchButton;
    private Button descriptionButton, manualButton, top5Button;
    private TextView descriptionText;
    private boolean isAboutVisible = false;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize UI components
        aboutText = findViewById(R.id.aboutText);
        chooseLanguageText = findViewById(R.id.chooseLanguageText);
        englishButton = findViewById(R.id.englishButton);
        arabicButton = findViewById(R.id.arabicButton);
        frenchButton = findViewById(R.id.frenchButton);
        descriptionButton = findViewById(R.id.descriptionButton);
        manualButton = findViewById(R.id.manualButton);
        top5Button = findViewById(R.id.top5Button);
        descriptionText = findViewById(R.id.descriptionText);
        toolbar = findViewById(R.id.toolbar);

        // Set up the toolbar
        setSupportActionBar(toolbar);

        // Hide the About text initially
        aboutText.setVisibility(View.GONE);
        descriptionText.setVisibility(View.GONE); // Hide description text initially

        // Set click listener for the buttons
        englishButton.setOnClickListener(v -> {
            // Open activity for English language
            Intent intent = new Intent(SecondActivity.this, EnglishActivity.class);
            startActivity(intent);
        });

        arabicButton.setOnClickListener(v -> {
            // Open activity for Arabic language
            Intent intent = new Intent(SecondActivity.this, ArabicActivity.class);
            startActivity(intent);
        });

        frenchButton.setOnClickListener(v -> {
            // Open activity for French language
            Intent intent = new Intent(SecondActivity.this, FrenchActivity.class);
            startActivity(intent);
        });

        descriptionButton.setOnClickListener(v -> {
            // Show description text when clicked
            descriptionText.setVisibility(View.VISIBLE);
            descriptionText.setText("This is the description of the app...");
        });

        manualButton.setOnClickListener(v -> {
            // Open Manual activity to display an image
            Intent intent = new Intent(SecondActivity.this, ManualActivity.class);
            startActivity(intent);
        });

        top5Button.setOnClickListener(v -> {
            // Open activity for Top 5 Organizations (e.g., a list of organizations)
            Intent intent = new Intent(SecondActivity.this, Top5OrganizationsActivity.class);
            startActivity(intent);
        });
    }

    // Show/hide the About text when the toolbar is tapped
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            // Toggle About text visibility
            if (isAboutVisible) {
                aboutText.setVisibility(View.GONE);
            } else {
                aboutText.setVisibility(View.VISIBLE);
            }
            isAboutVisible = !isAboutVisible;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
