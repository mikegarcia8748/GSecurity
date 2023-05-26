package org.rmj.guanzongroup.gsecurity.Adapter;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import org.rmj.guanzongroup.gsecurity.Dashboard.Activity_Dashboard;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showScanDialog(v);
            }
        });
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

    private void showScanDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.messagedialog, null);

        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        ImageButton btnCancel = dialogView.findViewById(R.id.cancelId);
        Button btnPositive = dialogView.findViewById(R.id.btnPositive);
        Button btnNegative = dialogView.findViewById(R.id.btnNegative);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(view.getContext(), Activity_Dashboard.class);
                view.getContext().startActivity(intent);
            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(view.getContext(), Activity_Dashboard.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}

