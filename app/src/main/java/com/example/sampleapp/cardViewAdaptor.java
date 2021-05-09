package com.example.sampleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cardViewAdaptor extends RecyclerView.Adapter<cardViewAdaptor.MyViewHolder> {
    private List<cardViewModel> cardList;

    //init constructor for list
    public cardViewAdaptor(List<cardViewModel> cardList){
        this.cardList = cardList;
    }
    @NonNull
    @Override
    //creating the viewholder for the list item
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlistview, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    //binding the list item with textviewer
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        cardViewModel cardVmodel = cardList.get(position);
        holder.demTitle.setText(cardVmodel.getTitle());
        holder.demDes.setText(cardVmodel.getDescrp());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
    //init view
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView demTitle;
        private TextView demDes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            demTitle = itemView.findViewById(R.id.demo_title);
            demDes =itemView.findViewById(R.id.demo_description);
        }
    }
}
