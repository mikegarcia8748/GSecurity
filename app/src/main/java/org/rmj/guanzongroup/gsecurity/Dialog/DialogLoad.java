package org.rmj.guanzongroup.gsecurity.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.textview.MaterialTextView;

import org.rmj.guanzongroup.gsecurity.R;


public class DialogLoad {
    private AlertDialog poDialogx;
    private final Context context;
    private static boolean isShown;
    public DialogLoad(Context context) {
        this.context = context;
}
    public void initDialog(String Title, String Message, boolean Cancellable){
        AlertDialog.Builder poBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.loaddialog, null);
        poBuilder.setCancelable(false)
                .setView(view);
        poDialogx = poBuilder.create();
        poDialogx.setCancelable(Cancellable);
        MaterialTextView lblTitle = view.findViewById(R.id.progress);
        lblTitle.setText(Title);
        MaterialTextView lblMsgxx = view.findViewById(R.id.progress);
        lblMsgxx.setText(Message);
    }

    public void show() {
        if (!isShown) {
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = R.style.FadeInAnimation; // Replace with your custom animation style
            poDialogx.show();
            isShown = true;
        }
    }

    public void dismiss(){
        if(poDialogx != null && poDialogx.isShowing()){
            poDialogx.dismiss();
            isShown = false;
        }
    }
}

