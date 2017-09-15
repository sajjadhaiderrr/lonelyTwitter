package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Sajjad on 2017-09-14.
 */

import java.util.Date;

public class SadMood extends Mood{
    public SadMood() {
        super();
    }
    public SadMood(Date date) {
        super(date);
    }
    public String getMood() {
        return "Sad";
    }
}
