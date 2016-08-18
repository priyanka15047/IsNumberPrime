package mobilecomputing.isnumberprime;

import android.content.DialogInterface;
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
    private String S_NUMBER = "IN";
    private Button mCorrect;
    private Button mInCorrect;
    private Button nextButton;
    private Toast currentToast = null;
    private TextView tv;
    private String st;
    private boolean setButton = true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "In onCreate");
        if(savedInstanceState != null){
            st = savedInstanceState.getString(S_NUMBER);

        }
        else {

            st = NumberToBeChecked();
        }
        tv = (TextView) findViewById(R.id.TextView1);
        tv.setText(st);


        mCorrect = (Button)findViewById(R.id.button1);
        mCorrect.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v) {

                if(!setButton)
                {
                    mCorrect.setEnabled(false);
                }
                else {
                    if (IsPrime(Double.parseDouble(st))) {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        currentToast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                        currentToast.show();
                    } else {
                        if (currentToast != null) {
                            currentToast.cancel();
                        }
                        currentToast = Toast.makeText(getApplicationContext(), "Oops, you are Incorrect", Toast.LENGTH_SHORT);
                        currentToast.show();
                    }

                    setButton = false;
                }

            }

        });


        mInCorrect = (Button)findViewById(R.id.button2);
        mInCorrect.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(!setButton)
                {
                    mInCorrect.setEnabled(false);
                }
                else {
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

                    }
                    setButton = false;
                }

            }

        });

        nextButton = (Button)findViewById(R.id.button3);
        nextButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                mCorrect.setEnabled(true);
                mInCorrect.setEnabled(true);
                setButton = true;
                if(currentToast!=null) {
                    currentToast.cancel();
                }
                st = NumberToBeChecked();
                tv.setText(st);
            }

        });

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
