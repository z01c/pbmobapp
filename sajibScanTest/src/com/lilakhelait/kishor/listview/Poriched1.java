package com.lilakhelait.kishor.listview;

import java.util.ArrayList;
import java.util.List;

import com.lilait.football.toptenteams.R;
import com.lilakhelait.kishor.helper.Email;
import com.lilakhelait.kishor.helper.Share;
import com.lilakhelait.kishor.helper.Sms;

import com.lilakhelait.kishor.resource.Wish;




import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Poriched1 extends ArrayAdapter<Wish> {
	  private final Context context;
	  public static  ArrayList<Wish> newyearsvalues=new ArrayList<Wish>();
public int size=0;
Typeface   mFace ;
//public Typeface mFace ;
	  public Poriched1(Context context) {
	    super(context, R.layout.list, newyearsvalues);
	    this.context = context;
       this.mFace = Typeface.DEFAULT_BOLD;;
	//    this.values = values;
	//    mFace = Typeface.createFromAsset(context.getAssets(),"SIYAMRUPALI_1_01.TTF");
	  }

	 

	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   final View row = inflater.inflate(R.layout.list, parent, false);
		final int index = position;
		ViewHoldee22r holder;

		
		 holder = new ViewHoldee22r();
		 holder.Wish = (TextView)row.findViewById(R.id.textView1);
      
    holder.Wish.setTypeface(mFace);
        
//         row.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//				v.setBackgroundColor(Color.DKGRAY);
//			}
//		});
//         holder.Wish.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				TextView t=(TextView)v;
//			
//				row.setBackgroundColor(Color.DKGRAY);	// TODO Auto-generated method stub
//			
//	//		t.setText("দফগদফগদফ");
//			
//			}
//		});
//         
//         holder.share.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Share.share(newyearsvalues.get(index).getWishtext(), context);
//				Button t=(Button)v;
//				t.setTextColor(Color.WHITE);
//			}
//		});
//       
//         holder.sms.setOnClickListener(new OnClickListener() {
// 			
// 			@Override
// 			public void onClick(View v) {
// 				// TODO Auto-generated method stub
// 				Sms.sms(newyearsvalues.get(index).getWishtext(), context);
// 				Button t=(Button)v;
//				t.setTextColor(Color.WHITE);
// 			}
// 		});
//         
//         holder.email.setOnClickListener(new OnClickListener() {
//  			
//  			@Override
//  			public void onClick(View v) {
//  				// TODO Auto-generated method stub
//  				Email.email(context, "Happy new year", newyearsvalues.get(index).getWishtext());
//  				Button t=(Button)v;
//  				t.setTextColor(Color.WHITE);
//  			}
//  		});
         
         row.setTag(holder);

		holder = (ViewHoldee22r) row.getTag();
        Wish wish = newyearsvalues.get(index);
		if(wish!=null)
		{
			holder.Wish.setText(wish.getTitle());
			holder.Wish.setTypeface(mFace,Typeface.BOLD);
			 holder.Wish.setTextColor(Color.RED);
//			holder.playerrank.setText(playerdata.playernumber);
//			holder.isactive.setChecked(playerdata.isactive);
			
		}
		return row;
	}
	} 

class ViewHoldee22r {
	
	TextView Wish;

	
}