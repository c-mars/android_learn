package c.mars.imagecachingex;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
	ImageAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView = (ImageView)findViewById(R.id.imageView);
        gallery = (LinearLayout)findViewById(R.id.gallery);
        adapter = new ImageAdapter(this);
        
        assets = getAssets();
        try {
			files = assets.list(landscapesFolder);
		int i = 0;
            for (String file : files) {
            	loadImage(file);
//            	return;
            }
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        String ExternalStorageDirectoryPath = Environment
//                .getExternalStorageDirectory()
//                .getAbsolutePath();
//              
//              String targetPath = ExternalStorageDirectoryPath + "/test/";
//              Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
              
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
//			imageView.setImageDrawable(drawable);	
			gallery.addView(insertPhoto(drawable));
		}

    }
    
    View insertPhoto(Drawable drawable){
//        Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);
        
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setLayoutParams(new LayoutParams(250, 250));
        layout.setGravity(Gravity.CENTER);
        
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setLayoutParams(new LayoutParams(220, 220));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        
        if (drawable != null) {
        	imageView.setImageDrawable(drawable);
        }
        layout.addView(imageView);
        return layout;
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
