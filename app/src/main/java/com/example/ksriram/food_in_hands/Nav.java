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
Bundle extras = getIntent().getExtras();
TextView textView= (TextView)findViewById(R.id.textView);
textView.setText(getIntent().getStringExtra("Image_name"));
        Button startButton = (Button)findViewById(R.id.btn);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                Intent intent = new Intent(Nav.this, details.class);

                startActivity(intent);

            }

        });
        /* viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);*/
    }

}
