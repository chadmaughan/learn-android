package ugtug.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.v(TAG, "onCreate()");
    	Toast.makeText(getApplicationContext(), "MainActivity onCreate()", Toast.LENGTH_LONG).show();

        Button sum = (Button) findViewById(R.id.otherActivityButton);
        sum.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

            	Toast.makeText(getApplicationContext(), "Launching OtherActivity", Toast.LENGTH_LONG).show();
            	
				Intent otherIntent = new Intent(MainActivity.this, OtherActivity.class);
				otherIntent.putExtra("message", "Hello from MainActivity");
				startActivity(otherIntent);

			}
		});
    }

    @Override
    protected void onPause() {
    	super.onPause();
        Log.v(TAG, "onPause()");
    	Toast.makeText(getApplicationContext(), "MainActivity onPause()", Toast.LENGTH_LONG).show();
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
        Log.v(TAG, "onStart()");
    	Toast.makeText(getApplicationContext(), "MainActivity onStart()", Toast.LENGTH_LONG).show();
    }
    
}