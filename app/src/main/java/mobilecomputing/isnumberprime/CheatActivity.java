package mobilecomputing.isnumberprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class CheatActivity extends AppCompatActivity {
    TextView tv ;
    Intent cheatIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setTitle("Cheat");
        cheatIntent = getIntent();
        String primeNo = cheatIntent.getStringExtra("primeNo");
        String answer = cheatIntent.getStringExtra("anwser");
        tv = (TextView) findViewById(R.id.cheatTextView);
        if(answer.equals("false"))
            tv.setText(primeNo + " is not Prime Number");
        else
            tv.setText(primeNo + " is Prime Number");
    }
    @Override
    public void finish()
    {
        cheatIntent.putExtra("MESSAGE", "1");
        setResult(1, cheatIntent);
        super.finish();
    }
}
