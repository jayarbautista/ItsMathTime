package com.jayar.project.itsmathtime;

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
}
