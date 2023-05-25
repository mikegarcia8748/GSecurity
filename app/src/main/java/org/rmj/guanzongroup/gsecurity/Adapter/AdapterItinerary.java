package org.rmj.guanzongroup.gsecurity.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Handler;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import org.rmj.guanzongroup.gsecurity.Authentication.Activity_CreateAccount;
import org.rmj.guanzongroup.gsecurity.Authentication.Activity_Login;
import org.rmj.guanzongroup.gsecurity.Dialog.DialogMessage;
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

        // Set OnClickListener for the item view

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DialogMessage.class);
                v.getContext().startActivity(intent);
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
    }
}