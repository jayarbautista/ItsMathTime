package com.jayar.project.itsmathtime;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GamePlayFragment extends Fragment {

	TextView mScore;
	TextView mTimer;
	TextView mLevel;
	TextView mFirstOperand;
	TextView mSecondOperand;
	
	EditText mAnswer;
	
	ImageButton mSubmit;

	private static int mCount = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.gameplay_screen, container, false);
		
		mFirstOperand = (TextView)v.findViewById(R.id.first_operand_view);
		
		mSecondOperand = (TextView)v.findViewById(R.id.second_operand_view);
		
		mAnswer = (EditText)v.findViewById(R.id.answer_field);
		
		mSubmit = (ImageButton)v.findViewById(R.id.submit_button);
		mSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mAnswer.getText().toString().equals("")) {
					Toast.makeText(getActivity(), R.string.answer_toast, Toast.LENGTH_LONG).show();
				}
				else {
					mFirstOperand.setText(randomBox()+"");
					mSecondOperand.setText(randomBox()+"");
					
					mCount+=1;
					mAnswer.setText("");
				}
			}
		});
		
		mFirstOperand.setText(randomBox()+"");
		mSecondOperand.setText(randomBox()+"");
		
		return v;
	}
	
	public static int randomBox() {
	    Random rand = new Random();
	    int pickedNumber = rand.nextInt(10);
	    return pickedNumber;
	}

}
