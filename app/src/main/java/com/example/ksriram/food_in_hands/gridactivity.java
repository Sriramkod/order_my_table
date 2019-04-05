package com.example.ksriram.food_in_hands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

public class gridactivity extends AppCompatActivity {
    List<String> list;
    int[] imageId = {
            R.drawable.im9,
            R.drawable.im,
            R.drawable.im2,
            R.drawable.im3,
            R.drawable.im4,
            R.drawable.im10,R.drawable.im13,R.drawable.im14,R.drawable.im15,R.drawable.im16,
    };
    String[] web = {
            "Ashoka",
            "City Grand",
            "Landmark",
            "Suprabha",
            "Raj",
            "Hotel",
            "Vivanta",
            "Avasa",
            "Haritha kakatiya",
            "Novotel",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    } ;
    String[] web1 = {
            "Situated at Warangal West,beside Ashoka theatre ",
            "Situated at Warangal West,JPN ROAD",
            "Situated at Warangal West,Nakkalagutta",
            "Situated at Warangal West,Nakkalagutta",
            "Situated at Warangal West,beside Ashoka theatre,Raj",
            "Situated at Warangal West,beside Ashoka theatre,Hotel",
            "Situated at Hyderabad,beside Ashoka theatre Vivanta",
            "Situated at Hyderabad,beside Ashoka theatre Avasa",
            "Haritha kakatiya",
            "Novotel",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridactivity);
        grid_adapter adapter = new grid_adapter(gridactivity.this,web,imageId,web1);
        GridView grid=(GridView)findViewById(R.id.grid_view);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int imageRes = imageId[position];
String imagename = web[position];
String imgdes=web1[position];
                Intent intent = new Intent(gridactivity.this,finalActivity.class);
                intent.putExtra("IMAGE_RES", imageRes);
                intent.putExtra("Image_name",imagename);
intent.putExtra("Image_des",imgdes);
                startActivity(intent);
            }
        });

    }
}
