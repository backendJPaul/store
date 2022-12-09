package com.jpaul.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {

    private TextView textViewUserRole;
    private TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initComponents();

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        textViewUserRole.setText(user.getRole());
        textViewName.setText(user.getName());
    }

    private void initComponents() {
        textViewUserRole = findViewById(R.id.textViewRole);
        textViewName = findViewById(R.id.textViewName);
    }
}