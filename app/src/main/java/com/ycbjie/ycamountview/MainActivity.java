package com.ycbjie.ycamountview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ycbjie.amountviewlib.AmountView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        init2();
    }

    private void init() {
        AmountView avView = findViewById(R.id.av_view);
        avView.setAmountNum(2,10,1);
        int amount = avView.getAmount();
        avView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {

            }
        });
    }


    private void init2() {
        AmountView av_view2 = findViewById(R.id.av_view2);
        av_view2.setAmountNum(2,10,1);
        av_view2.setEtClickable(false);
        int amount = av_view2.getAmount();
        av_view2.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {

            }
        });
    }



}
