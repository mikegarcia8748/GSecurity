package org.rmj.guanzongroup.appdriver.Task;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    private static final String TAG = TaskExecutor.class.getSimpleName();

    public TaskExecutor(){

    }

    public static void Execute(OnTaskExecuteListener mListener){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                handler.post(mListener::OnPreExecute);

                //Background work here...
                Object loResult = mListener.DoInBackground();

                handler.post(() -> mListener.OnPostExecute(loResult));
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public static void Execute(OnDoBackgroundTaskListener mListener){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                //Background work here...
                Object loResult = mListener.DoInBackground();

                handler.post(() -> mListener.OnPostExecute(loResult));
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public interface OnShowProgress{
        void OnProgress();
    }

    public static void ShowProgress(OnShowProgress listener){
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(() -> listener.OnProgress());
    }
}
