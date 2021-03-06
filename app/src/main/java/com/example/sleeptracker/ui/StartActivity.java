package com.example.sleeptracker.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleeptracker.R;
import com.example.sleeptracker.databinding.ActivityStartBinding;
import com.example.sleeptracker.utils.Formatter;

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_start);

        moveToMainActivity(Formatter.getTodayDate());
    }

    private void moveToMainActivity(String todayDate) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("date", todayDate);
            startActivity(intent);
            finish();
        }, 1500);
    }
}