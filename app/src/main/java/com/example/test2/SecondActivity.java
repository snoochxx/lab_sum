package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView resultView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.backButton);

        double number1 = getIntent().getDoubleExtra("number1", Double.NaN);
        double number2 = getIntent().getDoubleExtra("number2", Double.NaN);

        if (!Double.isNaN(number1) && !Double.isNaN(number2)) {
            double sum = number1 + number2;
            resultView.setText("Сумма: " + sum);
        } else {
            resultView.setText("Числа не переданы");
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }
}
