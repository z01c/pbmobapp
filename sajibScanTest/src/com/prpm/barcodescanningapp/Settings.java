package com.prpm.barcodescanningapp;

import com.lilait.football.toptenteams.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Settings extends Activity {

	private Spinner spinner;
	private Button save;
	private Button cancel;

	public static final String COLOR_PREF = "COLOR";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		spinner = (Spinner) findViewById(R.id.colors_spinner);

		loadPreferences();

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.button_colors,
				android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				savePrefs(COLOR_PREF, spinner.getSelectedItemPosition());

				// Closing SecondScreen Activity
				finish();
			}
		});

		cancel = (Button) findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Closing SecondScreen Activity
				finish();
			}
		});
	}

	@Override
	public void onStart() {
		super.onStart();
		loadPreferences();
	}

	private void loadPreferences() {
		SharedPreferences settings = getApplicationContext()
				.getSharedPreferences(COLOR_PREF, 0);
		int position = settings.getInt(COLOR_PREF, 0);

		spinner.setSelection(position);

	}

	private void savePrefs(String key, int position) {
		SharedPreferences settings = getApplicationContext()
				.getSharedPreferences(COLOR_PREF, 0);
		Editor editor = settings.edit();
		editor.putInt(key, position);
		editor.commit();

	}

}
