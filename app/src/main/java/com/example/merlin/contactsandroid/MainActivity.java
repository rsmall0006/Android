package com.example.merlin.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView list;
    EditText name;
    EditText phone;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editName);
        phone = (EditText) findViewById(R.id.editPhone);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String item = name.getText().toString() + " (" + phone.getText().toString() + ")";
//        String item2 = phone.getText().toString();
        items.add(item);
//        items.add(item2);
        name.setText("");
        phone.setText("");
        //this ("") above ensures that they must enter at least some text before they are able to add anything??
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
        String item = items.getItem(position);
        items.remove(item);
        return true;

    }
}