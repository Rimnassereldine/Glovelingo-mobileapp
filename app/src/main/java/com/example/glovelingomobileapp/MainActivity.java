package com.example.glovelingomobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.glovelingomobileapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private View dot1, dot2, dot3, dot4;
    Button startButton;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

  private DrawerLayout drawerLayout;
  private ActionBarDrawerToggle  toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         setContentView(R.layout.activity_main);

         startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the new Activity when button is pressed
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            };
        });
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        dot4 = findViewById(R.id.dot4);
        animateDots();
          setTitle("Glovelingo");
           drawerLayout= findViewById(R.id.drawer_layout);
           toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
           drawerLayout.addDrawerListener(toggle);
           toggle.syncState();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);



        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void animateDots() {
        float startAlpha = 0.2f;
        float endAlpha = 1.0f;
        int duration = 400;

        animateDot(dot1, 0, startAlpha, endAlpha, duration);
        animateDot(dot2, 200, startAlpha, endAlpha, duration);
        animateDot(dot3, 400, startAlpha, endAlpha, duration);
        animateDot(dot4, 600, startAlpha, endAlpha, duration);
    }

    private void animateDot(View dot, int delay, float startAlpha, float endAlpha, int duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(dot, "alpha", startAlpha, endAlpha, startAlpha);
        animator.setDuration(duration);
        animator.setStartDelay(delay);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}