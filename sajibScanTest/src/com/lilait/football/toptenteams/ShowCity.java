package com.lilait.football.toptenteams;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.lilait.football.toptenteams.R;
import com.lilakhelait.kishor.helper.Share;
import com.lilakhelait.kishor.helper.Wallpaper;


public class ShowCity extends Activity implements OnClickListener{
	protected int grop1;
	String ti="";
	Bitmap bc=null;
	Drawable d=null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  Bundle extras = getIntent().getExtras();
	  final String city = extras.getString("city_name");
	  ti = extras.getString("til");
	  String id = extras.getString("im");
	  grop1=extras.getInt("grp");
	  Log.d("sdf",grop1+"");
	  setContentView(R.layout.city_row);

	final Context con=this;
	  TextView tv = (TextView)findViewById(R.id.textvie2);
      Button buwall=(Button)findViewById(R.id.wallpaper);
      buwall.setOnClickListener(this);
    Typeface  mFace = Typeface.DEFAULT_BOLD;;
    tv.setTypeface(mFace,Typeface.BOLD);
    tv.setTextColor(Color.RED);

    tv.setText(city);
    
    TextView tv1 = (TextView)findViewById(R.id.textvie1);
   final Context ctx=this;
   
    tv1.setTypeface(mFace,Typeface.BOLD);
    tv1.setTextColor(Color.BLUE);
 
    tv1.setText(ti);
    
    ImageView im =(ImageView)findViewById(R.id.imageView1);
	
	
    InputStream ims = null;
	try {
		ims = getAssets().open(id);
	
	// load image as Drawable
	 d = Drawable.createFromStream(ims, null);

	 bc = ((BitmapDrawable) d).getBitmap();
    im.setImageBitmap(bc);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	im.setOnClickListener(this);

	
	Button sms;
  	Button share;
  	Button email;
     
      sms = (Button)findViewById(R.id.bsms);
      email= (Button)findViewById(R.id.bemail);
   
   
      
 
  
    
      sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Share.share(city,con);
				Button t=(Button)v;
				t.setTextColor(Color.WHITE);
			}
		});
      
      email.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(grop1==1){
		FirstGroup1.group.back();
				}
				else
				{
					FirstGroup.group.back();
				
				}
			}
		});
    
		
	}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub

}
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	if(v.getId()==R.id.imageView1)
	{
		File dir = Environment.getExternalStorageDirectory();
		 File output = new File(dir,ti+ ".jpg");
		 FileOutputStream os = null;
		try {
			os = new FileOutputStream(output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		bc.compress(CompressFormat.JPEG, 100, os);
		    try {
				os.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Share.share(output,this);
	}
	if(v.getId()==R.id.wallpaper)
	{
		Wallpaper.wall(this, bc);
	}
}
}
