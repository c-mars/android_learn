package mars.fragmentsexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

  final String LOG_TAG = "MainActivity";
  
  Fragment1 frag1;
  Fragment2 frag2;
  FragmentTransaction fTrans;
  CheckBox chbStack;

  @SuppressLint("NewApi") public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    Log.d(LOG_TAG, "MainActivity onCreate");
    
    frag1 = new Fragment1();
    frag2 = new Fragment2();
    
    chbStack = (CheckBox)findViewById(R.id.chbStack);
    
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    ft.add(R.id.frgmCont, frag2);
    ft.commit();
  }

  protected void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "MainActivity onStart");
  }

  protected void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "MainActivity onResume");
  }

  protected void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "MainActivity onPause");
  }

  protected void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "MainActivity onStop");
  }

  protected void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "MainActivity onDestroy");
  }
  
  @SuppressLint("NewApi") public void onClick(View v) {
	  fTrans = getFragmentManager().beginTransaction();
	  switch (v.getId()) {
	  case R.id.btnAdd:
		  fTrans.add(R.id.frgmCont, frag1);
		  break;
	  case R.id.btnRemove:
		  fTrans.remove(frag1);
		  break;
	  case R.id.btnReplace:
		  fTrans.replace(R.id.frgmCont, frag2);
		  break;
	  case R.id.btnFind:
		  {
			  Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
		  
		    ((TextView) frag1.getView().findViewById(R.id.textView1))
		        .setText("Access to Fragment 1 from Activity");

		    Fragment frag2 = getFragmentManager().findFragmentById(R.id.frgmCont);
		    ((TextView) frag2.getView().findViewById(R.id.textView2))
		        .setText("Access to Fragment 2 from Activity");
		  }
		  break;
	  default:
		  break;
	  }
	  if (chbStack.isChecked()) fTrans.addToBackStack(null);
	  fTrans.commit();
  }

}
