package com.codepath.firsttodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //member variabe to hold Arraylist
    ArrayList<String> items;
    //member for holding ArrayAdapter
    ArrayAdapter<String> itemsAdapter;
    //member for holding the list views
    ListView lvItems;
    //Member variable to hold text input
    EditText taskText;
    private int ACTIVITY_ID=10000;
    //member to Hold the Array position
    private int editPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        taskText = (EditText) findViewById(R.id.taskText);
        poulateArrayElements();
        lvItems.setAdapter(itemsAdapter);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                writetems();
                return true;
            }
        });
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                editPosition=position;
                launchEditActivityView(items.get(position));

            }
        });
    }
    public void poulateArrayElements(){
        items=new ArrayList<String>();
        readItems();
        itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
    }

    public void onAddItem(View view) {

        itemsAdapter.add(taskText.getText().toString());
        taskText.setText("");
        writetems();
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir,"todo.txt");
        try{
            items=new ArrayList<String>(FileUtils.readLines(file));
        }catch(IOException e){

        }
    }

    private void writetems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir,"todo.txt");
        try{
            FileUtils.writeLines(file,items);
        }catch(IOException e){
        }
    }

    public void launchEditActivityView(String editTextValue) {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(this, EditItemActivity.class);
        i.putExtra("editTaskName",editTextValue);
        startActivityForResult(i, ACTIVITY_ID);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == ACTIVITY_ID ) {
            items.set(editPosition,data.getExtras().getString("editTaskName"));
            itemsAdapter.notifyDataSetChanged();
            writetems();

        }
    }

}
