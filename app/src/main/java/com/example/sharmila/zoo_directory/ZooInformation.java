package com.example.sharmila.zoo_directory;

/**
 * Created by sharmila on 1/29/2016.
 */


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ZooInformation extends Activity {
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_info);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:08888888888"));
                //if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                startActivity(callIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem items) {

        super.onOptionsItemSelected(items);

        switch(items.getItemId()){
            case R.id.zoo_info:
                final Intent intent = new Intent(ZooInformation.this, ZooInformation.class);
                startActivity(intent);
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:"+"com.example.sharmila.zoo_directory"));
                startActivity(uninstall);
                break;
        }
        return true;
    }
}

