package com.example.test2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultText = findViewById(R.id.resultText);

        String num1Str = getIntent().getStringExtra("num1");
        String num2Str = getIntent().getStringExtra("num2");

        if (num1Str == null || num2Str == null || num1Str.trim().isEmpty() || num2Str.trim().isEmpty()) {
            resultText.setText("Ошибка: числа не переданы");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str.trim());
            double num2 = Double.parseDouble(num2Str.trim());
            double sum = num1 + num2;
            resultText.setText("Сумма: " + sum);
        } catch (NumberFormatException e) {
            resultText.setText("Ошибка ввода! Пожалуйста, введите корректные числа.");
        }
    }
}
