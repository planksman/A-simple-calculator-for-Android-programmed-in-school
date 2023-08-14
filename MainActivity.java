package com.example.addsums;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button add, math;
    private TextView answer;
    private int MathMode = 1;
    private int number1;
    private int number2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.edtnum1);
        num2 = (EditText) findViewById(R.id.edtnum2);
        add = (Button) findViewById(R.id.btnadd);
        math = (Button) findViewById(R.id.btnMath);
        answer = (TextView) findViewById(R.id.tvanswer);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MathMode == 1) {
                    MathMode = 2;
                    math.setText("-");
                }
                else if (MathMode == 2) {
                    MathMode = 3;
                    math.setText("*");
                }
                else if (MathMode == 3) {
                    MathMode = 4;
                    math.setText("/");
                }
                else if (MathMode == 4) {
                    MathMode = 1;
                    math.setText("+");
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    number1 = Integer.parseInt(num1.getText().toString());
                    number2 = Integer.parseInt(num2.getText().toString());
                }catch (Exception e) {
                    num1.setError("You must write a number");
                    num2.setError("You must write a number");
                }
                int sum = 0;
                if (number1 > 1 && number2 > 1) {
                    if (MathMode == 1) {
                        sum = number1 + number2;
                    } else if (MathMode == 2) {
                        sum = number1 - number2;
                    } else if (MathMode == 3) {
                        sum = number1 * number2;
                    } else if (MathMode == 4) {
                        sum = number1 / number2;
                    }
                }
                else {
                }

                answer.setText("Answer: " + String.valueOf(sum));
            }

        });

    }
}
