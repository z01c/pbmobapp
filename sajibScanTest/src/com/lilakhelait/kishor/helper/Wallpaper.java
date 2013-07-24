package com.lilakhelait.kishor.helper;

import java.io.IOException;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;

public class Wallpaper {

	public static void wall(Context ctx, Bitmap b){
	WallpaperManager myWallpaperManager = WallpaperManager.getInstance(ctx.getApplicationContext());
    try {
        // below line of code will set your current visible pager item to wallpaper
        // first we have to fetch bitmap from visible view and then we can pass it to wallpaper
        myWallpaperManager.setBitmap(b);

        // below line of code will set input stream data directly to wallpaper
        // myWallpaperManager.setStream(InputStream Data);

        // below line of code will set any image which is in the drawable folder 
        // myWallpaperManager.setResource(R.drawable.icon);
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}
