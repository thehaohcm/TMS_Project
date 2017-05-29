package org.fsoft.tms;

/**
 * Created by DELL on 5/29/2017.
 */
public class CurrentUser {
    private static CurrentUser ourInstance = new CurrentUser();

    public static CurrentUser getInstance() {
        return ourInstance;
    }

    private CurrentUser() {
    }
}
