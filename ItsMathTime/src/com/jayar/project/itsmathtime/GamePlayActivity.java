package com.jayar.project.itsmathtime;

import android.support.v4.app.Fragment;

public class GamePlayActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new GamePlayFragment();
	}

	@Override
	protected int setUpMain() {
		return R.layout.activity_fragment;
	}
}
