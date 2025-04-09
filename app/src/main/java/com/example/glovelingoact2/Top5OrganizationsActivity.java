package com.example.glovelingo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Top5OrganizationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5_organizations);

        TextView organizationsTextView = findViewById(R.id.organizationsTextView);
        organizationsTextView.setText("1. Organization 1\n2. Organization 2\n3. Organization 3\n4. Organization 4\n5. Organization 5");
    }
}

}
