package com.jayar.project.itsmathtime;

import android.support.v4.app.Fragment;

public class InstructionsActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new InstructionsFragment();
	}

	@Override
	protected int setUpMain() {
		return R.layout.activity_fragment;
	}
}
