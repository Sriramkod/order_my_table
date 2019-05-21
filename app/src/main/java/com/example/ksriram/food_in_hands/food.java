package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        /*final TextView textView= (TextView)findViewById(R.id.textView);
        textView.setText(" "+getIntent().getStringExtra("imagename")+"!");
        */
        ImageView imageView1 = (ImageView)findViewById(R.id.india);
        ImageView imageView2 = (ImageView)findViewById(R.id.chinese);
        ImageView imageView3 = (ImageView)findViewById(R.id.french);
        imageView1.setOnClickListener(new View.OnClickListener() {
          String imagename = getIntent().getStringExtra("imagename");
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(food.this, order1.class);
                intent.putExtra("imagename",imagename);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            String imagename = getIntent().getStringExtra("imagename");
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(food.this, order1.class);
                intent.putExtra("imagename",imagename);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            String imagename = getIntent().getStringExtra("imagename");
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(food.this, order1.class);
                intent.putExtra("imagename",imagename);
                startActivity(intent);
            }
        });


    }
}
