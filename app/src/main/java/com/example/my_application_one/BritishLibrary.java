package com.example.my_application_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class BritishLibrary extends AppCompatActivity {
    private SharedPreferences sharedPref; //In the class definition

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_british_library);

        sharedPref = this.getPreferences(Context.MODE_PRIVATE); //In the onCreate method
        ((EditText)findViewById(R.id.borrowerID)).setText(sharedPref.getString("borrower _id","No ID set."));
        sharedPref.contains("borrower_id");
    }
    public void setBorrowerIDClick(View view) {
        EditText bID = (EditText) findViewById(R.id.borrowerID);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("borrower_id", bID.getText().toString());
        editor.commit();
    }
}