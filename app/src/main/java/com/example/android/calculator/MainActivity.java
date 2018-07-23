package com.example.android.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum OPERATOR {

        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }

    TextView txtCalculations;
    TextView txtResults;

    // Instance Variables

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculatiosResult;

    private String calculationsString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculatiosResult = 0;

        calculationsString = "";

        txtCalculations = findViewById(R.id.currentNumber);
        txtResults = findViewById(R.id.result);

        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnEqual:

                operatorIsTapped(OPERATOR.EQUAL);

                break;

            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnPlus:

                operatorIsTapped(OPERATOR.PLUS);
                calculationsString = calculationsString + " + ";

                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnSubtract:

                operatorIsTapped(OPERATOR.SUBTRACT);

                calculationsString = calculationsString + " - ";

                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnMultiply:

                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString = calculationsString + " * ";

                break;
            case R.id.btnClear:

                clearTapped();

                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnDivide:

                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString = calculationsString + " / ";

                break;


        }
        txtCalculations.setText(calculationsString);

    }

    private void numberIsTapped(int tappedNumber) {

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);

        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {

        if (currentOperator != null) {

            if (currentNumber != "") {


                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {


                    case PLUS:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);

                        break;

                    case SUBTRACT:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);

                        break;

                    case MULTIPLY:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);

                        break;
                    case DIVIDE:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);

                        break;


                }

                stringNumberAtLeft = String.valueOf(calculatiosResult);
                txtResults.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;

            }
        }

        else {

            stringNumberAtLeft = currentNumber;
            currentNumber = "";

        }

        currentOperator = tappedOperator;

    }

    private void clearTapped() {


        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculatiosResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResults.setText("0");
        calculationsString = "0";

    }

}
