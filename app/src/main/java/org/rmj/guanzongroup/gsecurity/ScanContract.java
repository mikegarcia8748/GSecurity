package org.rmj.guanzongroup.gsecurity;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ScanContract extends ActivityResultContract<I, O> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, I i) {
        return null;
    }

    @Override
    public O parseResult(int i, @Nullable Intent intent) {
        return null;
    }
}
