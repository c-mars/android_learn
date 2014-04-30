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

@SuppressLint("NewApi") public class Fragment1 extends Fragment {

  final String LOG_TAG = "Fragment1";

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    Log.d(LOG_TAG, "Fragment1 onAttach");
  }

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(LOG_TAG, "Fragment1 onCreate");
  }

  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    Log.d(LOG_TAG, "Fragment1 onCreateView");
    View v = inflater.inflate(R.layout.fragment1, null);
    
    Button button = (Button) v.findViewById(R.id.button);
    button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Log.d(LOG_TAG, "Button click in Fragment1");
    		((Button)getActivity().findViewById(R.id.btnFind)).setText("Access from Fragment1");
    	}
    });

    return v;
  }

  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.d(LOG_TAG, "Fragment1 onActivityCreated");
  }

  public void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "Fragment1 onStart");
  }

  public void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "Fragment1 onResume");
  }

  public void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "Fragment1 onPause");
  }

  public void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "Fragment1 onStop");
  }

  public void onDestroyView() {
    super.onDestroyView();
    Log.d(LOG_TAG, "Fragment1 onDestroyView");
  }

  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "Fragment1 onDestroy");
  }

  public void onDetach() {
    super.onDetach();
    Log.d(LOG_TAG, "Fragment1 onDetach");
  }
}
