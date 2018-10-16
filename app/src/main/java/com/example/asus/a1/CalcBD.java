package com.example.asus.a1;

import java.util.ArrayList;

public class CalcBD implements Calculator.BD{

    ArrayList<String> results = new ArrayList<String>();
    int predznak;

    public void saveResult(String result){
        results.add(result);
    }

    @Override
    public String getResult(int id) {
        return results.get(id);
    }

    @Override
    public String getLastResult() {
        return results.get(results.size()-1);
    }

    @Override
    public void savePredZnak(int znak){
        predznak = znak;
    }

    @Override
    public int getPredZnak(){
        return predznak;
    }

}
