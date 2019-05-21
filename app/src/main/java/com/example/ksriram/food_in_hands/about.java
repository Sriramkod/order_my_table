package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {
Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
order=(Button)findViewById(R.id.order);
order.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      Intent intent = new Intent(about.this, order.class);
        startActivity(intent);
    }
});
    }
}
