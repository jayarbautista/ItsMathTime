package com.jayar.project.itsmathtime;

import android.support.v4.app.Fragment;

public class ListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new ListActivityFragment();
	}

	@Override
	protected int setUpMain() {
		return R.layout.activity_list;
	}
}
