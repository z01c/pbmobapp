package com.lilakhelait.kishor.helper;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;

public class Share {

	public static void share(String wish, Context context)
	{
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, wish);
		sendIntent.setType("text/plain");
		context.startActivity(sendIntent);
	}

	public static void share(File wish, Context ctx) {
		// TODO Auto-generated method stub
		 Intent sharingIntent = new Intent(Intent.ACTION_SEND);
         Uri screenshotUri = Uri.parse("file://" + wish.getAbsolutePath());

         sharingIntent.setType("image/jpg");
         sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
         ctx.startActivity(Intent.createChooser(sharingIntent, "Share image using"));
	}
}
