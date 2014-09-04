package com.jayar.project.itsmathtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();
    
    protected abstract int setUpMain();

    @Override
	protected void onCreate(Bundle arg0) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(arg0);
		setContentView(setUpMain());

		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment =createFragment();

		fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
	}
}
