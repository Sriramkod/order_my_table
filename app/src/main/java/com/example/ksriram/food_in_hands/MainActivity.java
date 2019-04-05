package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    Spinner spinner;
    String[] SPINNERVALUES = {"WARANGAL","KARIMNAGAR","HYDERABAD"};
    String SpinnerValue;
    Button GOTO;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner =(Spinner)findViewById(R.id.spinner1);

        GOTO = (Button)findViewById(R.id.button1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);

        spinner.setAdapter(adapter);

        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                SpinnerValue = (String)spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        GOTO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                switch(SpinnerValue){

                    case "WARANGAL":
                        intent = new Intent(MainActivity.this, gridactivity.class);
                        startActivity(intent);
                        break;

                    case "KARIMNAGAR":
                        intent = new Intent(MainActivity.this, gridactivity.class);
                        startActivity(intent);
                        break;

                    case "HYDERABAD":
                        intent = new Intent(MainActivity.this, gridactivity.class);
                        startActivity(intent);
                        break;


                }
            }
        });
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
            if(id==R.id.settings){
                Toast.makeText(MainActivity.this,"This is Settings",Toast.LENGTH_SHORT).show();
                dl.closeDrawer(GravityCompat.START);
            }
                if (id == R.id.account) {

                    Toast.makeText(MainActivity.this, "This is mesg", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Nav.class);

                    startActivity(intent);

                }
                if(id==R.id.mycart){
                    Toast.makeText(MainActivity.this,"This is Settings",Toast.LENGTH_SHORT).show();

                }
                dl.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}