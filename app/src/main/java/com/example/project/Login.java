package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = findViewById(R.id.createAccountTxt);

        String text = "Never been here before? Create account.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event to navigate to the activity_register.xml
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // Customize the appearance of the clickable text (e.g., underline, color)
                ds.setUnderlineText(true);
                ds.setColor(Color.BLUE);
            }
        };

// Set the clickable span for the "Create account" text
        ss.setSpan(clickableSpan, text.indexOf("Create account"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Set the SpannableString to the TextView
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }}