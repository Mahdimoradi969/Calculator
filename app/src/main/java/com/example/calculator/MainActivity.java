package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    double firstNumber = 0;
    String operation = "";
    boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        findViewById(R.id.btn0).setOnClickListener(numberClick);
        findViewById(R.id.btn1).setOnClickListener(numberClick);
        findViewById(R.id.btn2).setOnClickListener(numberClick);
        findViewById(R.id.btn3).setOnClickListener(numberClick);
        findViewById(R.id.btn4).setOnClickListener(numberClick);
        findViewById(R.id.btn5).setOnClickListener(numberClick);
        findViewById(R.id.btn6).setOnClickListener(numberClick);
        findViewById(R.id.btn7).setOnClickListener(numberClick);
        findViewById(R.id.btn8).setOnClickListener(numberClick);
        findViewById(R.id.btn9).setOnClickListener(numberClick);

        findViewById(R.id.btnAdd).setOnClickListener(operatorClick);
        findViewById(R.id.btnSub).setOnClickListener(operatorClick);
        findViewById(R.id.btnMul).setOnClickListener(operatorClick);
        findViewById(R.id.btnDiv).setOnClickListener(operatorClick);

        findViewById(R.id.btnEqual).setOnClickListener(equalClick);
        findViewById(R.id.btnClear).setOnClickListener(clearClick);
    }

    View.OnClickListener numberClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            String number = b.getText().toString();

            if (isNewOperation) {
                textView.setText(number);
                isNewOperation = false;
            } else {
                textView.setText(textView.getText().toString() + number);
            }
        }
    };

    View.OnClickListener operatorClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            operation = b.getText().toString();
            firstNumber = Double.parseDouble(textView.getText().toString());
            isNewOperation = true;
        }
    };

    View.OnClickListener equalClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double secondNumber = Double.parseDouble(textView.getText().toString());
            double result = 0;

            if (operation.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operation.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operation.equals("×")) {
                result = firstNumber * secondNumber;
            } else if (operation.equals("÷")) {
                if (secondNumber == 0) {
                    textView.setText("خطا");
                    return;
                }
                result = firstNumber / secondNumber;
            }

            if (result == (long) result) {
                textView.setText(String.valueOf((long) result));
            } else {
                textView.setText(String.valueOf(result));
            }

            isNewOperation = true;
        }
    };

    View.OnClickListener clearClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("0");
            firstNumber = 0;
            operation = "";
            isNewOperation = true;
        }
    };
}
