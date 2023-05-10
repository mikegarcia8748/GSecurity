package org.rmj.guanzongroup.appdriver.Task;

public interface OnDoBackgroundTaskListener {
    Object DoInBackground();
    void OnPostExecute(Object object);
}
