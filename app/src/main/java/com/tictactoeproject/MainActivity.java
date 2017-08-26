package com.tictactoeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tictactoeproject.model.WinnerChecker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    TextView mNotification;
    ImageView mRefresh;
    ImageView mImg00;
    ImageView mImg01;
    ImageView mImg02;
    ImageView mImg10;
    ImageView mImg11;
    ImageView mImg12;
    ImageView mImg20;
    ImageView mImg21;
    ImageView mImg22;
    boolean isPlayerOneTurn = true;
    WinnerChecker winnerChecker = new WinnerChecker();
    private int clickCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViewsAndInitListeners();
    }

    private void getViewsAndInitListeners(){
        mNotification = (TextView) findViewById(R.id.notification);
        mRefresh = (ImageView) findViewById(R.id.refresh);
        mRefresh.setOnClickListener(this);
        mImg00 = (ImageView) findViewById(R.id.img_0_0);
        mImg00.setImageDrawable(null);
        mImg00.setOnClickListener(this);
        mImg01 = (ImageView) findViewById(R.id.img_0_1);
        mImg01.setOnClickListener(this);
        mImg01.setImageDrawable(null);
        mImg02 = (ImageView) findViewById(R.id.img_0_2);
        mImg02.setOnClickListener(this);
        mImg02.setImageDrawable(null);
        mImg10 = (ImageView) findViewById(R.id.img_1_0);
        mImg10.setOnClickListener(this);
        mImg10.setImageDrawable(null);
        mImg11 = (ImageView) findViewById(R.id.img_1_1);
        mImg11.setOnClickListener(this);
        mImg11.setImageDrawable(null);
        mImg12 = (ImageView) findViewById(R.id.img_1_2);
        mImg12.setOnClickListener(this);
        mImg12.setImageDrawable(null);
        mImg20 = (ImageView) findViewById(R.id.img_2_0);
        mImg20.setOnClickListener(this);
        mImg20.setImageDrawable(null);
        mImg21 = (ImageView) findViewById(R.id.img_2_1);
        mImg21.setOnClickListener(this);
        mImg21.setImageDrawable(null);
        mImg22 = (ImageView) findViewById(R.id.img_2_2);
        mImg22.setOnClickListener(this);
        mImg22.setImageDrawable(null);
    }

    private void viewClicked(int id) {
        if (isPlayerOneTurn) {
            ((ImageView) findViewById(id)).setImageDrawable(getResources().getDrawable(R.drawable.ic_circle));
            mNotification.setText(R.string.player2);
        } else {
            ((ImageView) findViewById(id)).setImageDrawable(getResources().getDrawable(R.drawable.ic_x));
            mNotification.setText(R.string.player1);
        }

        findViewById(id).setOnClickListener(null);

        boolean result = winnerChecker.isTheGameDone(isPlayerOneTurn, id);

        if(!result){
            isPlayerOneTurn = !isPlayerOneTurn;
        } else {
            if(isPlayerOneTurn){
                mNotification.setText(R.string.player1Won);
            } else {
                mNotification.setText(R.string.player2Won);
            }
            disableClicks();
        }

        clickCounter++;
        if(clickCounter == 9){
            //all the clicks are used
            mNotification.setText(R.string.noPlayerWon);
        }
    }

    private void disableClicks() {
        mImg00.setOnClickListener(null);
        mImg01.setOnClickListener(null);
        mImg02.setOnClickListener(null);
        mImg10.setOnClickListener(null);
        mImg11.setOnClickListener(null);
        mImg12.setOnClickListener(null);
        mImg20.setOnClickListener(null);
        mImg21.setOnClickListener(null);
        mImg22.setOnClickListener(null);
    }

    private void reset() {
        clickCounter = 0;
        mNotification.setText(R.string.player1);
        isPlayerOneTurn = true;
        getViewsAndInitListeners();
        winnerChecker.resetModel();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.refresh) {
            reset();
        } else {
            viewClicked(id);
        }
    }
}
