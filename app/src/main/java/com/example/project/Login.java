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

        TextView createAccountTextView = findViewById(R.id.createAccountTxt);
        TextView forgotPasswordTextView = findViewById(R.id.forgotPasswordTxt);

        String createAccountText = "Never been here before? Create Account";
        String forgotPasswordText = "Forgot Password?";

        SpannableString createAccountSpannable = new SpannableString(createAccountText);
        SpannableString forgotPasswordSpannable = new SpannableString(forgotPasswordText);

        ClickableSpan createAccountSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };

        ClickableSpan forgotPasswordSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };

        createAccountSpannable.setSpan(createAccountSpan, createAccountText.indexOf("Create Account"), createAccountText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgotPasswordSpannable.setSpan(forgotPasswordSpan, 0, forgotPasswordText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        createAccountTextView.setText(createAccountSpannable);
        forgotPasswordTextView.setText(forgotPasswordSpannable);

        createAccountTextView.setMovementMethod(LinkMovementMethod.getInstance());
        forgotPasswordTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }}