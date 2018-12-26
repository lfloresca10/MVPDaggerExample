package com.louiefloresca.mvpdaggerexample.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.louiefloresca.mvpdaggerexample.R;
import com.louiefloresca.mvpdaggerexample.data.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private List<Result.Data> mList;

    public MainActivityAdapter(List<Result.Data> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Glide.with(viewHolder.mContext)
                .load(mList.get(position).getImages().getPreview().getUrl())
                .centerCrop()
                .into(viewHolder.mImage);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addItems(List<Result.Data> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        @BindView(R.id.img_image)
        ImageView mImage;

        public Context mContext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
    }

}
