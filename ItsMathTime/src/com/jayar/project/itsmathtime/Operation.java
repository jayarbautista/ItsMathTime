package com.jayar.project.itsmathtime;

public class Operation {
	
	private int mLevel;
	private int mFirstOperand;
	private int mSecondOperand;
	private int mAnswer;
	private String mOperator;
	
	public int getLevel() {
		return mLevel;
	}
	
	public void setLevel(int level) {
		mLevel = level;
	}
	
	public int getFirstOperand() {
		return mFirstOperand;
	}
	
	public void setFirstOperand(int firstOperand) {
		mFirstOperand = firstOperand;
	}
	
	public int getSecondOperand() {
		return mSecondOperand;
	}
	
	public void setSecondOperand(int secondOperand) {
		mSecondOperand = secondOperand;
	}
	
	public String getOperator() {
		return mOperator;
	}
	
	public void setOperator(String operator) {
		mOperator = operator;
	}
	
	public int getAnswer() {
		return mAnswer;
	}
	
	public void setAnswer(int answer) {
		getOperator();
		mAnswer = answer;
	}
}
