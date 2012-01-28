package ugtug.lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class StorageActivity extends Activity {

	private static final String TAG = StorageActivity.class.getSimpleName();

	private ImageView imageView;
	private Bitmap bitmap;
	private final String name = "mandelbrot.jpg";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        setContentView(R.layout.storage);

		imageView = (ImageView) findViewById(R.id.imageView1);
		
		DownloadWebPageTask task = new DownloadWebPageTask();
		task.execute(new String[] { "http://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Mandel_zoom_00_mandelbrot_set.jpg/322px-Mandel_zoom_00_mandelbrot_set.jpg" });

	}
	
	private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String[] urls) {
			try {
				DefaultHttpClient hc = new DefaultHttpClient();

				HttpGet get = new HttpGet(urls[0]);
				HttpResponse httpResponse = hc.execute(get);
				HttpEntity entity = httpResponse.getEntity();
				byte[] bytes = EntityUtils.toByteArray(entity);
				
				FileOutputStream fos = openFileOutput(name, Context.MODE_PRIVATE);
				fos.write(bytes);
				fos.close();
				
				final byte in[] = new byte[bytes.length];
				
			    FileInputStream fis = openFileInput(name);
			    fis.read(in);
			    fis.close();
			    
			    BitmapFactory.Options options = new BitmapFactory.Options();
			    bitmap = BitmapFactory.decodeByteArray(in, 0, in.length, options);

				if(bitmap != null) {
					runOnUiThread(new Runnable() {
						public void run() {
							imageView.setImageBitmap(bitmap);
						}
					});
				}
			} 
			catch (Exception e) {
				Log.e(TAG, "Error downloading file: " + e.getMessage(), e);
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
		}
	}
}
