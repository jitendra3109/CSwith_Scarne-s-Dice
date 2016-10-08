package com.example.jsrathore.scarnedice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private int UserOverAll=0,UserTurnScore=0,ComputerOverAll=0,ComputerTurnScore=0;
    private Button resetbutton,holdbutton,rollbutton;
    private ImageView diceimage;
    private TextView usertv,computertv;
    private String dice ;
    Random random=new Random();
    private int x,flag=0;
    private String str,userturn,computerturn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resetbutton=(Button)findViewById(R.id.Resetbutton);
        holdbutton=(Button)findViewById(R.id.hbutton);
        rollbutton=(Button)findViewById(R.id.Rbutton);
        diceimage=(ImageView)findViewById(R.id.imageView);
        usertv =(TextView)findViewById(R.id.yourscore);
        computertv=(TextView)findViewById(R.id.computerscore);
        diceimage.setImageResource(R.drawable.dice5);



        rollbutton.setOnClickListener(new View.OnClickListener() {  //roll button
            @Override
            public void onClick(View view) {
                x=random.nextInt(6)+1;
                flag=1;
                  if (UserTurnScore>=100){
                      usertv.setText("User Win");
                      rollbutton.setEnabled(false);
                      holdbutton.setEnabled(false);
                      Toast.makeText(MainActivity.this,"Please Play again And Click Reset",Toast.LENGTH_LONG).show();
                  }
                  else {
                      if (x == 1) {
                          diceimage.setImageResource(R.drawable.dice1);
                          UserTurnScore = 0;
                          str = computerturn;
                          rollbutton.setEnabled(false);
                          holdbutton.setEnabled(false);
                          computerplay();
                      }
                      if (x == 2) {
                          diceimage.setImageResource(R.drawable.dice2);
                          UserTurnScore += 2;
                      }
                      if (x == 3) {
                          diceimage.setImageResource(R.drawable.dice3);
                          UserTurnScore += 3;
                      }
                      if (x == 4) {
                          diceimage.setImageResource(R.drawable.dice4);
                          UserTurnScore += 4;
                      }
                      if (x == 5) {
                          diceimage.setImageResource(R.drawable.dice5);
                          UserTurnScore += 5;
                      }
                      if (x == 6) {
                          diceimage.setImageResource(R.drawable.dice6);
                          UserTurnScore += 6;
                      }
                  }
               }
        });




        holdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    UserOverAll += UserTurnScore;
                if (UserOverAll>=100){
                    usertv.setText("UserWin");
                    rollbutton.setEnabled(false);
                    holdbutton.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Please Play again and Reset Game", Toast.LENGTH_SHORT).show();

                }
              else if(flag==1){
                    flag=0;
                    str = computerturn;
                    x = 1;
                    UserTurnScore = 0;
                    String userScore = "UserScore:" + UserOverAll;
                    usertv.setText(userScore);
                    rollbutton.setEnabled(false);
                    holdbutton.setEnabled(false);
                    computerplay();
                }
                          }
        });




        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    UserOverAll=0;ComputerOverAll=0;
                    String userScore="UserScore:"+UserOverAll;
                    UserTurnScore=0; ComputerTurnScore=0;
                    usertv.setText(userScore);
                    str=userturn;
                   String computerScore="ComputerScore:"+ComputerOverAll;
                   computertv.setText(computerScore);
               // Toast.makeText(MainActivity.this, "Userturn="+UserTurnScore, Toast.LENGTH_SHORT).show();
                rollbutton.setEnabled(true);
                holdbutton.setEnabled(true);
            }
        });
    }

    public void computerplay(){
               /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);*/
           x=random.nextInt(6)+1;
           while(x!=1 && ComputerTurnScore<20){
              x=random.nextInt(6)+1;

              if(ComputerTurnScore>=100){
                  computertv.setText("ComputerWinz ");
                  rollbutton.setEnabled(false);
                  holdbutton.setEnabled(false);
                  Toast.makeText(MainActivity.this, "Please play agian and reset Game", Toast.LENGTH_LONG).show();
                  break;
              }
              else {

                  if (x == 1) {
                      ComputerTurnScore = 0;
                      rollbutton.setEnabled(true);
                      holdbutton.setEnabled(true);
                      ComputerOverAll += ComputerTurnScore;
                      str = userturn;
                      String computerScore = "ComputerScore:" + ComputerOverAll;
                      computertv.setText(computerScore);
                      break;


                  }


                  if (x == 2) {

                      diceimage.setImageResource(R.drawable.dice2);
                      ComputerTurnScore += 2;
                  }
                  if (x == 3) {

                      diceimage.setImageResource(R.drawable.dice3);
                      ComputerTurnScore += 3;
                  }
                  if (x == 4) {

                      diceimage.setImageResource(R.drawable.dice4);
                      ComputerTurnScore += 4;
                  }
                  if (x == 5) {
                      diceimage.setImageResource(R.drawable.dice5);
                      ComputerTurnScore += 5;
                  }
                  if (x == 6) {
                      diceimage.setImageResource(R.drawable.dice6);
                      ComputerTurnScore += 6;
                  }

              }
            }

        rollbutton.setEnabled(true);
        holdbutton.setEnabled(true);
        ComputerOverAll+=ComputerTurnScore;
        if(ComputerOverAll>=100){
            computertv.setText("ComputerWin:"+ComputerOverAll);
            rollbutton.setEnabled(false);
            holdbutton.setEnabled(false);
            Toast.makeText(MainActivity.this, "Please reset Game", Toast.LENGTH_SHORT).show();

        }
        else {
            str = userturn;
            String computerScore = "ComputerScore:" + ComputerOverAll;
            computertv.setText(computerScore);
            ComputerTurnScore = 0;

        }

        }
}
