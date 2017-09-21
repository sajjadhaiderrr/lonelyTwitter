package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

=======
>>>>>>> 3895f9be75e6bc380ee155c921852ae04f3ac64c
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
=======
import java.util.ArrayList;
import java.util.Date;
>>>>>>> 3895f9be75e6bc380ee155c921852ae04f3ac64c

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);


        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tweets.clear();
                adapter.notifyDataSetChanged();
            }
        });


		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
<<<<<<< HEAD

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
                saveInFile(); // Lab 3

				//saveInFile(text, new Date(System.currentTimeMillis()));

				//Tweet tweet = new ImportantTweet("");
                //Tweet tweet1 = new NormalTweet("Hi");

                //try {
				//	tweet.setMessage("Hello");
				//} catch (TweetTooLongException e) {
				//}

				//Tweetable tweet3 = new ImportantTweet("");
                //ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
                //tweetList.add(tweet);
                //tweetList.add(tweet1);
=======
				saveInFile(text, new Date(System.currentTimeMillis()));

				Tweet tweet = new ImportantTweet("");
                Tweet tweet1 = new NormalTweet("Hi");

                try {
					tweet.setMessage("Hello");
				} catch (TweetTooLongException e) {
				}

				Tweetable tweet3 = new ImportantTweet("");
                ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
                tweetList.add(tweet);
                tweetList.add(tweet1);
>>>>>>> 3895f9be75e6bc380ee155c921852ae04f3ac64c
				//Log.d("", "The isImportant method returns " + tweet.isImportant());
                //Log.d("", "The isImportant method returns " + tweet.isImportant());


                //finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
        loadFromFile(); // Lab 3
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() { // Removed parameters in Lab 3
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            /*
             * Added this on Sep 20 for Lab 3
             */

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

            /*
             * End modification here
             */

            //String line = in.readLine();
			//while (line != null) {
				//tweets.add(line);
				//line = in.readLine();
			//}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>(); // Lab 3
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); // Lab 3
		}
	}
	
	private void saveInFile() { // Removed parameters in Lab 3
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE); // Changed to MODE_PRIVATE from MODE_APPEND in Lab3
            OutputStreamWriter writer = new OutputStreamWriter(fos); // Lab 3
            Gson gson = new Gson(); // Lab 3
            gson.toJson(tweets, writer); // Lab 3
            writer.flush(); // Lab 3

			//fos.write(new String(date.toString() + " | " + text)
					//.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}