package com.jayar.project.itsmathtime;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

	private static int answer;
	private static int sCount;
	private static int sOperator;
	private static int sScore;

	private int level;
	private static int sDigitCount = 0;

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

	private static int sDotId[] = { R.id.dot1_imageview, R.id.dot2_imageview,
			R.id.dot3_imageview, R.id.dot4_imageview, R.id.dot5_imageview };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.gameplay_screen, container, false);

		// sTime = Integer.parseInt(mTimer.getText().toString());

		final TimerCountDown timer = new TimerCountDown(31000, 1000);
		timer.start();

		mScore = (TextView) v.findViewById(R.id.score_field);

		mTimer = (TextView) v.findViewById(R.id.time_field);

		mLevel = (TextView) v.findViewById(R.id.level);
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
					answer = Integer.parseInt(mAnswer.getText().toString());
					if (answer == checkAnswer()) {

						Toast.makeText(getActivity(), "Correct :)",
								Toast.LENGTH_LONG).show();

						// mFirstOperand.setText(randomBox() + "");
						// mSecondOperand.setText(randomBox() + "");
						changeOperator();
						setOperands();
						checkOperands();

						sCount += 1;
						sScore += 5;
						mDots[sCount - 1].setImageResource(R.drawable.correct);
						mScore.setText(sScore + "");
						mAnswer.setText("");
					} else {
						Toast.makeText(getActivity(),
								mAnswer.getText() + "Wrong :(" + checkAnswer(),
								Toast.LENGTH_SHORT).show();
					}
				}

				if (sCount == 5) {
					sCount = 0;

					for (int i = 0; i < 5; i++) {
						mDots[i].setImageResource(R.drawable.wrong);
					}

					level += 1;
					mLevel.setText(level + "");

					sDigitCount += 1;
					Toast.makeText(getActivity(), "" + sDigitCount,
							Toast.LENGTH_SHORT).show();

					changeOperator();
					timer.cancel();
					timer.start();
				}
			}
		});

		onLoad();
		setOperands();
		checkOperands();
		changeOperator();

		return v;
	}

	public static int randomBox() {
		double total = Math.pow(10, sDigitCount);
		Random rand = new Random();
		int pickedNumber = (int) ((Math.pow(10, (sDigitCount + 1)) - 1) + rand
				.nextInt((int) total));
		return pickedNumber;
	}

	public void setOperands() {
		mFirstOperand.setText(randomBox() + "");
		mSecondOperand.setText(randomBox() + "");
	}

	public void checkOperands() {
		int first = Integer.parseInt(mFirstOperand.getText().toString());
		int second = Integer.parseInt(mSecondOperand.getText().toString());

		if (second > first) {
			setOperands();
		}

		if (mOperator.getText().toString().equals("/")) {
			if (second == 0)
				setOperands();
			else {
				if (first != ((first / second) * second)) {
					setOperands();
				}
			}
		}
	}

	public void onLoad() {
		mScore.setText("0");
		mTimer.setText("00:30");
		mLevel.setText("1");

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

	public static int checkAnswer() {
		int firstOperand;
		int secondOperand;

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
	}

	public void changeOperator() {

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

	public class TimerCountDown extends CountDownTimer {
		public TimerCountDown(long startTime, long interval) {
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			mTimer.setText("Time's up!");
			mAnswer.setEnabled(false);
			mSubmit.setEnabled(false);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			mTimer.setText("00:" + millisUntilFinished / 1000);
		}
	}

}
