package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itis.libs.parserng.android.expressParser.MathExpression;

public class MainActivity extends AppCompatActivity {
    TextView number1,number2,number3,number4,number5,number6,number7,number8,number9,number0;
    TextView actPlus,actMinus,actDivide,actMultiple;
    EditText equations;
    Button actEquals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number0=findViewById(R.id.number0);number1=findViewById(R.id.number1);number2=findViewById(R.id.number2);number3=findViewById(R.id.number3);number4=findViewById(R.id.number4);number5=findViewById(R.id.number5);number6=findViewById(R.id.number6);
        number7=findViewById(R.id.number7);number8=findViewById(R.id.number8);number9=findViewById(R.id.number9);
        actPlus=findViewById(R.id.act_plus);actMinus=findViewById(R.id.act_minus);actDivide=findViewById(R.id.act_divide);actMultiple=findViewById(R.id.act_multiple);
        equations=findViewById(R.id.equation);
        actEquals=findViewById(R.id.act_equals);
        number0.setOnClickListener(v -> equations.setText(equations.getText().toString()+"0"));
        number1.setOnClickListener(v -> equations.setText(equations.getText().toString()+"1"));
        number2.setOnClickListener(v -> equations.setText(equations.getText().toString()+"2"));
        number3.setOnClickListener(v -> equations.setText(equations.getText().toString()+"3"));
        number4.setOnClickListener(v -> equations.setText(equations.getText().toString()+"4"));
        number5.setOnClickListener(v -> equations.setText(equations.getText().toString()+"5"));
        number6.setOnClickListener(v -> equations.setText(equations.getText().toString()+"6"));
        number7.setOnClickListener(v -> equations.setText(equations.getText().toString()+"7"));
        number8.setOnClickListener(v -> equations.setText(equations.getText().toString()+"8"));
        number9.setOnClickListener(v -> equations.setText(equations.getText().toString()+"9"));
        actPlus.setOnClickListener(v -> equations.setText(equations.getText().toString()+"+"));
        actMinus.setOnClickListener(v -> equations.setText(equations.getText().toString()+"-"));
        actDivide.setOnClickListener(v -> equations.setText(equations.getText().toString()+"%"));
        actMultiple.setOnClickListener(v -> equations.setText(equations.getText().toString()+"x"));

        actEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringEquation = equations.getText().toString();
                stringEquation = stringEquation.replace('%','/');
                stringEquation = stringEquation.replace('x','*');
                MathExpression expression = new MathExpression(stringEquation);
                equations.setText(expression.solve());
            }
        });
    }
}