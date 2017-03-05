package com.gerry.matchscorer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int mScoreA=0;
    private int mScoreB=0;

    private static final char TEAMA = 'A';
    private static final char TEAMB = 'B';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Add_1Points_A = (Button) findViewById(R.id.Add_1Points_A);
        Button Add_1Points_B = (Button) findViewById(R.id.Add_1Points_B);
        Button Add_2Points_A = (Button) findViewById(R.id.Add_2Points_A);
        Button Add_2Points_B = (Button) findViewById(R.id.Add_2Points_B);
        Button Add_3Points_A = (Button) findViewById(R.id.Add_3Points_A);
        Button Add_3Points_B = (Button) findViewById(R.id.Add_3Points_B);

        Add_1Points_A.setOnClickListener(clickListener);
        Add_1Points_B.setOnClickListener(clickListener);
        Add_2Points_A.setOnClickListener(clickListener);
        Add_2Points_B.setOnClickListener(clickListener);
        Add_3Points_A.setOnClickListener(clickListener);
        Add_3Points_B.setOnClickListener(clickListener);

        }



    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.Add_1Points_A:
                    addPoints(TEAMA,1);
                    break;
                case R.id.Add_1Points_B:
                    addPoints(TEAMB,1);
                    break;
                case R.id.Add_2Points_A:
                    addPoints(TEAMA,2);
                    break;
                case R.id.Add_2Points_B:
                    addPoints(TEAMB,2);
                    break;
                case R.id.Add_3Points_A:
                    addPoints(TEAMA,3);
                    break;
                case R.id.Add_3Points_B:
                    addPoints(TEAMB,3);
                    break;
            }
        }
    };

    private void addPoints(char team, int points){
        switch (team){
            case TEAMA:
                mScoreA = mScoreA + points;
                break;
            case TEAMB:
                mScoreB = mScoreB + points;
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.scorer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_reset:
                resetScores();
                return true;
        }
        return false;
    }

    private void resetScores(){
        mScoreA = 0;
        mScoreB = 0;
    }
}
