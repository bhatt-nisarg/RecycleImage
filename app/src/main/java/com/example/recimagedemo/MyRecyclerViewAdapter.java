package com.example.recimagedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Extend the adapter class to recyclerview.Adapter
//implement the unimplement method
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{

    ArrayList images;
    ArrayList text;
    Context context;

    //constructor for initialization
    public MyRecyclerViewAdapter(Context context, ArrayList images, ArrayList text){
        this.context = context;
        this.images = images;
        this.text = text;
    }


    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        //passing view to viewholder
        MyRecyclerViewAdapter.ViewHolder viewHolder = new MyRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {

        //typecast object to int type
       
        holder.imagesdata.setImageResource((Integer) images.get(position));

        holder.textdata.setText(text.get(position).toString());

        //remove item from recycleview
        holder.itemView.findViewById(R.id.close).setOnClickListener(view -> removeItem(position));

        //to view item
        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context,ViewActivity.class);
            i.putExtra("image",(Integer)images.get(position));
            i.putExtra("text",text.get(position).toString());
            context.startActivity(i);
        });


    }

    @Override
    public int getItemCount() {
        //returns number of item available in adapter
        return text.size();
    }

    //Initializing value
    public class ViewHolder extends RecyclerView.ViewHolder{
       public ImageView imagesdata;
        public  TextView textdata;
        public ViewHolder(View view) {
            super(view);
            imagesdata = (ImageView)view.findViewById(R.id.imageView);
            textdata = (TextView) view.findViewById(R.id.text);
        }
    }

    public void removeItem(int position){
        images.remove(position);
        text.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,text.size(),images.size());
    }
}
