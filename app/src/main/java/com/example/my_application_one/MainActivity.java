package com.example.my_application_one;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickUpdate(View view){
        TextView currentgreeting = (TextView) findViewById(R.id.textView);
        Spinner greetings = (Spinner) findViewById(R.id.spinner);
        currentgreeting.setText(greetings.getSelectedItem().toString());
    }
    public void StopClock(View view){
        Intent intent = new Intent(this, StopClock.class);
        startActivity(intent);
    }
    public void BritishLibrary(View view){
        Intent intent = new Intent(this, BritishLibrary.class);
        startActivity(intent);
    }
    public void onSendMessage(View view){
        Intent intent = new Intent(this, CreateMessageActivityOne.class);
        //EditText message = (EditText) findViewById(R.id.message);
        //intent.putExtra(ReceiveMessageActivityOne.INTENT_MESSAGE, message.getText().toString());
        startActivity(intent);
    }
    public void timerStart(View view){

    }

    public void timerStop(View view){

    }

    public void timerReset(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options:
                Intent i = new Intent(MainActivity.this, BritishLibrary.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}