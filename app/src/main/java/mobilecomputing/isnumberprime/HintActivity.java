package mobilecomputing.isnumberprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {
    TextView tv;
    Intent hintIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        setTitle("Hint");
        hintIntent  = getIntent();
        tv = (TextView) findViewById(R.id.hintTextView);
        tv.setText("Prime Number is Number which divided by it self only except 1");
    }

    @Override
    public void finish()
    {
        hintIntent.putExtra("MESSAGE", "2");
        setResult(2,hintIntent);
        super.finish();
    }


}
