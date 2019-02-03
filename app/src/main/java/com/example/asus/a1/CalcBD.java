package com.example.asus.a1;

import java.util.ArrayList;

public class CalcBD implements Calculator.BD{

    ArrayList<String> results = new ArrayList<String>();
    int predznak;
    String expression = "";

    public void saveResult(String result){
        results.add(result);
    }

    @Override
    public ArrayList<String> getResults() {
        return results;
    }

//    @Override
//    public String getLastResult() {
//        try{
//            return results.get(results.size()-1);
//        }
//        finally {
//            return "";
//        }
//    }

    @Override
    public void savePredZnak(int znak){
        predznak = znak;
    }

    @Override
    public int getPredZnak(){
        return predznak;
    }

    @Override
    public void saveExpression(String expr) {
        this.expression = expr;
    }

    @Override
    public String getExpression(){
        return expression;
    }

    @Override
    public void clearExpression(){
        expression = "";
    }
}
