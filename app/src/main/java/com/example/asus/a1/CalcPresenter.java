package com.example.asus.a1;

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

import androidx.versionedparcelable.ParcelField;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.BindView;
import butterknife.ButterKnife;



public class CalcPresenter implements Calculator.Presenter {

    private final Calculator.View view;
    private final Calculator.BD bd;


    public CalcPresenter(Calculator.View view) {
        this.view = view;
        bd = new CalcBD();
    }

    boolean flag = true;

    @Parcel
    public static class MyObjects{
        public ArrayList<String> results;
    }

    @Override
    public String buttonPressed(int id, String buttonName) {

        String expr = bd.getExpression();
        double result;
        int predznak = bd.getPredZnak();
        String res = view.getScreenExpression();

        if (((predznak == R.id.plus) || (predznak == R.id.minus) || (predznak == R.id.umn) || (predznak == R.id.del)) &&
                ((id == R.id.plus) || (id == R.id.minus) || (id == R.id.umn) || (id == R.id.del))) {
            res = res.replaceFirst(".$", "");
            expr = expr.replaceFirst(".$", "");
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
            res = Double.toString(result);
            expr = Double.toString(result);
            bd.clearExpression();
            bd.saveResult(res);
        } else {
            try {
                if (flag) {
                    res = ("");
                } else {
                    res = res.replaceFirst(".$", "");
                    expr = expr.replaceFirst(".$", "");
                }
            } finally {
            }

        }
        bd.saveExpression(expr);
        bd.savePredZnak(id);
        return res;
    }

    @Override
    public Parcelable sendHistory(){
        return Parcels.wrap(bd.getResults());
    }
}

