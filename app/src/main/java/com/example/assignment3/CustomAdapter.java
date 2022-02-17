package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    String[] myNames;
    String[] address;
    String[] faculty;
    int[] semester;

    public CustomAdapter(StudentActivity s, String[] name, String[] address,
                         String[] faculty,
                         int[] semester){
        c=s;
        myNames=name;
        this.address=address;
        this.faculty=faculty;
        this.semester=semester;

}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutinflate, findViewById
        View convertView= LayoutInflater.from(c).inflate(R.layout.single_item,null);
        MyViewHolder viewHolder=new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //settext,dataset
        holder.tv.setText(myNames[position]);
        holder.av.setText(address[position]);
        holder.fv.setText(faculty[position]);
        holder.sv.setText(String.valueOf(semester[position]));



    }

    @Override
    public int getItemCount() {
        return myNames.length;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv,av,fv,sv;
        public MyViewHolder(View convertView){
            super(convertView);
            tv=convertView.findViewById(R.id.tv);
            av=convertView.findViewById(R.id.av);
            fv=convertView.findViewById(R.id.fv);
            sv=convertView.findViewById(R.id.sv);




            //convertView=layoutInflater......>OnCreateViewHolder.......convertView
            //TextView tv=convertView.findViewById()-->ViewHolder class----convertView

        }

    }
}

