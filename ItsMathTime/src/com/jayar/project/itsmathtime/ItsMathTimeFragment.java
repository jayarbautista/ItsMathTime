package com.jayar.project.itsmathtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ItsMathTimeFragment extends Fragment {

	ImageButton mStartButton;
	ImageButton mInstructionButton;
	ImageButton mScoreButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_its_math_time, container, false);

		mStartButton = (ImageButton)v.findViewById(R.id.start_button);
		mInstructionButton = (ImageButton)v.findViewById(R.id.instructions_button);
		mScoreButton = (ImageButton)v.findViewById(R.id.score_table_button);
		
		return v;
	}

}
