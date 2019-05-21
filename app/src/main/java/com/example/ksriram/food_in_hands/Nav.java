package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Nav extends AppCompatActivity {

    ViewPager viewPager;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        TextView textViewr = (TextView)findViewById(R.id.textView3);
        TextView textViewl = (TextView)findViewById(R.id.textView6);
        Random rand = new Random();
        int n = rand.nextInt(40);
        Random rand1 = new Random();
        int n1 = rand1.nextInt(20);
        textViewl.setText("Reserved tables:"+n1);
        textViewr.setText("No of tables left for reserving:"+n);

        Bundle extras = getIntent().getExtras();
final TextView textView= (TextView)findViewById(R.id.textView);
        textView.setText(" "+getIntent().getStringExtra("imagename")+"!");
        //textView.setText(getIntent().getStringExtra("imagename"));
        Button startButton = (Button)findViewById(R.id.btn);
        Button start = (Button)findViewById(R.id.button3);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String imagename= textView.getText().toString();

                Intent intent = new Intent(Nav.this, order1.class);
                intent.putExtra("imagename",imagename);
                startActivity(intent);

            }

        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String imagename= textView.getText().toString();
                String imagename= getIntent().getStringExtra("imagename");
                Intent intent = new Intent(Nav.this, food.class);
                intent.putExtra("imagename",imagename);
                startActivity(intent);
            }
        });

        /* viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);*/
    }

}
