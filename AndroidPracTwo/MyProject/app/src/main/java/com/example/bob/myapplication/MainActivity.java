package com.example.bob.myapplication;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            The implementation done from Udacity's innitializes the XML objects
            in the Java source; meaning, I gotta figure out how to do just that,
            with the EditText.
         */
        ArrayList<EditText> listOfInputs = new ArrayList<EditText>();
        EditText inputOne = new EditText(this);
        //inputOne.setHint("No dude.");
        //inputOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listOfInputs.add(inputOne);

        ArrayAdapter<EditText> itemsAdapter = new ArrayAdapter<EditText>(this
                    , android.R.layout.simple_list_item_1, listOfInputs);
        ListView listView = (ListView) findViewById(R.id.listViews);
        listView.setAdapter(itemsAdapter);
    }

    //https://stackoverflow.com/questions/36340268/nullpointerexception-while-setting-layoutparams
    //The link above saved me.
    /*
    protected void setHW(EditText edText){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        edText.setLayoutParams(params);
        edText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        //The below lines are from: https://stackoverflow.com/questions/15032870/create-a-multiline-edittext-programmatically
        edText.setSingleLine(false);
        edText.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
    }
    */
}