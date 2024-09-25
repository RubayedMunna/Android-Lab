package com.example.changecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText billAmountInput;
    private EditText discountInput;
    private EditText moneyGivenInput;
    private TextView resultTextView;
    private Button calculateButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountInput = findViewById(R.id.billAmountInput);
        discountInput = findViewById(R.id.discountInput);
        moneyGivenInput = findViewById(R.id.moneyGivenInput);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);
        clearButton = findViewById(R.id.clearButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCashBack();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void calculateCashBack() {
        try {
            double billAmount = Double.parseDouble(billAmountInput.getText().toString());
            double discountAmount = Double.parseDouble(discountInput.getText().toString());
            double moneyGiven = Double.parseDouble(moneyGivenInput.getText().toString());

            double finalAmount = billAmount - billAmount * (discountAmount / 100.0);
            double cashBack = moneyGiven - finalAmount;

            if (cashBack < 0) {
                resultTextView.setText("Not enough money given!\nDue amount: " + cashBack * (-1));
            } else {
                resultTextView.setText("Cash Back: " + cashBack);
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter valid numbers.");
        }
    }

    private void clearFields() {
        billAmountInput.setText("");
        discountInput.setText("");
        moneyGivenInput.setText("");
        resultTextView.setText("");
    }
}
