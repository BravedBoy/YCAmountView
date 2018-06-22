package com.ycbjie.ycamountview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yc on 2018/6/21.
 * 加密和解密
 */

public class SecondActivity extends AppCompatActivity {

    String data = "我是杨充";
    String desKey = "青龙偃月刀";          // 密钥，口号
    boolean isDesEncrypt = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    private void useDes() {
        try {
            if(isDesEncrypt){
                //解密
                //text.setText(Des.decrypt(text.getText().toString(), desKey));
            }else {
                //加密
                //text.setText(Des.encrypt(data, desKey));
            }
            isDesEncrypt = !isDesEncrypt;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
