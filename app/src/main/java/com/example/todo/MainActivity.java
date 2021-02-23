package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        editText = findViewById(R.id.id_edit_text);


    }

    public void addItemToList(View view) {
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, "Item Added", Toast.LENGTH_SHORT).show();


        editText.setText("");
    }

    public void DeleteItemOfList(View view) {
        int j = 0;
        for (int i = 0; i < toDoList.size(); i++) {
            String getname = editText.getText().toString();
            if (toDoList.get(i).equals(getname)) {
                toDoList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                j = 1;
                Toast.makeText(MainActivity.this, "Item Removed", Toast.LENGTH_SHORT).show();
                break;

            }
        }
        if (j == 0) {
            Toast.makeText(MainActivity.this, "No Items Matched", Toast.LENGTH_SHORT).show();

        }


        editText.setText("");


    }
}