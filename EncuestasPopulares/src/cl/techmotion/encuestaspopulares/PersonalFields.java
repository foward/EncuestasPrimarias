package cl.techmotion.encuestaspopulares;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class PersonalFields extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_fields);
		
		TextView textView = (TextView) findViewById(R.id.value_candidate_selected);
        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String text = app_preferences.getString("key", "null");
        textView.setText(text);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_fields, menu);
		return true;
	}

}
