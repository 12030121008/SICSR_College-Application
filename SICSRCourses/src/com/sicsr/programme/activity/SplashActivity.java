package com.sicsr.programme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sicsr.programme.R;
/**
 * @author Faiyyaz Shaikh
 *
 */
public class SplashActivity extends BaseActivity {


	@Override
	public void setupUi(Bundle savedInstanceState) {
		setContentView(R.layout.activity_splash);
		loadContent();
	}

	@Override
	public void loadContent() {
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				Intent homeActivityIntent = new Intent(SplashActivity.this, HomeActivity.class);
				SplashActivity.this.startActivity(homeActivityIntent);
				SplashActivity.this.finish();
			}
		}, getResources().getInteger(R.integer.splash_time_in_seconds) * 1000);

	}


}
