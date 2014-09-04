package com.jayar.project.itsmathtime;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class ItsMathTimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new ItsMathTimeFragment();
	}

	@Override
	protected int setUpMain() {
		return R.layout.activity_fragment;
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		startActivity(new Intent(this, ItsMathTimeActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
	}
}
