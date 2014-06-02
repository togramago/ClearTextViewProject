package com.cleartextviewproject.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView tv_1_1;
    private ClearTextView tv_1_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1_1 = (TextView) findViewById(R.id.tv_1_1);
        tv_1_3 = (ClearTextView) findViewById(R.id.tv_1_3);
        tv_1_3.setText("CHANGED TEXT");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //Does not work after configuration change:
            tv_1_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.adjust_background));
            tv_1_3.setTextSize(50);

            //Works after configuration change because of android:freezesText="true"
            tv_1_3.setText("SETTINGS LONG LONG TEXT");
            tv_1_1.setText("just settings");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
