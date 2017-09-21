package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Sajjad on 2017-09-14.
 */

public abstract class Mood {
    protected Date date;

    public Mood() {
        this.date = new Date();
    }
    public Mood(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    abstract public String getMood();
}
