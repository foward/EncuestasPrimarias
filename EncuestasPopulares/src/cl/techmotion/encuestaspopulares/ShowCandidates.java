package cl.techmotion.encuestaspopulares;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ShowCandidates extends Activity {

	private static final String TAG = "ShowCandidates";
	private Button btn_enviar_y_ver;
	private RadioGroup radioCandidatesGroup;
	private RadioButton radioCandidateSelected;
	public static final String PREFS_FILE = "MyPreferences";
    public static final String PREFS_NAME = "USER_NAME";
    public static final String PREFS_CHOICE = "USER_CHOICE";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_candidates);
	
		addListenerButtonEnviar();
		
	}

	
	private void addListenerButtonEnviar() {
		btn_enviar_y_ver = (Button) findViewById(R.id.enviar_resultados);
		radioCandidatesGroup = (RadioGroup) findViewById(R.id.radioGroupCandidates);
		
        btn_enviar_y_ver.setOnClickListener(new Button.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					
					int selectedId = radioCandidatesGroup.getCheckedRadioButtonId();
					radioCandidateSelected = (RadioButton) findViewById(selectedId);
					
					SharedPreferences app_preferences =
	                        PreferenceManager.getDefaultSharedPreferences(ShowCandidates.this);
	                SharedPreferences.Editor editor = app_preferences.edit();
	                String text = radioCandidateSelected.getText().toString();
	                editor.putString("key", text);
	                editor.commit();
	                //Intent myIntent = new Intent(SogacityActivity.this,SharedPreference.class);
	                //startActivity(myIntent);
					//startActivity(new Intent(ShowCandidates.this, Gracias.class));		
	                startActivity(new Intent(ShowCandidates.this, PersonalFields.class));	
				}   	
	        });
		
	}
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio1:
	            if (checked)
	               Log.i(TAG, "Radio 1 checked ");
	            break;
	        case R.id.radio2:
	            if (checked)
	            	Log.i(TAG, "Radio 2 checked ");
	            break;
	        case R.id.radio3:
	            if (checked)
	            	Log.i(TAG, "Radio 3 checked ");
	            break;
	        case R.id.radio4:
	            if (checked)
	            	Log.i(TAG, "Radio 4 checked ");
	            break;
	        case R.id.radio5:
	            if (checked)
	            	Log.i(TAG, "Radio 5 checked ");
	            break;
	            
	        case R.id.radio6:
	            if (checked)
	            	Log.i(TAG, "Radio 6 checked ");
	            break;
	            
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_candidates, menu);
		return true;
	}

}
