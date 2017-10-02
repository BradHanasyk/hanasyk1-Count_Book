package com.example.brad.counter;

//Citations:
//https://github.com/survivingwithandroid/Surviving-with-android/tree/master/SimpleList


import java.util.ArrayList;
        import java.util.List;

import android.os.Bundle;
        import android.app.Activity;
        import android.app.Dialog;
        import android.view.ContextMenu;
        import android.view.ContextMenu.ContextMenuInfo;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.AdapterContextMenuInfo;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;


public class MainActivity extends Activity {

    // The data to show
    List<Counter> countList = new ArrayList<Counter>();
    Adapter aAdpt;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();


        ListView lv = (ListView) findViewById(R.id.listOfCounters);
        aAdpt = new Adapter(countList, this);
        lv.setAdapter(aAdpt);

        // React to user clicks on item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                //short click intentionally left blank to divert functionality to long click

            }
        });

        registerForContextMenu(lv);
    }


    // Context menu on long click allows for all major functions
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

        Counter count =  aAdpt.getItem(aInfo.position);

        //basic functions

        menu.setHeaderTitle("Options for " + count.getName());
        menu.add(1, 2, 2, "Increment");
        menu.add(1, 3, 3, "Decrement");
        menu.add(1, 4, 4, "Revert to initial count");
        menu.add(1, 5, 5, "Details");
        menu.add(1, 6, 6, "Delete");

    }


    // This method is called when user selects an Item in the Context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) item.getMenuInfo();
        countList.remove(aInfo.position);
        aAdpt.notifyDataSetChanged();
        return true;
    }


    private void initList() {
    }


    // Handles click from user
    public void addCount(View view) {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.activity_newcounter);
        d.setTitle("Add counter");
        d.setCancelable(true);

        final EditText edit = (EditText) d.findViewById(R.id.editTextName);
        Button b = (Button) d.findViewById(R.id.confirmcounter);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String countName = edit.getText().toString();
                MainActivity.this.countList.add(new Counter(countName, 0));
                MainActivity.this.aAdpt.notifyDataSetChanged();
                d.dismiss();
            }
        });

        d.show();
    }


}


