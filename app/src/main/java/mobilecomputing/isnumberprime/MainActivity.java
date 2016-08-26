package mobilecomputing.isnumberprime;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "IsNumberPrime";
    private static final int RC = 0;
    private String S_NUMBER = "IN";
    private Button mCorrect;
    private Button mInCorrect;
    private Button nextButton;
    private Toast currentToast = null;
    private TextView tv;
    private String st;
    private Button mHint;
    private Button mCheat;
    private String message;
    private int cheat = 0;
    private int hint = 0;
    private TextView cheatTextView;
    private boolean enableTrue = true;
    private boolean enableFalse = true;
    private boolean enableHint = true;
    private boolean enableCheat = true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "In onCreate");
        if(savedInstanceState != null){
            st = savedInstanceState.getString(S_NUMBER);
            enableTrue = savedInstanceState.getBoolean("enableTrue");
            enableFalse = savedInstanceState.getBoolean("enableFalse");
            enableHint = savedInstanceState.getBoolean("enableHint");
            enableCheat = savedInstanceState.getBoolean("enableCheat");



        }
        else {

            st = NumberToBeChecked();
        }


        tv = (TextView) findViewById(R.id.TextView1);
        tv.setText(st);
        cheatTextView = (TextView) findViewById(R.id.TextCheatHint);

        mCorrect = (Button)findViewById(R.id.button1);
        Log.d("Main activity","onCreate"+enableCheat+enableHint+enableTrue+enableFalse);
        if(enableTrue) {
            mCorrect.setEnabled(true);
        } else {
            mCorrect.setEnabled(false);
        }

        mCorrect.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                    if (IsPrime(Double.parseDouble(st))) {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        //currentToast.show();

                        if(cheat==1 && hint==0)
                        {

                            cheatTextView.setText("You have cheated");
                        }
                        if(hint==1 && cheat==0)
                        {

                            cheatTextView.setText("You have taken hint");
                        }
                        if(cheat==1 && hint ==1)
                        {

                            cheatTextView.setText("You have taken hint & cheated as well");
                        }

                    } else {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        currentToast = Toast.makeText(getApplicationContext(), "Oops, you are Incorrect", Toast.LENGTH_SHORT);
                        currentToast.show();
                    }

                    mHint.setEnabled(false);
                    mCheat.setEnabled(false);
                    mInCorrect.setEnabled(false);
                    mCorrect.setEnabled(false);
                    enableCheat=false;
                    enableFalse=false;
                    enableHint=false;
                    enableTrue=false;

                }



        });


        mInCorrect = (Button)findViewById(R.id.button2);

        if(enableFalse) {
            mInCorrect.setEnabled(true);
        } else {
            mInCorrect.setEnabled(false);
        }

        mInCorrect.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                    if (IsPrime(Double.parseDouble(st))) {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        currentToast = Toast.makeText(getApplicationContext(), "Oops, you are Incorrect", Toast.LENGTH_SHORT);
                        currentToast.show();
                    } else {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        currentToast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                        currentToast.show();
                      //  cheatTextView = (TextView) findViewById(R.id.TextCheatHint);
                      //  Log.d(TAG,"cheat="+String.valueOf(cheat));
                       // Log.d(TAG,"hint="+String.valueOf(hint));
                        if(cheat==1 && hint==0)
                        {

                            cheatTextView.setText("You have cheated");
                        }
                        if(hint==1 && cheat==0)
                        {

                            cheatTextView.setText("You have taken hint");
                        }
                        if(cheat==1 && hint ==1)
                        {
                            cheatTextView.setText("You have taken hint & cheated as well");
                        }

                    }

                mHint.setEnabled(false);
                mCheat.setEnabled(false);
                mInCorrect.setEnabled(false);
                mCorrect.setEnabled(false);

                enableCheat=false;
                enableFalse=false;
                enableHint=false;
                enableTrue=false;
                }



        });

        nextButton = (Button)findViewById(R.id.button3);
        nextButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                mCorrect.setEnabled(true);
                mInCorrect.setEnabled(true);
                mCheat.setEnabled(true);
                mHint.setEnabled(true);

                if(currentToast!=null) {
                    currentToast.cancel();
                }
                    cheatTextView.setText("");
                hint = 0;
                cheat = 0;
                st = NumberToBeChecked();
                tv.setText(st);
                enableTrue=true;
                enableFalse=true;
                enableHint=true;
                enableCheat=true;
            }

        });



        mHint = (Button)findViewById(R.id.button4);

        if(enableHint) {
            mHint.setEnabled(true);
        } else {
            mHint.setEnabled(false);
        }
        mHint.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent hint = new Intent(MainActivity.this,HintActivity.class);
                startActivityForResult(hint,RC);
                mHint.setEnabled(false);
                enableHint = false;
            }

        });


        mCheat = (Button)findViewById(R.id.button5);
        if(enableCheat)
        {
            mCheat.setEnabled(true);
        }
        else
        {
            mCheat.setEnabled(false);
        }
        mCheat.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent cheat = new Intent(MainActivity.this,CheatActivity.class);
                cheat.putExtra("primeNo", st);
                cheat.putExtra("anwser", String.valueOf(IsPrime(Double.parseDouble(st))));
                startActivityForResult(cheat, RC);
                mCheat.setEnabled(false);
                enableCheat = false;
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC)
        {
            message = data.getStringExtra("MESSAGE");
            if(message.equals("1"))
            {
                cheat = 1;
            }
            if(message.equals("2"))
            {
                hint = 1;
            }


        }
    }

    public static String NumberToBeChecked()
    {
        Random rand = new Random();
        int num = 1 + rand.nextInt(999);
        String str = Integer.toString(num);
        return str;
    }

    public boolean IsPrime(double n)
    {
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(S_NUMBER, st);
        savedInstanceState.putBoolean("enableTrue", enableTrue);
        savedInstanceState.putBoolean("enableFalse",enableFalse);
        savedInstanceState.putBoolean("enableHint",enableHint);
        savedInstanceState.putBoolean("enableCheat",enableCheat);
        savedInstanceState.putInt("hintSaved",hint);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "In onStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"In onPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"In onResume");


    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "In onStop");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "In onDestroy");
    }
}
