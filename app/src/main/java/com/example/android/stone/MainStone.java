package com.example.android.stone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.android.R;

public class MainStone extends AppCompatActivity {
    //win:贏的次數 lose:輸的次數 tie:平手次數
    int win, lose, tie;
    private TextView txtResult;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private ImageView txtComPlay;

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
        setContentView(R.layout.activity_main_stone);
        findViews();
    }

    private void findViews() {
        txtComPlay = (ImageView) findViewById(R.id.txtComPlay);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnStone = (ImageButton) findViewById(R.id.btnStone);
        btnNet = (ImageButton) findViewById(R.id.btnNet);
        btnScissors = (ImageButton) findViewById(R.id.btnScissors);
        btnScissors.setOnClickListener(scissorsListener);
        btnStone.setOnClickListener(stoneListener);
        btnNet.setOnClickListener(netListener);
    }

    //當按下scissors/stone/net按鈕後的動作設定
    private Button.OnClickListener scissorsListener = new Button.OnClickListener() {
        public void onClick(View view) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            if (iComPlay == 1) {
                txtComPlay.setImageResource(R.drawable.scissors);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerDraw));
                tie++;
            } else if (iComPlay == 2) {
                txtComPlay.setImageResource(R.drawable.stone);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerLost));
                lose++;
            } else {
                txtComPlay.setImageResource(R.drawable.net);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerWin));
                win++;
            }
        }
    };
    private Button.OnClickListener stoneListener = new Button.OnClickListener() {
        public void onClick(View view) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            if (iComPlay == 1) {
                txtComPlay.setImageResource(R.drawable.stone);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerDraw));
                tie++;
            } else if (iComPlay == 2) {
                txtComPlay.setImageResource(R.drawable.net);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerLost));
                lose++;
            } else {
                txtComPlay.setImageResource(R.drawable.scissors);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerWin));
                win++;
            }
        }
    };
    private Button.OnClickListener netListener = new Button.OnClickListener() {
        public void onClick(View view) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            if (iComPlay == 1) {
                txtComPlay.setImageResource(R.drawable.net);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerDraw));
                tie++;
            } else if (iComPlay == 2) {
                txtComPlay.setImageResource(R.drawable.scissors);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerLost));
                lose++;
            } else {
                txtComPlay.setImageResource(R.drawable.stone);
                txtResult.setText(getString(R.string.result) + getString(R.string.playerWin));
                win++;
            }
        }
    };

    /*public void changePage(View view) {
        Intent in = new Intent(MainActivity.this,Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("win",win);
        bundle.putInt("lose",lose);
        bundle.putInt("tie",tie);
        in.putExtras(bundle);
        startActivity(in);
    }*/
}
