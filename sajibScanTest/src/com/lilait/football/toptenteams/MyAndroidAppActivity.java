package com.lilait.football.toptenteams;

import com.lilait.football.toptenteams.R;
import com.sound.kd.MusicService;

import android.app.LocalActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TabHost;

public class MyAndroidAppActivity extends android.app.TabActivity{

	public TabHost tabHost;
	private boolean mIsBound = false;
	private MusicService mServ;
	private ServiceConnection Scon =new ServiceConnection(){

	
		@Override
		public void onServiceConnected(ComponentName name,  IBinder binder) {
			// TODO Auto-generated method stub
			mServ = ((MusicService.ServiceBinder)binder).getService();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mServ = null;
		}
		};

		void doBindService(){
	 		bindService(new Intent(this,MusicService.class),
					Scon,getApplicationContext().BIND_AUTO_CREATE);
			mIsBound = true;
		}

		void doUnbindService()
		{
			if(mIsBound)
			{
				unbindService(Scon);
	      		mIsBound = false;
			}
		}
		
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		MusicService mServ = new MusicService();

		Intent music = new Intent();
		music.setClass(this,MusicService.class);
		stopService(music);

		mServ.onDestroy();
		super.onDestroy();
	}
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tabs);
	    Intent music = new Intent();
	    music.setClass(this,MusicService.class);
	    startService(music);
            // Get the tabHost
	    this.tabHost = getTabHost();

	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch the first Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, FirstGroup.class);

	    // Initialize a TabSpec for the first tab and add it to the TabHost
	    spec = tabHost.newTabSpec("FirstGroup").setIndicator("start",
	    		null) // Replace null with R.drawable.your_icon to set tab icon
	    				.setContent(intent);
	    tabHost.addTab(spec);

            // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, SecondActivityGroup.class);

	    // Initialize a TabSpec for the second tab and add it to the TabHost
	    spec = tabHost.newTabSpec("FirstGroup1").setIndicator("Help",
	    		null) // Replace null with R.drawable.your_icon to set tab icon
	    				.setContent(intent);
	     tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, SecondActivityGroup.class);

	    // Initialize a TabSpec for the second tab and add it to the TabHost
	    spec = tabHost.newTabSpec("SecondGroup").setIndicator("scan",
	    		null) // Replace null with R.drawable.your_icon to set tab icon
	    				.setContent(intent);
	    tabHost.addTab(spec);
	    
	 

	    tabHost.setCurrentTab(0);
	}
}
