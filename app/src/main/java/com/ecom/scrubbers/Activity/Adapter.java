/*
package com.ecom.scrubbers.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ecom.scrubbers.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Models> modelsList;

    public Adapter(Context context, List<Models> modelsList) {
        this.context = context;
        this.modelsList = modelsList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_view, viewGroup, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder myViewHolder, int i) {
        Models m = modelsList.get(i);
        myViewHolder.textView.setText(m.getDescription());
        Glide.with(context).load(m.getImage()).into(myViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_adp);
            imageView = itemView.findViewById(R.id.img_adp);
        }
    }
}
*/
