package com.ycbjie.ycamountview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ycbjie.amountviewlib.AmountView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        init2();
        init3();
        findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
            }
        });
    }

    private void init() {
        AmountView avView = findViewById(R.id.av_view);
        //avView.setAmountNum(10);
        avView.setAmountNum(2,10,1);
        //设置是否可以点击
        avView.setEtClickable(false);
        int amount = avView.getAmount();
        avView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(boolean isChange, boolean isMaxOrMin, int amount) {
                Log.e("change",isChange+"-------"+isMaxOrMin+"----------"+amount);
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
            public void onAmountChange(boolean isAdd, boolean isMaxOrMin, int amount) {
                Log.e("change",isAdd+"-------"+isMaxOrMin+"----------"+amount);
            }
        });
    }


    private void init3() {
        AmountView av_view3 = findViewById(R.id.av_view3);
        av_view3.setAmountNum(2,10,1);
        av_view3.setEtClickable(false);
        int amount = av_view3.getAmount();
        av_view3.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {

            @Override
            public void onAmountChange(boolean isAdd, boolean isMaxOrMin, int amount) {
                Log.e("change",isAdd+"-------"+isMaxOrMin+"----------"+amount);
            }
        });
    }



}
