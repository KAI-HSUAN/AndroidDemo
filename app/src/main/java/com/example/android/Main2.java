package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private Button btn;
    private TextView result;
    private boolean a = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        btn = (Button) findViewById(R.id.btn);
        result = (TextView) findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.p04);
                img2.setImageResource(R.drawable.p04);
                img3.setImageResource(R.drawable.p04);
                img4.setImageResource(R.drawable.p04);
                img5.setImageResource(R.drawable.p04);
                img6.setImageResource(R.drawable.p04);
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("試著抽出鬼牌吧");
                a = true;
            }
        });
    }

    public void click(View view) {
        if (a) {
            switch (view.getId()) {
                case R.id.img1:
                    img1.setImageResource(R.drawable.p01);
                    result.setText("你猜錯了！");
                    a = false;
                    break;
                case R.id.img2:
                    img2.setImageResource(R.drawable.p03);
                    result.setText("你猜對了！");
                    a = false;
                    break;
                case R.id.img3:
                    img3.setImageResource(R.drawable.p02);
                    result.setText("你猜錯了！");
                    a = false;
                    break;
                case R.id.img4:
                    img4.setImageResource(R.drawable.p02);
                    result.setText("你猜錯了！");
                    a = false;
                    break;
                case R.id.img5:
                    img5.setImageResource(R.drawable.p01);
                    result.setText("你猜錯了！");
                    a = false;
                    break;
                case R.id.img6:
                    img6.setImageResource(R.drawable.p03);
                    result.setText("你猜對了！");
                    a = false;
                    break;
            }
        }

    }
}
