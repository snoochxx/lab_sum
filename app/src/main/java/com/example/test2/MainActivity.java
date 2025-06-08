package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1Str = number1.getText().toString().trim();
                String num2Str = number2.getText().toString().trim();

                if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
                    Toast.makeText(MainActivity.this, "Пожалуйста, введите оба числа", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("num1", num1Str);
                intent.putExtra("num2", num2Str);
                startActivity(intent);
            }
        });
    }
}
