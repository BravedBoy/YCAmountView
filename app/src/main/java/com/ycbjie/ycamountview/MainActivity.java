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
}
