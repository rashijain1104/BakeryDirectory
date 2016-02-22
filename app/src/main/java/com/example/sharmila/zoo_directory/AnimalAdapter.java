package com.example.sharmila.zoo_directory;

/**
 * Created by sharmila on 1/29/2016.
 */


        import android.app.Activity;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;


public class AnimalAdapter extends ArrayAdapter<Animal>{

    Context con;
    int layoutId;
    Animal data[] = null;

  public AnimalAdapter(Context con, int layoutId, Animal[] data){
      super(con, layoutId, data);
      this.layoutId = layoutId;
      this.con = con;
       this.data = data;
 }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
  AnimalHolder holder = null;

      if(row == null){
            LayoutInflater inflater = ((Activity)con).getLayoutInflater();
            row = inflater.inflate(layoutId, parent, false);

            holder = new AnimalHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }

     else{
        holder = (AnimalHolder)row.getTag();
   }

       Animal animal = data[position];

        return row;
    }



  static class AnimalHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
