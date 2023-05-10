package org.rmj.guanzongroup.appdriver.Task;

public interface OnLoadApplicationListener {
    Object DoInBackground();
    void OnProgress(int progress);
    void OnPostExecute(Object object);
}
