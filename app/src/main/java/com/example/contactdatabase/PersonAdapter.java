package com.example.contactdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jspecify.annotations.NonNull;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private ArrayList<Person> people;

    public  PersonAdapter(ArrayList<Person> people){
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position){
        holder.tvName.setText(people.get(position).getName());
        holder.tvDoB.setText(people.get(position).getDOB());
        holder.tvEmail.setText(people.get(position).getEmail());
    }

    @Override
    public int getItemCount(){
        return people.size();
    }

//    create ViewHolder for each item in RecyclerView
    public class PersonViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvDoB, tvEmail;

        public PersonViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDoB = itemView.findViewById(R.id.tvDoB);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
