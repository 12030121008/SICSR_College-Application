package com.sicsr.programme.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.sicsr.programme.R;
import com.sicsr.programme.fragment.BranchesListFragment;
public class HomeActivity extends BaseActivity {

	private BranchesListFragment branchesListFragment;

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (item.getItemId()) {
		case  R.id.action_menu_accountList:
			showProgressDialog("Requesting..");
			 
			return true;

		case R.id.action_menu_logout:
			showProgressDialog("Signing out..");
		 
			return true;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}*/


	public Fragment getCurrentNavigationFragmentLoaded(){
		return getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_container);
	}

	public Fragment getCurrentHomeFragmentLoaded(){
		return getSupportFragmentManager().findFragmentById(R.id.fragment_home_container);
	}

	public void loadFragmentMain(Fragment fragment){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.move_up_enter_fast, R.anim.move_down_exit,R.anim.move_up_enter_fast, R.anim.move_down_exit);
		fragmentTransaction.replace(R.id.fragment_home_container, fragment);
		fragmentTransaction.commit();
	}
	
	
	public void addFragmentMain(Fragment fragment,Bundle bundle){
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.addToBackStack(fragment.getClass().getName());
		fragment.setArguments(bundle);
		fragmentTransaction.setCustomAnimations(R.anim.move_up_enter_fast, R.anim.move_down_exit,R.anim.move_up_enter_fast, R.anim.move_down_exit);
		fragmentTransaction.replace(R.id.fragment_home_container, fragment);
		fragmentTransaction.commit();
	}


	@Override
	public void setupUi(Bundle savedInstanceState) {
		setContentView(R.layout.activity_home);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setLogo(getResources().getDrawable(R.drawable.coverfeed_icon));
		setSupportActionBar(toolbar); 
		branchesListFragment = new BranchesListFragment();
		loadFragmentMain(branchesListFragment);
	 
	}

	@Override
	public void loadContent() {

	
	}


}
