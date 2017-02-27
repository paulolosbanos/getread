package com.finalproject.uread.topic.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproject.uread.R;
import com.finalproject.uread.topic.main.models.Read;

import java.util.List;

/**
 * Created by paulo.losbanos on 16/02/2017.
 */

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.RAViewHolder> {

    private List<Read> readList;

    public ReadAdapter(List<Read> readList) {
        this.readList = readList;
    }

    public void swap(List<Read> datas){
        readList.clear();
        readList.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public RAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_read, parent, false);

        return new RAViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RAViewHolder holder, int position) {
        Read read = readList.get(position);
        holder.title.setText(read.getTitle());
    }

    @Override
    public int getItemCount() {
        return readList.size();
    }

    public class RAViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public RAViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

}
