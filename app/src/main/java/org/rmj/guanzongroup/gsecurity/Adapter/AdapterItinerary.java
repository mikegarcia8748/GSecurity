package org.rmj.guanzongroup.gsecurity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import org.rmj.guanzongroup.gsecurity.R;

import java.util.List;

public class AdapterItinerary extends RecyclerView.Adapter<AdapterItinerary.VHPersonnels> {

    private final List<String> poPersonnels;

    public AdapterItinerary(List<String> poPersonnels) {
        this.poPersonnels = poPersonnels;
    }

    @NonNull
    @Override
    public VHPersonnels onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personnels, parent, false);
        return new VHPersonnels(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHPersonnels holder, int position) {
        String lsPersonnel = poPersonnels.get(position);
        holder.lblPersonx.setText(lsPersonnel);
    }

    @Override
    public int getItemCount() {
        return poPersonnels.size();
    }

    public static class VHPersonnels extends RecyclerView.ViewHolder {

        public MaterialTextView lblPersonx;

        public VHPersonnels(@NonNull View itemView) {
            super(itemView);
            lblPersonx = itemView.findViewById(R.id.lbl_personnel);
        }
    }
}
