package org.rmj.guanzongroup.appdriver.Task;

public interface OnTaskExecuteListener {
    void OnPreExecute();
    Object DoInBackground();
    void OnPostExecute(Object object);
}
