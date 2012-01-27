package ugtug.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.v(TAG, Integer.toString(item.getItemId()));
		
		switch(item.getItemId()) {
		
			case R.id.preferences:
				Intent preferencesActivity = new Intent(getBaseContext(), PreferencesActivity.class);
				startActivity(preferencesActivity);
				break;

			case R.id.internal:
				Intent internalStorageActivity = new Intent(getBaseContext(), InternalStorageActivity.class);
				startActivity(internalStorageActivity);
				break;

			default:
				break;
		}

		return true;
	}
}