package com.example.sharmila.zoo_directory;


        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.view.View.OnClickListener;
        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.List;


public class MainActivity extends Activity {

    private List<Animal> myDessert = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalList();
        listView();
        clickFunction();

    }


    private void animalList(){
        myDessert.add(new Animal(R.drawable.blueberrycake, "Blue Berry Cake", "Classic vanilla sponge with fresh blue berry and strawberry. Perfect for any occasion "));
        myDessert.add(new Animal(R.drawable.buncake, "vanilla Bun Cake", "Classic bun cake is a light sponge cake. perfect for tea time snack for any hig tea"));
        myDessert.add(new Animal(R.drawable.cheesecake, "Cheese Cake", "Made with cream cheese and wipped cream. Famous for it creamy texture and impeccable taste"));
        myDessert.add(new Animal(R.drawable.tiramisu, "Tiramisu", "Coffee Flavoured lady finger with coffee flavor custard arranged in layer and topped with fresh wipped cream"));
        myDessert.add(new Animal(R.drawable.swissroll, "Swiss Roll", "Rolled vanilla sponge with cream cheese or wipped cream filling. Kids love this! "));
    }

    private void clickFunction(){


        ListView listView = (ListView) findViewById(R.id.animalsList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Animal clickedAnimal = myDessert.get(position);
                final Intent intent = new Intent(MainActivity.this, AnimalInformation.class);
                intent.putExtra("animal", clickedAnimal);

                //set alert dialogue at the last position

                if (position == 4) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    // set title
                    alertDialogBuilder.setTitle("Warning");

                    // set dialog message'
                    alertDialogBuilder
                            .setMessage("This Dessert it too sweet! Do you want to proceed?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(intent);
                                }

                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }

                            });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                } else {
                    startActivity(intent);
                }
            }
        });
    }


    private void listView(){
        ArrayAdapter<Animal> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.animalsList);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Animal>{
        public MyListAdapter(){
            super(MainActivity.this,R.layout.animal_list,myDessert);
        }
        @Override
        public View getView(int postion,View convertView, ViewGroup parent){
            View itemView = convertView;

            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.animal_list,parent,false);
            }


            Animal currentAnimal = myDessert.get(postion);


            ImageView imageView = (ImageView) itemView.findViewById(R.id.imgIcon);
            imageView.setImageResource(currentAnimal.getImage());


            TextView txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtTitle.setText(currentAnimal.getName());
            return itemView;


        }


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
                final Intent intent = new Intent(MainActivity.this, ZooInformation.class);
                startActivity(intent);
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                uninstall.setData(Uri.parse("package:"+"com.example.shamila.zoo_directory"));
                startActivity(uninstall);
                break;
        }
        return true;
    }

}

