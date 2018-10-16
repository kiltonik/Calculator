package com.example.asus.a1;

import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CalcPresenter implements Calculator.Presenter {

    private final Calculator.View view;

    public CalcPresenter(Calculator.View view, Calculator.BD bd) {
        this.view = view;
        this.bd = bd;
    }

    private final Calculator.BD bd;



    @Override
    public String buttonPressed(int id, String buttonName) {

        String expr = bd.getLastResult();
        int a;
        double result;
        boolean flag = true;
        int predznak = bd.getPredZnak();
        String res = "";

        if (((predznak == R.id.plus) || (predznak == R.id.minus) || (predznak == R.id.umn) || (predznak == R.id.del)) &&
                ((id == R.id.plus) || (id == R.id.minus) || (id == R.id.umn) || (id == R.id.del))) {
            res = (view.getExpression().replaceFirst(".$", ""));
            expr.replaceFirst(".$", "");
        }
        if (id != R.id.ravn && id != R.id.udalit) {
            res += (buttonName);
            switch (id) {
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
                    expr += buttonName;
            }
            flag = false;
        } else if (id != R.id.udalit) {
            flag = true;
            Expression t = new ExpressionBuilder(expr)
                    .build();
            result = t.evaluate();
            res = (Double.toString(result));
            expr = Double.toString(result);
        } else {
            try {
                if (flag) {
                    res = ("");
                } else {
                    res = (view.getExpression().replaceFirst(".$", ""));
                }
            } finally {
            }

        }
        bd.savePredZnak(id);
        bd.saveResult(expr);
        return res;
    }
}

