package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Sajjad on 2017-09-14.
 */

import java.util.Date;

public class HappyMood extends Mood {
    public HappyMood() {
        super();
    }
    public HappyMood(Date date) {
        super(date);
    }
    public String getMood() {
        return "Happy";
    }
}
