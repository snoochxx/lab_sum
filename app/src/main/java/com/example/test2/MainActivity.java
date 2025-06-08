package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        calculateButton = findViewById(R.id.btnCalculate);

        calculateButton.setOnClickListener(v -> {
            String num1Str = editText1.getText().toString().trim();
            String num2Str = editText2.getText().toString().trim();

            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                try {
                    double number1 = Double.parseDouble(num1Str);
                    double number2 = Double.parseDouble(num2Str);

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Введите корректные числа", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Введите оба числа", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
