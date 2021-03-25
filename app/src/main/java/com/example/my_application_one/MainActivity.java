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
            case R.id.britishLibrary:
                Intent one = new Intent(MainActivity.this, BritishLibrary.class);
                startActivity(one);
                return true;
            case R.id.stopClock:
                Intent two = new Intent(MainActivity.this, StopClock.class);
                startActivity(two);
                return true;
            case R.id.send:
                Intent three = new Intent(MainActivity.this, CreateMessageActivityOne.class);
                startActivity(three);
                return true;
            case R.id.home:
                Intent four = new Intent(MainActivity.this, Home.class);
                startActivity(four);
                return true;
            case R.id.settings:
                Intent five= new Intent(MainActivity.this, Settings.class);
                startActivity(five);
                return true;
            case R.id.about:
                Intent six = new Intent(MainActivity.this, About.class);
                startActivity(six);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}