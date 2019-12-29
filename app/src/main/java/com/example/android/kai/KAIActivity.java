package com.example.android.kai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.android.R;

import java.util.Random;

public class KAIActivity extends AppCompatActivity {

    private TextView msg;
    private TextView Money;
    private TextView playMoney;
    private ImageView img1, img2, img3;
    private Wheel wheel1, wheel2, wheel3;
    private Button btn;
    private Button btnBack;
    private Button btn10;
    private Button btnallin;
    private Button btnclean;
    private boolean isStarted;
    int h_m = 0;
    int p_m = 0;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateShrink(this); //fire the slide left animation
    }

    @Override
    public void finish() {
        super.finish();
        Animatoo.animateShrink(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kai);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        btn = (Button) findViewById(R.id.btn);
        msg = (TextView) findViewById(R.id.msg);
        btnBack = (Button) findViewById(R.id.btnBack);
        Money = (TextView) findViewById(R.id.Money);
        btn10 = (Button) findViewById(R.id.btn10);
        btnallin = (Button) findViewById(R.id.btnallin);
        btnclean = (Button) findViewById(R.id.btnClean);
        playMoney = (TextView) findViewById(R.id.PayMoney);
        h_m = Integer.parseInt(Money.getText().toString());
        p_m = Integer.parseInt(playMoney.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFastDoubleClick()) {

                } else {
                    if (isStarted) {
                        p_m = Integer.parseInt(playMoney.getText().toString());
                        wheel1.stopWheel();
                        wheel2.stopWheel();
                        wheel3.stopWheel();

                        btn10.setEnabled(true);
                        btnallin.setEnabled(true);
                        btnclean.setEnabled(true);

                        if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                            p_m =p_m*10;
                            h_m+=p_m;
                            String ms = String.valueOf(h_m);
                            Money.setText(ms);
                            ms = String.valueOf(p_m);
                            msg.setText("10倍+"+ms);
                        } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex || wheel1.currentIndex == wheel3.currentIndex) {
                            p_m =p_m*2;
                            h_m+=p_m;
                            String ms = String.valueOf(h_m);
                            Money.setText(ms);
                            ms = String.valueOf(p_m);
                            msg.setText("2倍+"+ms);
                        } else {
                            msg.setText("輸到脫褲");
                        }

                        btn.setText("Start");
                        isStarted = false;

                    } else {

                        btn10.setEnabled(false);
                        btnallin.setEnabled(false);
                        btnclean.setEnabled(false);

                        if (h_m > 0) {
                            p_m = Integer.parseInt(playMoney.getText().toString());
                            h_m -= p_m;
                            String ms = String.valueOf(h_m);
                            Money.setText(ms);

                            wheel1 = new Wheel(new Wheel.WheelListener() {
                                @Override
                                public void newImage(final int img) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            img1.setImageResource(img);
                                        }
                                    });
                                }
                            }, 150, randomLong(0, 200));

                            wheel1.start();

                            wheel2 = new Wheel(new Wheel.WheelListener() {
                                @Override
                                public void newImage(final int img) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            img2.setImageResource(img);
                                        }
                                    });
                                }
                            }, 150, randomLong(150, 600));

                            wheel2.start();

                            wheel3 = new Wheel(new Wheel.WheelListener() {
                                @Override
                                public void newImage(final int img) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            img3.setImageResource(img);
                                        }
                                    });
                                }
                            }, 150, randomLong(150, 600));

                            wheel3.start();

                            btn.setText("Stop");
                            msg.setText("");
                            isStarted = true;
                        }else{
                            msg.setText("你沒有錢");
                        }

                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p_m<h_m){
                    p_m = Integer.parseInt(playMoney.getText().toString());
                    p_m+=100;
                    String ms = String.valueOf(p_m);
                    playMoney.setText(ms);
                }

            }
        });

        btnallin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h_m = Integer.parseInt(Money.getText().toString());
                p_m=h_m;
                String ms = String.valueOf(p_m);
                playMoney.setText(ms);
            }
        });

        btnclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_m=100;
                String ms = String.valueOf(p_m);
                playMoney.setText(ms);
            }
        });
    }

    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}



