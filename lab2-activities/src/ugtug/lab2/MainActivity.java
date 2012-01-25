package ugtug.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button sum = (Button) findViewById(R.id.otherActivityButton);
        sum.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
	            	
            	Toast.makeText(getApplicationContext(), "Other Activity", Toast.LENGTH_LONG).show();
            	
				Intent otherIntent = new Intent(MainActivity.this, OtherActivity.class);
				otherIntent.putExtra("message", "Hello from MainActivity");
				startActivity(otherIntent);

			}
		});
    }
}