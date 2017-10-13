package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by Sajjad on 2017-10-11.
 */

public class TweetList {

    private int mCount;

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList() {
    };

    public void add(Tweet tweet) {
        tweets.add(tweet);
        this.mCount +=1;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return mCount;
    }


}
