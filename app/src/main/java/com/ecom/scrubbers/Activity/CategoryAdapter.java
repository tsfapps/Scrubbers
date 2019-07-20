package com.ecom.scrubbers.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ecom.scrubbers.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private List<ModelCategory> modelCategories;

    private OnHomeClkListener tOnHomeClkListener;

    public CategoryAdapter(Context context, List<ModelCategory> modelCategories) {
        this.context = context;
        this.modelCategories = modelCategories;
    }


    public interface OnHomeClkListener {
        public void OnClkHome(int pos);
    }


    public void setOnHomeClkListener(OnHomeClkListener onHomeClkListener) {
        tOnHomeClkListener = onHomeClkListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landing, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int i) {
        ModelCategory modelCategory = modelCategories.get(i);

        String strImage = Constant.IMAGE_URL +modelCategory.getImages();

        viewHolder.textView.setText(modelCategory.getName());
        Glide.with(context).load(strImage).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cat_img);
            textView = itemView.findViewById(R.id.cat_text);
            linearLayout = itemView.findViewById(R.id.ll);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   Intent intent = new Intent(v.getContext(), PickupActivity.class);
                    v.getContext().startActivity(intent);

                }
            });

        }
    }
}
