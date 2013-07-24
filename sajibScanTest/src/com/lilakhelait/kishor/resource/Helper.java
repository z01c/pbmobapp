package com.lilakhelait.kishor.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class Helper {

	public static ArrayList<Wish> helper(String resource, Context ctx) throws IOException
	{

		ArrayList<Wish> list = new ArrayList<Wish>();

		String[] trimed = resource.split("xxxx");

		for (String s : trimed) {
			String[] k = s.split("yyyy 11-11");
			if (k.length >= 2) {
				Wish wish = new Wish();
				wish.setTitle(k[0].replace("  ", ""));
				String[] h = k[1].split("11-11");

				if (h.length >= 2) {
				
					wish.setImage(h[0].replace(" ", "")+".jpg");
					wish.setWishtext(h[1].replace("  ", ""));
					list.add(wish);
				}

			}
		}
		return list;
	}
}

		