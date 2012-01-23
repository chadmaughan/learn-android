package ugtug.lab1;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProgrammaticActivity extends Activity {

	private LinearLayout linearLayout;
	
	private TextView firstLabel;
	private EditText first;

	private TextView secondLabel;
	private EditText second;

	private Button sumButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		this.setTitle("Programmatic");

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

		linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        
        firstLabel = new TextView(this);
        firstLabel.setText("First Number:");
        linearLayout.addView(firstLabel);

        first = new EditText(this);
        first.setText("");
        first.setLayoutParams(lp);
        first.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(first);
        
        secondLabel = new TextView(this);
        secondLabel.setText("Second Number:");
        linearLayout.addView(secondLabel);

        second = new EditText(this);
        second.setText("");
        second.setLayoutParams(lp);
        second.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(second);

        sumButton = new Button(this);
        sumButton.setText("Sum");
        sumButton.setOnClickListener(new View.OnClickListener() {
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
        
        linearLayout.addView(sumButton);
        
        setContentView(linearLayout);

	}
}
