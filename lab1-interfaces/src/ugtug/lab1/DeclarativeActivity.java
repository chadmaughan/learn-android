package ugtug.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeclarativeActivity extends Activity {

	private EditText first;
	private EditText second;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);

        setContentView(R.layout.declarative);

    	first = (EditText) findViewById(R.id.firstNumber);
    	second = (EditText) findViewById(R.id.secondNumber);
    	
        Button sum = (Button) findViewById(R.id.sumButton);
        sum.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				String firstString = first.getText().toString().trim();
				String secondString = second.getText().toString().trim();
				
				if(!firstString.equals("") && !secondString.equals("")) {
					int firstInt = Integer.parseInt(firstString);
	            	int secondInt = Integer.parseInt(secondString);
	
	            	int sum = firstInt + secondInt;
	            	
	            	Toast.makeText(getApplicationContext(), "Sum is: " + sum, Toast.LENGTH_LONG).show();
				}            	
			}
		});
    }
}