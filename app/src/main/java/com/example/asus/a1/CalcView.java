package com.example.asus.a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class CalcView extends AppCompatActivity implements Calculator.View{
    private Calculator.Presenter presenter;
    @BindView(R.id.pole)
    TextView res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine,
            R.id.point, R.id.plus, R.id.minus, R.id.del, R.id.umn, R.id.ravn, R.id.udalit})
    public void printText(Button btn){
        Log.d("Calc View", "Button pressed");
        res.setText(presenter.buttonPressed(btn.getId(), btn.getText().toString()));
    }
    @Override
    public void goHistory(Class screen) {
        Intent intent = new Intent(getApplicationContext(), screen);
        startActivity(intent);
    }

    @Override
    public String getExpression(){
        return res.getText().toString();
    }

}

