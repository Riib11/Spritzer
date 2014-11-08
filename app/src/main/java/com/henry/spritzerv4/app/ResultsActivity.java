package com.henry.spritzerv4.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResultsActivity extends Activity {

	String outputPath;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		tv = new TextView(this);
		setContentView(tv);

		String imageUrl = "unknown";

		Bundle extras = getIntent().getExtras();
		if( extras != null) {
			imageUrl = extras.getString("IMAGE_PATH" );
			outputPath = extras.getString( "RESULT_PATH" );
		}

		// Starting recognition process
		new AsyncProcessTask(this).execute(imageUrl, outputPath);
	}

	public void updateResults() {
		try {
//            File dd = Environment.getDataDirectory();
//            File dwnDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//            File resultFile = new File(dwnDir,"result.txt");
//            FileWriter fw = new FileWriter(resultFile);
            //displayMessage(dwnDir.getAbsolutePath());

			StringBuffer contents = new StringBuffer();
			FileInputStream fis = openFileInput(outputPath);
			Reader reader = new InputStreamReader(fis, "UTF-8");
			BufferedReader bufReader = new BufferedReader(reader);
			String text = null;
			while ((text = bufReader.readLine()) != null) {
				contents.append(text).append(System.getProperty("line.separator"));
//                fw.write(text);
//                fw.write("\n");
			}
//            fw.close();
			displayMessage(contents.toString());
		} catch (Exception e) {
			displayMessage("Error: " + e.getMessage());
		}
	}
    // /storage/emulated/0/Download

	private void displayMessage( String text )
	{
		tv.post( new MessagePoster( text ) );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(android.R.menu.activity_results, menu);
		return true;
	}

	class MessagePoster implements Runnable {
		public MessagePoster( String message )
		{
			_message = message;
		}

		public void run() {
			tv.append( _message + "\n" );
			setContentView( tv );
		}

		private final String _message;
	}
}
