package ugtug.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.other);

		Intent intent = this.getIntent();
		String message = intent.getExtras().getString("message");

		TextView textView = (TextView) findViewById(R.id.otherTextView);
		textView.setText(message);
	}
}
