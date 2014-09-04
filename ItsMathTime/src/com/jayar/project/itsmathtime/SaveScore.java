package com.jayar.project.itsmathtime;

import java.util.Date;

import android.content.Context;
import android.content.Intent;

public class SaveScore {
	private Context mAppContext;

	public SaveScore(Context appContext) {
		this.mAppContext = appContext;
	}

	public void showList() {
		mAppContext.startActivity(new Intent(mAppContext, ListActivity.class));
	}
	
	public void saveScore(int score, int level, Date date) throws Exception {
		ModelClass mClass = new ModelClass();
		mClass.setScore(Integer.toString(score));
		mClass.setLevel(Integer.toString(level));
		mClass.setDate(date);

		ModelSingleton.get(mAppContext).addDetails(mClass);
		ModelSingleton.get(mAppContext).saveDetails();
	}
}
