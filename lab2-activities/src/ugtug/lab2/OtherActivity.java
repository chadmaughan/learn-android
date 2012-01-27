package ugtug.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends Activity {

	private static final String TAG = OtherActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);

        Log.v(TAG, "onCreate()");
    	Toast.makeText(getApplicationContext(), "OtherActivity onCreate()", Toast.LENGTH_LONG).show();

		Intent intent = this.getIntent();
		String message = intent.getExtras().getString("message");

		TextView textView = (TextView) findViewById(R.id.otherTextView);
		textView.setText(message);
	}
	
    @Override
    protected void onPause() {
    	super.onPause();
        Log.v(TAG, "onPause()");
    	Toast.makeText(getApplicationContext(), "OtherActivity onPause()", Toast.LENGTH_LONG).show();
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
        Log.v(TAG, "onStart()");
    	Toast.makeText(getApplicationContext(), "OtherActivity onStart()", Toast.LENGTH_LONG).show();
    }

}
