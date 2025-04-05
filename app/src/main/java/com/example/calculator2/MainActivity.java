package com.example.calculator2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double operand = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);

        findViewById(R.id.button0).setOnClickListener(v -> updateDisplay("0"));
        findViewById(R.id.button1).setOnClickListener(v -> updateDisplay("1"));
        findViewById(R.id.button2).setOnClickListener(v -> updateDisplay("2"));
        findViewById(R.id.button3).setOnClickListener(v -> updateDisplay("3"));
        findViewById(R.id.button4).setOnClickListener(v -> updateDisplay("4"));
        findViewById(R.id.button5).setOnClickListener(v -> updateDisplay("5"));
        findViewById(R.id.button6).setOnClickListener(v -> updateDisplay("6"));
        findViewById(R.id.button7).setOnClickListener(v -> updateDisplay("7"));
        findViewById(R.id.button8).setOnClickListener(v -> updateDisplay("8"));
        findViewById(R.id.button9).setOnClickListener(v -> updateDisplay("9"));

        findViewById(R.id.buttonPlus).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.buttonMinus).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> setOperator("×"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> setOperator("÷"));

        findViewById(R.id.buttonEquals).setOnClickListener(v -> calculateResult());
        findViewById(R.id.buttonClear).setOnClickListener(v -> clearDisplay());
}
    private void updateDisplay(String number) {
        currentInput += number;
        display.setText(currentInput);

    }
    private void setOperator(String op){
        if(!currentInput.isEmpty()){
            operand = Double.parseDouble(currentInput);
            currentInput ="";
            operator = op;
            display.setText(operator);
        }
    }

    private void calculateResult(){
        if(!currentInput.isEmpty()){
            double SecondOperand = Double.parseDouble(currentInput);
            double result = 0.0;

        switch (operator) {
            case "+":
                result = operand + SecondOperand;
                break;
            case "-":
                result = operand - SecondOperand;
                break;
            case "×":
                result = operand * SecondOperand;
                break;
            case "÷":
        if (SecondOperand != 0) {
            result = operand / SecondOperand;
        } else {
            result = Double.NaN;
        }
            break;
        }
        display.setText(String.valueOf(result));
        currentInput = (String.valueOf(result));
        operator = "";
        operand = result;
        }
    }
    private void clearDisplay(){
        currentInput = "";
        operator = "";
        operand = 0.0;
        display.setText("0");
    }
}

