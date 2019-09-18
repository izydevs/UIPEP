package com.uipep.amit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
    private List<Item> myList = new ArrayList<>();

    public ItemAdapter(Context context, List<Item> myList) {
        this.context = context;
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Item item = myList.get(i);
        myViewHolder.itemId.setText(MessageFormat.format("{0}", item.getId()));
        myViewHolder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemId;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.item_id);
            name = itemView.findViewById(R.id.item_name);
        }
    }
}
