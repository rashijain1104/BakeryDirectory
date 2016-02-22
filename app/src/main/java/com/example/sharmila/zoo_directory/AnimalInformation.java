package com.example.sharmila.zoo_directory;

/**
 * Created by sharmila on 1/29/2016.
 */


import android.app.Activity;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AnimalInformation extends Activity {

    ImageView imageView;
    TextView animalName;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info);


        Intent intent = getIntent(); //catching data from main activity


        Animal animal = (Animal) intent.getSerializableExtra("animal"); //putextra


        imageView = (ImageView) findViewById(R.id.imageView);
        animalName = (TextView) findViewById(R.id.animal_name);
        description = (TextView) findViewById(R.id.description);


        imageView.setImageResource(animal.getImage()); //setting the data
        animalName.setText(animal.getName());
        description.setText(animal.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem items) {  //option menu bar

        super.onOptionsItemSelected(items);

        switch (items.getItemId()) {
            case R.id.zoo_info:
                final Intent intent = new Intent(AnimalInformation.this, ZooInformation.class);
                startActivity(intent);


                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:" + "com.example.sharmila.zoo_directory"));
                startActivity(uninstall);

                break;


        }
        return true;

    }
}


