package com.example.asus.a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnotherActivity extends AppCompatActivity {


    @BindView(R.id.answer)
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.open_calc)
    void openCalc() {
        Log.d("calc_app", "open_calc");
        Context appContext = getApplicationContext();

        Intent intent = new Intent(appContext, MainActivity.class);

        intent.putExtra("int_key1", 42);
        intent.putExtra("string_key", "a");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        answer.setText("Previous answer:\n"+data.getStringExtra("result_calc"));
    }
}