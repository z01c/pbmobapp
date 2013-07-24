package com.lilakhelait.kishor.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Sms {
	public static void sms(String wish, Context con){
	
	Intent intent = new Intent(Intent.ACTION_VIEW);
	intent.setType("vnd.android-dir/mms-sms");
	intent.putExtra("sms_body", wish);
	con.startActivity(intent);
	}
}
