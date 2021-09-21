package com.nuryadincjr.stadycase.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nuryadincjr.stadycase.R;
import com.nuryadincjr.stadycase.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private double etVariable1 = 0;
    private double etVariable2 = 0;
    private double result = 0;
    private String name, action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        action = intent.getStringExtra("action");

        final String sayHello = "Hallo "+ name +", Selamat datang di "+ action;
        binding.tvHello.setText(sayHello);
        binding.btnAction.setText(action);

        binding.btnAction.setOnClickListener(view -> {
            etVariable1 = Double.parseDouble(binding.etVariable1.getText().toString());
            etVariable2 = Double.parseDouble(binding.etVariable2.getText().toString());

            switch (action){
                case "Pengurangan":
                    result = etVariable1 - etVariable2;
                    break;
                case "Perkalian":
                    result = etVariable1 * etVariable2;
                    break;
                case "Penjumlahan":
                    result = etVariable1 + etVariable2;
                    break;
                case "Pembagian":
                    result = etVariable1 / etVariable2;
                    break;
            }
            binding.tvResult.setText(String.valueOf(result));
        });
    }
}