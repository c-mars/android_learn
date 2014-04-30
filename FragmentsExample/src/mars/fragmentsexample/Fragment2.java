package mars.fragmentsexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi") public class Fragment2 extends Fragment {

  final String LOG_TAG = "Fragment2";
  
  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    Log.d(LOG_TAG, "Fragment2 onAttach");
  }
  
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(LOG_TAG, "Fragment2 onCreate");
  }
  
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    Log.d(LOG_TAG, "Fragment2 onCreateView");
View v = inflater.inflate(R.layout.fragment2, null);
    
    Button button = (Button) v.findViewById(R.id.button);
    button.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
        Log.d(LOG_TAG, "Button click in Fragment2");
      }
    });
    
    return v;
  }
  
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.d(LOG_TAG, "Fragment2 onActivityCreated");
  }
  
  public void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "Fragment2 onStart");
  }
  
  public void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "Fragment2 onResume");
  }
  
  public void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "Fragment2 onPause");
  }
  
  public void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "Fragment2 onStop");
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    Log.d(LOG_TAG, "Fragment2 onDestroyView");
  }
  
  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "Fragment2 onDestroy");
  }
  
  public void onDetach() {
    super.onDetach();
    Log.d(LOG_TAG, "Fragment2 onDetach");
  }
}