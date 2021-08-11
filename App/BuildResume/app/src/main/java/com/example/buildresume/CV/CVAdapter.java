package com.example.buildresume.CV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildresume.R;

import java.util.List;

public class CVAdapter extends RecyclerView.Adapter<CVAdapter.CVViewHolder> {

        List<CVitem> mdata;

    public CVAdapter(List<CVitem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public CVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv, parent,false);
        return new CVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CVViewHolder holder, int position) {
        holder.Cvtitle.setText(mdata.get(position).getTitle());
        holder.CvDescription.setText(mdata.get(position).getDescription());

        holder.imageView.setOnClickListener(v -> {
            mdata.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class CVViewHolder extends RecyclerView.ViewHolder{
        TextView Cvtitle,CvDescription;
        ImageView imageView;

    public CVViewHolder(@NonNull View itemView) {
        super(itemView);
        Cvtitle=itemView.findViewById(R.id.cv_title);
        CvDescription=itemView.findViewById(R.id.cv_description);
        imageView = itemView.findViewById(R.id.remove_image);
    }

  }
}
