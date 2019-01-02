package com.example.desus.mciwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    public static double MC(String g, double a, double b, long it) {
        Expression e = new ExpressionBuilder(g).variable("x").build();
        double sum = 0, p = 0, n = 0, l = 0;

        for (long i = 0; i <= it; i++) {
            p = Math.random();
            n = a + (b - a) * p;
            e.setVariable("x", n);
            sum = sum + e.evaluate();

        }
        sum = ((b - a) / it) * sum;
        return sum;
    }

    TextView textView2, textView3, res;
    EditText ul, ll, exp;
    Button button;

    double w = 0, z = 0, r = 0;
    String t;
    int i =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            res = (TextView) findViewById(R.id.res);
            ll = (EditText) findViewById(R.id.ll);
            ul = (EditText) findViewById(R.id.ul);
            exp = (EditText) findViewById(R.id.exp);
            button = (Button) findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    w = Double.parseDouble(ll.getText().toString());
                    z = Double.parseDouble(ul.getText().toString());

                    t = exp.getText().toString();
                    r = MC(t, w, z, 1000000);
                    res.setText(String.valueOf(r));

                }

                ;

            });

        }

}