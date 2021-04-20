package com.example.landstars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Data

        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa Tower");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colesseo");
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eyfel);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colezyum);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colleseo);
        landmarkImages.add(londonBridge);


        // ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // System.out.println(landmarkNames.get(position));
               // System.out.println(countryNames.get(position));


                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(position));
                intent.putExtra("country",countryNames.get(position));
                //selectedImage = landmarkImages.get(position);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));

                startActivity(intent);
            }
        });

    }
}