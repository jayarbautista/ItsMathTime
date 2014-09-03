package com.jayar.project.itsmathtime;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class ItsMathTimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new ItsMathTimeFragment();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		startActivity(new Intent(this, ItsMathTimeActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
	}
}
