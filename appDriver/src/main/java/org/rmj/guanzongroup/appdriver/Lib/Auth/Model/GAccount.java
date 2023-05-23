package org.rmj.guanzongroup.appdriver.Lib.Auth.Model;

public interface GAccount {

    /**
     *
     * @param args pass required object for processing information
     * @return 0 = process failed, 1 = process succeed;
     */
    int DoAction(Object args);

    /**
     *
     * @return message if DoAction(Object args) process failed.
     */
    String getMessage();
}
