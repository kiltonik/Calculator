package com.example.asus.a1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @BindView(R.id.pole)
    TextView res;

    int a;
    double result;
    String expr = "";
    boolean flag = true;
    int predznak;

    @OnClick({R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine,
                 R.id.point, R.id.plus, R.id.minus, R.id.del, R.id.umn, R.id.ravn, R.id.udalit})
    void NumericButton(Button btn){
        Log.d("calculator", "button pressed");
        if (((predznak == R.id.plus) || (predznak == R.id.minus) || (predznak == R.id.umn) || (predznak == R.id.del)) &&
                ((btn.getId() == R.id.plus) || (btn.getId() == R.id.minus) || (btn.getId() == R.id.umn) || (btn.getId() == R.id.del))){
            res.setText(res.getText().toString().replaceFirst(".$", ""));
            expr.replaceFirst(".$", "");
        }
        if (btn.getId() != R.id.ravn && btn.getId() != R.id.udalit) {
            res.append(btn.getText().toString());
                switch (btn.getId()) {
                case R.id.plus:
                    expr += "+";
                    break;
                case R.id.minus:
                    expr += "-";
                    break;
                case R.id.umn:
                    expr += "*";
                    break;
                case R.id.del:
                    expr += "/";
                    break;
                default:
                    expr += btn.getText().toString();
            }
            flag = false;
            }
            else if(btn.getId() != R.id.udalit){
                flag = true;
                Expression t = new ExpressionBuilder(expr)
                        .build();
                result = t.evaluate();
                res.setText(Double.toString(result));
                expr = Double.toString(result);
            }
            else{
                try{
                    if (flag)
                    {
                        res.setText("");
                    }
                    else
                    {
                        res.setText(res.getText().toString().replaceFirst(".$", ""));
                    }
                }
                finally {
                }

            }
            predznak = btn.getId();
        }

    public void onBackPressed(){
        Intent result = new Intent();
        result.putExtra("result_calc", res.getText().toString());
        setResult(RESULT_OK, result);
        finish();
    }
}


