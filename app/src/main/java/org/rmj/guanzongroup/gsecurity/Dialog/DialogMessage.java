package org.rmj.guanzongroup.gsecurity.Dialog;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.textview.MaterialTextView;

import org.rmj.guanzongroup.gsecurity.R;

import java.util.Objects;

public class DialogMessage {

}

    private AlertDialog poDialogx;
    private MaterialButton btnPositive;
    private MaterialButton btnNegative;
    private MaterialTextView lblTitle;
    private MaterialTextView lblMsgxx;
    private MaterialDivider midBorder;

    private final Context context;

    public DialogMessage(Context context){
        // Must be, at all times, pass Activity Context.
        this.context = Objects.requireNonNull(context);
    }
    @SuppressLint("MissingInflatedId")
    public void initDialog(){
        AlertDialog.Builder poBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.messagedialog, null);
        poBuilder.setCancelable(false)
                .setView(view);
        poDialogx = poBuilder.create();
        poDialogx.setCancelable(false);

        lblTitle = view.findViewById(R.id.title);
        btnPositive = view.findViewById(R.id.btnPositive);
        btnPositive.setVisibility(View.GONE);
        btnNegative = view.findViewById(R.id.btnNegative);
        midBorder.setVisibility(View.GONE);
        btnNegative.setVisibility(View.GONE);
    }

    public void setMessage(String psMessage) {
        try {
            lblMsgxx.setText(Objects.requireNonNull(psMessage));
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    public void setTitle(String psTitlexx) {
        try {
            lblTitle.setText(Objects.requireNonNull(psTitlexx));
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setPositiveButton(String psBtnPost, final DialogButton listener) {
        btnPositive.setVisibility(View.VISIBLE);
        btnPositive.setText(psBtnPost);
        btnPositive.setOnClickListener(view -> {
            listener.OnButtonClick(view, poDialogx);
//            isDialogShown = false;
        });
    }

    public void setNegativeButton(String psBtnNegt, final DialogButton listener) {
        midBorder.setVisibility(View.VISIBLE);
        btnNegative.setVisibility(View.VISIBLE);
        btnNegative.setText(psBtnNegt);
        btnNegative.setOnClickListener(view -> {
            listener.OnButtonClick(view, poDialogx);
//            isDialogShown = false;
        });
    }



    public void show() {
        if(!poDialogx.isShowing()) {
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    public interface DialogButton{
        void OnButtonClick(View view, AlertDialog dialog);
    }
}