package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class finalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        final TextView  textView= (TextView)findViewById(R.id.textView1);
        final TextView  textView1= (TextView)findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        int imageRes = extras.getInt("IMAGE_RES");
        textView.setText(getIntent().getStringExtra("Image_name"));
        textView1.setText(getIntent().getStringExtra("Image_des"));
        image.setImageResource(imageRes);
        Button startButton = (Button)findViewById(R.id.button1);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String imagename= textView.getText().toString();
                Intent intent = new Intent(finalActivity.this, Nav.class);

                intent.putExtra("imagename",imagename);
                startActivity(intent);

            }

        });

    }
    }