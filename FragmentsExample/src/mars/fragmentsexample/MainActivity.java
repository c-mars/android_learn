package mars.fragmentsexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {

  final String LOG_TAG = "MainActivity";
  
  Fragment1 frag1;
  Fragment2 frag2;
  FragmentTransaction fTrans;
  CheckBox chbStack;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    Log.d(LOG_TAG, "MainActivity onCreate");
    
    frag1 = new Fragment1();
    frag2 = new Fragment2();
    
    chbStack = (CheckBox)findViewById(R.id.chbStack);
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
	  default:
		  break;
	  }
	  if (chbStack.isChecked()) fTrans.addToBackStack(null);
	  fTrans.commit();
  }

}
