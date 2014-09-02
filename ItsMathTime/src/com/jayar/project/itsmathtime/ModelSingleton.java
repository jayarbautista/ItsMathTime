package com.jayar.project.itsmathtime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import android.content.Context;
public class ModelSingleton {

	private static final String FILENAME = "score.json";

	private ArrayList<ModelClass> mModelClasses;

	private JSONSerializer mJsonSerializer;

	private static ModelSingleton sModelSingleton;

	private ModelSingleton(Context context) {
		mJsonSerializer = new JSONSerializer(context, FILENAME);
		try {
			mModelClasses = highScores();
		} catch (Exception e) {
			mModelClasses = new ArrayList<ModelClass>();
			e.printStackTrace();
		}
	}

	public static ModelSingleton get(Context c) throws Exception {
		if (sModelSingleton == null) {
			sModelSingleton = new ModelSingleton(c.getApplicationContext());
		}

		return sModelSingleton;

	}

	public ArrayList<ModelClass> getDetails() {
		return highScores();
	}

	public void addDetails(ModelClass c) {
		mModelClasses.add(c);
	}

	public boolean saveDetails() throws JSONException, IOException {
		mJsonSerializer.saveDetails(mModelClasses);
		return true;
	}

	// Sorting Scores in descending order
	public ArrayList<ModelClass> highScores() {

<<<<<<< HEAD
		ArrayList<ModelClass> tempModelClasses = new ArrayList<ModelClass>();
		ArrayList<ModelClass> tempModelClasses2 = new ArrayList<ModelClass>();
		try {
			tempModelClasses = mJsonSerializer.loadDetails();
=======
		ArrayList<ModelClass> tempModelClass1 = new ArrayList<ModelClass>();
		ArrayList<ModelClass> tempModelClass2 = new ArrayList<ModelClass>();
		try {
			tempModelClass1 = mJsonSerializer.loadDetails();
>>>>>>> issue2
		} catch (Exception e1) {
			e1.printStackTrace();
		}

<<<<<<< HEAD
		Collections.sort(tempModelClasses);

		for (ModelClass mC : tempModelClasses) {
			if (tempModelClasses2.size() > 9)
				break;
			tempModelClasses2.add(mC);
		}
		return tempModelClasses2;
=======
		Collections.sort(tempModelClass1);

		for (ModelClass mC : tempModelClass1) {
			if (tempModelClass2.size() > 9)
				break;
			tempModelClass2.add(mC);
		}
		return tempModelClass2;
>>>>>>> issue2
	}
}
