package com.example.mikotest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mikotest.R;
import com.example.mikotest.modal.Records;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    Context context;
    List<Records> recordsList;
    public MyAdapter(Context context, List<Records> recordsList) {
        this.context=context;
        this.recordsList=recordsList;
    }

    public MyAdapter() {

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.itemrecyclerview,parent,false);
        MyviewHolder myviewHolder = new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        Records records = recordsList.get(position);
        holder.title.setText(records.getTitle());
        holder.shortDesc.setText(records.getShortDescription());
       holder.valFund.setText(""+records.getCollectedValue());
        holder.valGoals.setText(""+records.getTotalValue());
        Glide.with(context).load(records.getMainImageURL()).into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView title,shortDesc,valFund,valGoals,valEndsIn, valPercent;
        Button pledge;
        ImageView topImage;

        public MyviewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.textTitle);
            shortDesc = view.findViewById(R.id.shortDesc);
            valFund = view.findViewById(R.id.valfunded);
            valGoals = view.findViewById(R.id.valgoals);
            valEndsIn = view.findViewById(R.id.valendsin);
            //valPercent = view.findViewById(R.id.p);
            pledge = view.findViewById(R.id.btnpledge);
            topImage = view.findViewById(R.id.topImage);

        }
        public ImageView getImage(){
            return this.topImage;}
    }
}
