package com.studi.studi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements OnItemSelectedListener{

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayList<String> Science = new ArrayList<String>();
    ArrayList<String> English = new ArrayList<String>();
    ArrayList<String> Math = new ArrayList<String>();
    ArrayList<String> ForeignLanguage = new ArrayList<String>();
    ArrayList<String> SocialStudies = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String message;
    String selState;
    Button bt;
    EditText et;
    ListView lv;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        Switch mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setChecked(true);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //stuff
                } else {
                    //stuff
                }
            }
        });
       // createList();
    }

    public void createSpinner(){
        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
    }

    public void createList(){
        bt = (Button) findViewById(R.id.button3);
        et = (EditText) findViewById(R.id.editText);
        lv = (ListView) findViewById(R.id.listView);

        if(selState == "Science")
            listItems = Science;
        else if(selState == "English")
            listItems = English;
        else if(selState == "Math")
            listItems = Math;
        else if(selState == "Foreign Language")
            listItems = ForeignLanguage;
        else if(selState == "Social Studies")
            listItems = SocialStudies;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        lv.setAdapter(adapter);

        message = et.getText().toString();

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                if(null!=input && input.length()>0){
                    listItems.add(input);

                    et.setText("");
                    adapter.notifyDataSetChanged();
                    InputMethodManager imm = (InputMethodManager)getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(et.getWindowToken(), 0);

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if (id == R.id.action_map) {
            Intent intent = new Intent(this, graph.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        sp.setSelection(position);
        selState = (String) sp.getSelectedItem();
        bt = (Button) findViewById(R.id.button3);
        et = (EditText) findViewById(R.id.editText);
        lv = (ListView) findViewById(R.id.listView);

        if(selState == "Science")
            listItems = Science;
        else if(selState == "English")
            listItems = English;
        else if(selState == "Math")
            listItems = Math;
        else if(selState == "Foreign Language")
            listItems = ForeignLanguage;
        else if(selState == "Social Studies")
            listItems = SocialStudies;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        lv.setAdapter(adapter);

        message = et.getText().toString();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                if (null != input && input.length() > 0) {
                    listItems.add(input);
                    if (selState == "Science")
                        Science.add(input);
                    else if (selState == "English")
                        English.add(input);
                    else if (selState == "Math")
                        Math.add(input);
                    else if (selState == "Foreign Language")
                        ForeignLanguage.add(input);
                    else if (selState == "Social Studies")
                        SocialStudies.add(input);
                    et.setText("");
                    adapter.notifyDataSetChanged();
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(et.getWindowToken(), 0);

                }
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
