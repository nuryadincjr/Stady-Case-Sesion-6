package com.nuryadincjr.stadycase.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.stadycase.R;
import com.nuryadincjr.stadycase.databinding.ActivityImplicitIntentBinding;

public class ImplicitIntentActivity extends AppCompatActivity {

    private ActivityImplicitIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        binding = ActivityImplicitIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getAction(binding.btnDialNumber, Intent.ACTION_DIAL,
                "tel: 081541181633", null);

        getAction(binding.btnGallery, Intent.ACTION_VIEW,
                null, null);

        getAction(binding.btnSms, Intent.ACTION_SENDTO,
                "smsto: 081541181633",
                "Selamat siang, Nuryadin abutani");

        getAction(binding.btnCamera, MediaStore.ACTION_IMAGE_CAPTURE,
                null, null);
    }

    public void getAction(Button button, String action, String data, String values) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(action);

            if (binding.btnDialNumber.equals(button)) {
                intent.setData(Uri.parse(data));
            } else if (binding.btnCamera.equals(button)) {
                //
            } else if (binding.btnGallery.equals(button)) {
                intent.setType("image/*");
            } else if (binding.btnSms.equals(button)) {
                intent.setData(Uri.parse(data));
                intent.putExtra("sms_body", values);
            }
            startActivity(intent);
        });
    }
}