package com.jayar.project.itsmathtime;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class ModelClass implements Serializable, Comparable<ModelClass> {

	private static final String JSON_SCORE = "score";
	private static final String JSON_LEVEL = "level";
	private static final String JSON_DATE = "date";

	private String mScore;
	private String mLevel;
	private Date mDate;

	// thinking of using static factory instead
	public ModelClass() {
		// used for initialization
	}

	public ModelClass(JSONObject jsonObject) throws JSONException {

		mScore = jsonObject.getString(JSON_SCORE);
		mLevel = jsonObject.getString(JSON_LEVEL);
        mDate = new Date(jsonObject.getLong(JSON_DATE));
	}

	public JSONObject toJsonObject() throws JSONException {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(JSON_SCORE, mScore);
		jsonObject.put(JSON_LEVEL, mLevel);
        jsonObject.put(JSON_DATE, mDate.getTime());

		return jsonObject;
	}

	public String getScore() {
		return mScore;
	}

	public void setScore(String score) {
		mScore = score;
	}

	public String getLevel() {
		return mLevel;
	}

	public void setLevel(String level) {
		mLevel = level;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	@Override
	public int compareTo(ModelClass another) {
		return Integer.parseInt(another.mScore) - Integer.parseInt(this.mScore);
	}

}
