package com.example.asus.a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


interface Calculator {
    interface View {
        void goHistory(Class screen);
        String getExpression();
        void printText(Button btn);
    }

    interface Presenter {
        String buttonPressed(int id, String buttonName);
    }

    interface BD {
        void saveResult(String result);
        String getResult(int id);
        String getLastResult();
        int getPredZnak();
        void savePredZnak(int znak);
    }
}







/*public class AnotherActivity extends AppCompatActivity {


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
*/