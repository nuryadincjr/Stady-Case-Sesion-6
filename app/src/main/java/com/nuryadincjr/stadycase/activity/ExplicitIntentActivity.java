package com.nuryadincjr.stadycase.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nuryadincjr.stadycase.R;
import com.nuryadincjr.stadycase.databinding.ActivityExplicitIntentBinding;

import java.lang.ref.Reference;

public class ExplicitIntentActivity extends AppCompatActivity {

    private ActivityExplicitIntentBinding binding;
    private final String name = "Nuryadin Abutani";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        binding = ActivityExplicitIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getAction(binding.btnPembagian);
        getAction(binding.btnPenguarangn);
        getAction(binding.btnPerkalian);
        getAction(binding.btnPenjumlahan);
    }

    public void getAction(Button button) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("action", button.getText().toString());
            startActivity(intent);
        });
    }
}