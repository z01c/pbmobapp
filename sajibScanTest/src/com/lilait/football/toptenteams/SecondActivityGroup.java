package com.lilait.football.toptenteams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lilait.football.toptenteams.R;
import com.prpm.barcodescanningapp.Settings;
import com.prpm.barcodescanningapp.helper.URLInString;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Contents;

;

public class SecondActivityGroup extends Activity implements OnClickListener {

	private Button scanBtn;
	private TextView formatTxt, contentTxt;

	public static final String COLOR_PREF = "COLOR";
	private Drawable drawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		scanBtn = (Button) findViewById(R.id.scan_button);

		setScanBtnBG();

		formatTxt = (TextView) findViewById(R.id.scan_format);
		contentTxt = (TextView) findViewById(R.id.scan_content);

		scanBtn.setOnClickListener(this);

		// ImageView to display the QR code in. This should be defined in
		// your Activity's XML layout file
		ImageView imageView = (ImageView) findViewById(R.id.qrCode);

		String qrData = "Data I want to encode in QR code";
		int qrCodeDimention = 500;

		/*CustomQRCodeEncoder qrCodeEncoder = new CustomQRCodeEncoder(qrData,
				null, Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(),
				qrCodeDimention);

		try {
			Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
			imageView.setImageBitmap(bitmap);
		} catch (WriterException e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			toggleView();
			break;
		default:
			break;
		}

		return true;
	}

	@Override
	public void onStart() {
		super.onStart();
		setScanBtnBG();
	}

	private void setScanBtnBG() {
		SharedPreferences settings = getApplicationContext()
				.getSharedPreferences(COLOR_PREF, 0);
		int position = settings.getInt(COLOR_PREF, 0);

		switch (position) {
		case 0:
			drawable = getResources().getDrawable(R.drawable.btn_black);
			break;
		case 1:
			drawable = getResources().getDrawable(R.drawable.btn_blue);
			break;
		case 2:
			drawable = getResources().getDrawable(R.drawable.btn_green);
			break;
		case 3:
			drawable = getResources().getDrawable(R.drawable.btn_purple);
			break;
		case 4:
			drawable = getResources().getDrawable(R.drawable.btn_red);
			break;
		case 5:
			drawable = getResources().getDrawable(R.drawable.btn_yellow);
			break;
		default:
			break;
		}

	//	scanBtn.setBackground(drawable);
	}

	private void toggleView() {
		Intent i = new Intent(getApplicationContext(), Settings.class);
		startActivity(i);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE",
				"QR_CODE_MODE");
		startActivityForResult(intent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				// Handle successful scan
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

				formatTxt.setText("FORMAT: " + format);
				contentTxt.setText("CONTENT: " + contents);

				// Check if scan results contains a valid URL
				URLInString isURL = new URLInString();

				if (isURL.isURLInString(contents)) {
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(isURL.getAddress()));
					startActivity(i);
				}

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Log.i("xZing", "Cancelled");
			}
		}
	}
}
