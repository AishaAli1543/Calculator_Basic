package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0.0;
    private double operand2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        updateResult();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(currentInput);
        currentInput = "";
    }

    public void onDecimalClick(View view) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        updateResult();
    }

    public void onEqualsClick(View view) {
        operand2 = Double.parseDouble(currentInput);
        double result = performCalculation();
        currentInput = String.valueOf(result);
        updateResult();
    }

    private void updateResult() {
        resultTextView.setText(currentInput);
    }

    private double performCalculation() {
        double result = 0.0;
        if (operator.equals("+")) {
            result = operand1 + operand2;
        } else if (operator.equals("-")) {
            result = operand1 - operand2;
        } else if (operator.equals("*")) {
            result = operand1 * operand2;
        } else if (operator.equals("/")) {
            if (operand2 != 0) {
                result = operand1 / operand2;
            } else {
                // Handle division by zero error
            }
        }
        return result;
    }
}
