package com.jayar.project.itsmathtime;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GamePlayFragment extends Fragment {

	private static int sAnswer;
	private static int sDigitCount = 1;

	private int mCount;
	private int mOperatorHolder;
	private int mScoreHolder;
	private int mLevelHolder;

	private Date mDate;

	private SaveScore mSaveScore;

	private TextView mScore;
	private TextView mTimerView;
	private TextView mLevel;
	private TextView mFirstOperand;
	private TextView mSecondOperand;
	private TextView mOperator;

	private EditText mAnswer;

	private ImageView mAddView;
	private ImageView mSubtractView;
	private ImageView mMultiplyView;
	private ImageView mDivideView;
	private ImageView mMixedView;

	private ImageView mDots[] = new ImageView[5];

	private ImageButton mSubmit;

	private TimerCountDown mTimer;

	private static int sDotId[] = { R.id.dot1_imageview, R.id.dot2_imageview,
			R.id.dot3_imageview, R.id.dot4_imageview, R.id.dot5_imageview };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.gameplay_screen, container, false);

		mSaveScore = new SaveScore(getActivity());

		mTimer = new TimerCountDown(31000, 1000);
		mTimer.start();

		mScore = (TextView) v.findViewById(R.id.score_field);
		mTimerView = (TextView) v.findViewById(R.id.time_field);
		mLevel = (TextView) v.findViewById(R.id.level_field);
		mFirstOperand = (TextView) v.findViewById(R.id.first_operand_view);
		mSecondOperand = (TextView) v.findViewById(R.id.second_operand_view);
		mOperator = (TextView) v.findViewById(R.id.operator_view);
		mAnswer = (EditText) v.findViewById(R.id.answer_field);
		mAddView = (ImageView) v.findViewById(R.id.add_imageview);
		mSubtractView = (ImageView) v.findViewById(R.id.subtract_imageview);
		mMultiplyView = (ImageView) v.findViewById(R.id.multiply_imageview);
		mDivideView = (ImageView) v.findViewById(R.id.divide_imageview);
		mMixedView = (ImageView) v.findViewById(R.id.mixed_imageview);
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
								Toast.LENGTH_SHORT).show();
					}
				}

				if (mCount == 5) {

					for (int i = 0; i < 5; i++) {
						mDots[i].setImageResource(R.drawable.wrong);
					}

					mLevelHolder += 1;
					mLevel.setText(mLevelHolder + "");

					setOperands();
					changeOperator();
					mTimer.cancel();
					mTimer.start();
					mCount = 0;
				}
				
				if ((mLevelHolder % 5 == 1) && (mCount == 0)) {
					sDigitCount += 1;
					setOperands();
				}
			}
		});

		onLoad();
		setOperands();

		return v;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mTimer.cancel();
		sDigitCount = 1;
	}

	public static int randomOperands() {
		double total = 0.0;
		Random rand = new Random();
		int pickedNumber = 0;

		if (sDigitCount == 1) {
			total = Math.pow(10, 1);
			pickedNumber = (int) ((Math.pow(10, 0)) - 1 + rand
					.nextInt((int) (total)));
		} else {
			total = (Math.pow(10, sDigitCount))
					- (Math.pow(10, (sDigitCount - 1)));
			pickedNumber = (int) ((Math.pow(10, (sDigitCount - 1))) + rand
					.nextInt((int) (total)));
		}

		return pickedNumber;
	}

	public void setOperands() {
		mFirstOperand.setText(randomOperands() + "");
		mSecondOperand.setText(randomOperands() + "");

		checkOperands();
	}

	public void checkOperands() {
		int first = Integer.parseInt(mFirstOperand.getText().toString());
		int second = Integer.parseInt(mSecondOperand.getText().toString());

		if (second > first) {
			mFirstOperand.setText(second + "");
			mSecondOperand.setText(first + "");
		}

		if (mOperator.getText().toString().equals("/")) {
			if (second == 0 || first == 0) {
				setOperands();
			}

			else {
				if (((first / second) * second) != first) {
					setOperands();
				}
			}
		}
	}

	public void onLoad() {
		mScore.setText("0");
		mTimerView.setText("00:30");
		mLevel.setText("1");

		mAddView.setImageResource(R.drawable.addition);

		mOperator.setText("+");
	}

	public void randomOperator() {
		String[] arrayOfString = { "+", "-", "*", "/" };
		List<String> arrayList = new LinkedList<String>();
		for (String s : arrayOfString) {
			arrayList.add(s);

			Collections.shuffle(arrayList);

			mOperator.setText("" + arrayList.get(0));
		}
	}

	public int checkAnswer() {
		int firstOperand;
		int secondOperand;

		firstOperand = Integer.parseInt(mFirstOperand.getText().toString());
		secondOperand = Integer.parseInt(mSecondOperand.getText().toString());

		if (mOperator.getText().toString().equals("+"))
			sAnswer = firstOperand + secondOperand;
		else if (mOperator.getText().toString().equals("-"))
			sAnswer = firstOperand - secondOperand;
		else if (mOperator.getText().toString().equals("*"))
			sAnswer = firstOperand * secondOperand;
		else if (mOperator.getText().toString().equals("/"))
			sAnswer = firstOperand / secondOperand;

		return sAnswer;
	}

	public void changeOperator() {

		mLevelHolder = Integer.parseInt(mLevel.getText().toString());

		mOperatorHolder = mLevelHolder % 10;
		switch (mOperatorHolder) {
		case 1:
			mOperator.setText("+");
			resetColor();
			mAddView.setImageResource(R.drawable.addition);
			break;
		case 2:
			mOperator.setText("-");
			resetColor();
			mSubtractView.setImageResource(R.drawable.subtraction);
			break;
		case 3:
			mOperator.setText("*");
			resetColor();
			mMultiplyView.setImageResource(R.drawable.multiplication);
			break;
		case 4:
			mOperator.setText("/");
			resetColor();
			mDivideView.setImageResource(R.drawable.division);
			break;
		case 5:
			randomOperator();
			resetColor();
			mMixedView.setImageResource(R.drawable.mixed);
			break;
		case 6:
			mOperator.setText("+");
			resetColor();
			mAddView.setImageResource(R.drawable.addition);
			break;
		case 7:
			mOperator.setText("-");
			resetColor();
			mSubtractView.setImageResource(R.drawable.subtraction);
			break;
		case 8:
			mOperator.setText("*");
			resetColor();
			mMultiplyView.setImageResource(R.drawable.multiplication);
			break;
		case 9:
			mOperator.setText("/");
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

	public void alertGameOver() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.game_over_message)
				.setPositiveButton(R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent i = new Intent(getActivity(),
										ItsMathTimeActivity.class);
								startActivity(i);
							}
						}).setCancelable(false).show();
	}

	public class TimerCountDown extends CountDownTimer {
		public TimerCountDown(long startTime, long interval) {
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			mTimerView.setText("Time's up!");
			mAnswer.setEnabled(false);
			mSubmit.setEnabled(false);
			sDigitCount = 1;

			mDate = new Date();

			try {
				mSaveScore.saveScore(mScoreHolder, mLevelHolder, mDate);
			} catch (Exception e) {
				e.printStackTrace();
			}

			alertGameOver();
		}

		@Override
		public void onTick(long millisUntilFinished) {
			mTimerView.setText("00:" + millisUntilFinished / 1000);
		}
	}
}
