package mobilecomputing.isnumberprime;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "IsNumberPrime";
    private static Button mCorrect;
    private static Button mInCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv  = (TextView)findViewById(R.id.TextView1);
        tv.setText(NumberToBeChecked());
        Log.d(TAG, "In onCreate");

        mCorrect = (Button)findViewById(R.id.button1);
        mCorrect.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {

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

    public static boolean IsPrime(double n)
    {
        for(int i=2;i<Math.sqrt(n);i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
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
