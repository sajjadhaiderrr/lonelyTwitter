package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }
    public void testTweet(){
        solo.assertCurrentActivity("Not LonelyTwitterActivity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Solo test tweet");
        solo.clickOnButton("Save");
        assertTrue(solo.waitForText("Solo test tweet"));
        solo.clickOnButton("Clear");
    }

    public void testEditFromTweetList(){
        solo.assertCurrentActivity("Not LonelyTwitterActivity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body), "Solo test tweetlist");
        solo.clickOnButton("Save");
        assertTrue(solo.waitForText("Solo test tweetlist"));
        solo.clickInList(0);
        solo.assertCurrentActivity("Failed to reach EditTweetActivity", EditTweet.class);
    }

    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}