package com.jayar.project.itsmathtime;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Random;

import android.os.Bundle;
=======
=======
>>>>>>> issue2
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.os.CountDownTimer;
<<<<<<< HEAD
>>>>>>> issue3
=======
>>>>>>> issue2
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.widget.ImageView;
>>>>>>> issue3
=======
import android.widget.ImageView;
>>>>>>> issue2
import android.widget.TextView;
import android.widget.Toast;

public class GamePlayFragment extends Fragment {

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
	private static int answer;
	private static int sCount;
	private static int sOperator;
	private static int sScore;

	private int level;
	int sDigitCount = 1;
	
	Date mDate;

	private SaveScore mSaveScore;

	TextView mScore;
	TextView mTimer;
	TextView mLevel;
	static TextView mFirstOperand;
	static TextView mSecondOperand;
	static TextView mOperator;

	EditText mAnswer;

	ImageView mAddView;
	ImageView mSubtractView;
	ImageView mMultiplyView;
	ImageView mDivideView;
	ImageView mMixedView;

	ImageView mDots[] = new ImageView[5];

	ImageButton mSubmit;
=======
	private static int sAnswer;
	private static int sDigitCount = 1;
	
	private int mCount;
	private int mOperatorHolder;
	private int mScoreHolder;
	private int mLevelHolder;

	private Date mDate;

	private SaveScore mSaveScore;

	private TextView mScore;
	private TextView mTimer;
	private TextView mLevel;
	private static TextView sFirstOperand;
	private static TextView sSecondOperand;
	private static TextView sOperator;

	private EditText mAnswer;

	private ImageView mAddView;
	private ImageView mSubtractView;
	private ImageView mMultiplyView;
	private ImageView mDivideView;
	private ImageView mMixedView;

	private ImageView mDots[] = new ImageView[5];

	private ImageButton mSubmit;
>>>>>>> issue2

	private static int sDotId[] = { R.id.dot1_imageview, R.id.dot2_imageview,
			R.id.dot3_imageview, R.id.dot4_imageview, R.id.dot5_imageview };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.gameplay_screen, container, false);

		mSaveScore = new SaveScore(getActivity());

<<<<<<< HEAD
		final TimerCountDown timer = new TimerCountDown(11000, 1000);
		timer.start();

		mScore = (TextView) v.findViewById(R.id.score_field);

		mTimer = (TextView) v.findViewById(R.id.time_field);

		mLevel = (TextView) v.findViewById(R.id.level);
		mFirstOperand = (TextView) v.findViewById(R.id.first_operand_view);
		mSecondOperand = (TextView) v.findViewById(R.id.second_operand_view);
		mOperator = (TextView) v.findViewById(R.id.operator_view);

		mAnswer = (EditText) v.findViewById(R.id.answer_field);

=======
		final TimerCountDown timer = new TimerCountDown(31000, 1000);
		timer.start();

		mScore = (TextView) v.findViewById(R.id.score_field);
		mTimer = (TextView) v.findViewById(R.id.time_field);
		mLevel = (TextView) v.findViewById(R.id.level);
		sFirstOperand = (TextView) v.findViewById(R.id.first_operand_view);
		sSecondOperand = (TextView) v.findViewById(R.id.second_operand_view);
		sOperator = (TextView) v.findViewById(R.id.operator_view);
		mAnswer = (EditText) v.findViewById(R.id.answer_field);
>>>>>>> issue2
		mAddView = (ImageView) v.findViewById(R.id.add_imageview);
		mSubtractView = (ImageView) v.findViewById(R.id.subtract_imageview);
		mMultiplyView = (ImageView) v.findViewById(R.id.multiply_imageview);
		mDivideView = (ImageView) v.findViewById(R.id.divide_imageview);
		mMixedView = (ImageView) v.findViewById(R.id.mixed_imageview);
<<<<<<< HEAD

=======
>>>>>>> issue2
		for (int i = 0; i < mDots.length; i++) {
			mDots[i] = (ImageView) v.findViewById(sDotId[i]);
		}

		mSubmit = (ImageButton) v.findViewById(R.id.submit_button);
		mSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (mAnswer.getText().toString().equals("")) {
					Toast.makeText(getActivity(), R.string.answer_toast,
							Toast.LENGTH_SHORT).show();
				} else {
<<<<<<< HEAD
					answer = Integer.parseInt(mAnswer.getText().toString());
					if (answer == checkAnswer()) {

						Toast.makeText(getActivity(), "Correct :)",
								Toast.LENGTH_SHORT).show();

						changeOperator();
						setOperands();
						// checkOperands();

						sCount += 1;
						sScore += 5;
						mDots[sCount - 1].setImageResource(R.drawable.correct);
						mScore.setText(sScore + "");
						mAnswer.setText("");

					} else {
						Toast.makeText(getActivity(),
								mAnswer.getText() + "Wrong :(" + checkAnswer(),
=======
					sAnswer = Integer.parseInt(mAnswer.getText().toString());
					if (sAnswer == checkAnswer()) {

						changeOperator();
						setOperands();

						mCount += 1;
						mScoreHolder += 5;
						mDots[mCount - 1].setImageResource(R.drawable.correct);
						mScore.setText(mScoreHolder + "");
						mAnswer.setText("");

					} else {
						Toast.makeText(getActivity(), R.string.answer_wrong,
>>>>>>> issue2
								Toast.LENGTH_SHORT).show();
					}
				}

<<<<<<< HEAD
				if (sCount == 5) {
					sCount = 0;
=======
				if (mCount == 5) {
					mCount = 0;
>>>>>>> issue2

					for (int i = 0; i < 5; i++) {
						mDots[i].setImageResource(R.drawable.wrong);
					}

<<<<<<< HEAD
					level += 1;
					mLevel.setText(level + "");
=======
					mLevelHolder += 1;
					mLevel.setText(mLevelHolder + "");
>>>>>>> issue2

					sDigitCount += 1;

					setOperands();
<<<<<<< HEAD
					// checkOperands();
=======
>>>>>>> issue2
					changeOperator();
					timer.cancel();
					timer.start();
				}
			}
		});

		onLoad();
		setOperands();
<<<<<<< HEAD
<<<<<<< HEAD
		// checkOperands();
=======
>>>>>>> issue2
		changeOperator();
=======
>>>>>>> issue2

		return v;
	}

	public static int randomBox() {
<<<<<<< HEAD
		/*
		 * double total = 0.0; Random rand = new Random(); int pickedNumber = 0;
		 * 
		 * if(sDigitCount == 1) { total = Math.pow(10, 1); pickedNumber = (int)
		 * ((Math.pow(10, 0)) - 1 + rand .nextInt((int) (total))); } else {
		 * total = (Math.pow(10, sDigitCount)) - 10; pickedNumber = (int)
		 * ((Math.pow(10, (sDigitCount-1))) + rand .nextInt((int) (total))); }
		 */
		Random rand = new Random();
		int pickedNumber = rand.nextInt(10);
=======
		double total = 0.0;
		Random rand = new Random();
		int pickedNumber = 0;
		
		if(sDigitCount == 1) {
			total = Math.pow(10, 1);
			pickedNumber = (int) ((Math.pow(10, 0)) - 1 + rand
					.nextInt((int) (total)));
		} else {
			total = (Math.pow(10, sDigitCount)) - (Math.pow(10, (sDigitCount-1)));
			pickedNumber = (int) ((Math.pow(10, (sDigitCount-1))) + rand
					.nextInt((int) (total)));
		}
>>>>>>> issue2

		return pickedNumber;
	}

	public void setOperands() {
<<<<<<< HEAD
		mFirstOperand.setText(randomBox() + "");
		mSecondOperand.setText(randomBox() + "");
=======
		sFirstOperand.setText(randomBox() + "");
		sSecondOperand.setText(randomBox() + "");
>>>>>>> issue2

		checkOperands();
	}

	public void checkOperands() {
<<<<<<< HEAD
		int first = Integer.parseInt(mFirstOperand.getText().toString());
		int second = Integer.parseInt(mSecondOperand.getText().toString());

		if (second > first) {
			mFirstOperand.setText(second + "");
			mSecondOperand.setText(first + "");
		}

		if (mOperator.getText().toString().equals("/")) {

			if (second == 0) {
				mSecondOperand.setText(randomBox() + "");
			}

			if (second != 0) {
				if (first != ((first / second) * second)) {
=======
		int first = Integer.parseInt(sFirstOperand.getText().toString());
		int second = Integer.parseInt(sSecondOperand.getText().toString());

		if (second > first) {
			sFirstOperand.setText(second + "");
			sSecondOperand.setText(first + "");
		}

		if (sOperator.getText().toString().equals("/")) {
			if (second == 0 || first == 0) {
				setOperands();
			}
	
			else {
<<<<<<< HEAD
				if (((first / second) * second) != first ) {
>>>>>>> issue2
=======
				if (((first / second) * second) != first) {
>>>>>>> issue2
					setOperands();
				}
			}
		}
	}

	public void onLoad() {
		mScore.setText("0");
		mTimer.setText("00:30");
		mLevel.setText("1");
		
		mAddView.setImageResource(R.drawable.addition);

<<<<<<< HEAD
<<<<<<< HEAD
		mOperator.setText("+");
=======
		mOperator.setText("/");
>>>>>>> issue2
=======
		sOperator.setText("+");
>>>>>>> issue2
	}

	public void randomOperator() {
		String[] arrayOfString = { "+", "-", "*", "/" };
		List<String> arrayList = new LinkedList<String>();
		for (String s : arrayOfString) {
			arrayList.add(s);

			Collections.shuffle(arrayList);

			sOperator.setText("" + arrayList.get(0));
		}
	}

	public static int checkAnswer() {
		int firstOperand;
		int secondOperand;

<<<<<<< HEAD
		firstOperand = Integer.parseInt(mFirstOperand.getText().toString());
		secondOperand = Integer.parseInt(mSecondOperand.getText().toString());

		if (mOperator.getText().toString().equals("+"))
			answer = firstOperand + secondOperand;
		else if (mOperator.getText().toString().equals("-"))
			answer = firstOperand - secondOperand;
		else if (mOperator.getText().toString().equals("*"))
			answer = firstOperand * secondOperand;
		else if (mOperator.getText().toString().equals("/"))
			answer = firstOperand / secondOperand;

		return answer;
=======
		firstOperand = Integer.parseInt(sFirstOperand.getText().toString());
		secondOperand = Integer.parseInt(sSecondOperand.getText().toString());

		if (sOperator.getText().toString().equals("+"))
			sAnswer = firstOperand + secondOperand;
		else if (sOperator.getText().toString().equals("-"))
			sAnswer = firstOperand - secondOperand;
		else if (sOperator.getText().toString().equals("*"))
			sAnswer = firstOperand * secondOperand;
		else if (sOperator.getText().toString().equals("/"))
			sAnswer = firstOperand / secondOperand;

		return sAnswer;
>>>>>>> issue2
	}

	public void changeOperator() {

<<<<<<< HEAD
		level = Integer.parseInt(mLevel.getText().toString());

		sOperator = level % 10;
		switch (sOperator) {
		case 1:
			mOperator.setText("+");
			break;
		case 2:
			mOperator.setText("-");
			break;
		case 3:
			mOperator.setText("*");
			break;
		case 4:
			mOperator.setText("/");
			break;
		case 5:
			randomOperator();
			break;
		case 6:
			mOperator.setText("+");
			break;
		case 7:
			mOperator.setText("-");
			break;
		case 8:
			mOperator.setText("*");
			break;
		case 9:
			mOperator.setText("/");
			break;
		case 0:
			randomOperator();
			break;
		}
	}
=======
		mLevelHolder = Integer.parseInt(mLevel.getText().toString());

		mOperatorHolder = mLevelHolder % 10;
		switch (mOperatorHolder) {
		case 1:
			sOperator.setText("+");
			resetColor();
			mAddView.setImageResource(R.drawable.addition);
			break;
		case 2:
			sOperator.setText("-");
			resetColor();
			mSubtractView.setImageResource(R.drawable.subtraction);
			break;
		case 3:
			sOperator.setText("*");
			resetColor();
			mMultiplyView.setImageResource(R.drawable.multiplication);
			break;
		case 4:
			sOperator.setText("/");
			resetColor();
			mDivideView.setImageResource(R.drawable.division);
			break;
		case 5:
			randomOperator();
			resetColor();
			mMixedView.setImageResource(R.drawable.mixed);
			break;
		case 6:
			sOperator.setText("+");
			resetColor();
			mAddView.setImageResource(R.drawable.addition);
			break;
		case 7:
			sOperator.setText("-");
			resetColor();
			mSubtractView.setImageResource(R.drawable.subtraction);
			break;
		case 8:
			sOperator.setText("*");
			resetColor();
			mMultiplyView.setImageResource(R.drawable.multiplication);
			break;
		case 9:
			sOperator.setText("/");
			resetColor();
			mDivideView.setImageResource(R.drawable.division);
			break;
		case 0:
			randomOperator();
			resetColor();
			mMixedView.setImageResource(R.drawable.mixed);
			break;
		}
	}
	
	public void resetColor() {
		mAddView.setImageResource(R.drawable.addition_gray);
		mSubtractView.setImageResource(R.drawable.subtraction_gray);
		mMultiplyView.setImageResource(R.drawable.multiplication_gray);
		mDivideView.setImageResource(R.drawable.division_gray);
		mMixedView.setImageResource(R.drawable.mixed_gray);
	}
>>>>>>> issue2

	public class TimerCountDown extends CountDownTimer {
		public TimerCountDown(long startTime, long interval) {
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			mTimer.setText("Time's up!");
			mAnswer.setEnabled(false);
			mSubmit.setEnabled(false);
<<<<<<< HEAD
			sDigitCount = 0;
<<<<<<< HEAD
			
			mDate = new Date();
			Toast.makeText(getActivity(),
					mDate+"",
					Toast.LENGTH_SHORT).show();

			if (sScore != 0) {
				try {
					mSaveScore.saveScore(sScore, level, mDate);
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(getActivity(),
							" not saved",
							Toast.LENGTH_SHORT).show();
				}
=======
=======
			sDigitCount = 1;
>>>>>>> issue2

			mDate = new Date();

			try {
				mSaveScore.saveScore(mScoreHolder, mLevelHolder, mDate);
			} catch (Exception e) {
				e.printStackTrace();
>>>>>>> issue2
			}
		}

		@Override
		public void onTick(long millisUntilFinished) {
			mTimer.setText("00:" + millisUntilFinished / 1000);
		}
<<<<<<< HEAD
>>>>>>> issue3
=======
>>>>>>> issue2
	}

}
