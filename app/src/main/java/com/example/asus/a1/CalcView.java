package com.example.asus.a1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalcView extends MvpAppCompatActivity implements Calculator.View{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new CalcPresenter(this);
        Log.d("Calc View", "it works");

    }

    @BindView(R.id.pole)
    TextView res;

    private Calculator.Presenter presenter;

    @OnClick({R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine,
            R.id.point, R.id.plus, R.id.minus, R.id.del, R.id.umn, R.id.ravn, R.id.udalit})
    public void printText(Button btn){
        Context appContext = getApplicationContext();
        Log.d("Calc View", "Button pressed");
        res.setText(presenter.buttonPressed(btn.getId(), btn.getText().toString()));
    }

    @OnClick(R.id.history)
    public void openHistory(){
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        intent.putExtra("history", presenter.sendHistory());
        startActivity(intent);
    }


    @Override
    public String getScreenExpression(){
        return res.getText().toString();
    }

}

