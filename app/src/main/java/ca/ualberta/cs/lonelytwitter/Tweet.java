package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Sajjad on 2017-09-13.
 */

public abstract class Tweet implements Tweetable{

    protected String message;
    protected Date date;

    public Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    public Tweet(String message, Date date) {
        this.date = date;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140) {
            this.message = message;
        }
        else {
            throw new TweetTooLongException();
        }
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
=======
>>>>>>> 3895f9be75e6bc380ee155c921852ae04f3ac64c

    public abstract Boolean isImportant();
}

