package com.lilakhelait.kishor.resource;

import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;

public class Resource {

	public static String getstringfromfiles(int a,Context con)
	{
		try {
        Resources res = con.getResources();
        InputStream in_s = res.openRawResource(a);

        byte[] b = new byte[in_s.available()];
        in_s.read(b);
        return ""+new String(b);
     
    } catch (Exception e) {
        // e.printStackTrace();
      //  txtHelp.setText("Error: can't show help.");
        return "";
    }}
}
