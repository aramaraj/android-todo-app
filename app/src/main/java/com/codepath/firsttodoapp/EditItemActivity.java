package com.codepath.firsttodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.app.Activity;

public class EditItemActivity extends AppCompatActivity {

    //Member variable to get the  EditText value
    EditText editTask;
    Intent v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editTask = (EditText) findViewById(R.id.etTaskName);
        v = getIntent();
        String username = v.getStringExtra("editTaskName");
        editTask.setText(username);
    }

    public void onSubmit(View viw) {
        // Prepare data intent
        // Pass relevant data back as a result
        //Intent intent = new Intent(this, MainActivity.class);
        String editSaveTask=editTask.getText().toString();
        Intent intent = new Intent();
        System.out.println("EDIT TASK STROING:::"+editSaveTask);
        if(!(editSaveTask.equalsIgnoreCase(null)) && !(editSaveTask.equals(""))){
            intent.putExtra("editTaskName", editSaveTask);
              if (getParent() == null) {
                setResult(Activity.RESULT_OK, intent);
            } else {
                getParent().setResult(Activity.RESULT_OK, intent);
            }
            this.finish();

        }else{
            Toast.makeText(this,"Your Task Cannot be Empty...", Toast.LENGTH_SHORT).show();
        }


    }

}
