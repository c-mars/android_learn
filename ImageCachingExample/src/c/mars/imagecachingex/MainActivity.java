package c.mars.imagecachingex;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	final static String landscapesFolder = "landscapes";
	static String[] files;
	static AssetManager assets;
	ImageView imageView;  
	LinearLayout gallery;
	private ImageLoader imgLoader;
	Button button;
	String fileName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView = (ImageView)findViewById(R.id.imageView);
        gallery = (LinearLayout)findViewById(R.id.gallery);        
        assets = getAssets();
        imgLoader = new ImageLoader(this);
        button = (Button)findViewById(R.id.button);
        
        try {
			files = assets.list(landscapesFolder);
			if (files.length > 0) {
				fileName = landscapesFolder + "/" +  files[0];
				imgLoader.DisplayImage(fileName, imageView);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (files.length > 0) {
					imgLoader.DisplayImage(landscapesFolder + "/" +  files[0], imageView); 
				} else {
					Toast.makeText(getApplicationContext(), "There are no asset images", Toast.LENGTH_SHORT);
				}
			}
		});
    }
    
    void loadImage(String file) throws IOException {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String fn = landscapesFolder + "/" +  file;
		InputStream stream;
		stream = assets.open(landscapesFolder + "/" +  file);

		Drawable drawable = Drawable.createFromStream(stream, null);
		if (drawable != null) {
			imageView.setImageDrawable(drawable);	
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
