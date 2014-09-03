package com.jayar.project.itsmathtime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivityFragment extends ListFragment {

	private TextView mScoreTextView;
	private TextView mLevelTextView;
	private TextView mDateTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<ModelClass> mModelClass = null;

		try {
			mModelClass = ModelSingleton.get(getActivity()).getDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ForListAdapter adapter = new ForListAdapter(mModelClass);
		if (adapter.getCount() == 0) {
			Toast.makeText(getActivity(), "No records yet.", Toast.LENGTH_LONG)
					.show();
		}
		setListAdapter(adapter);
	}

	private class ForListAdapter extends ArrayAdapter<ModelClass> {

		public ForListAdapter(ArrayList<ModelClass> modelClasses) {
			super(getActivity(), 0, modelClasses);
		}

		@SuppressLint("SimpleDateFormat")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.score_list, parent, false);
			}

			ModelClass c = getItem(position);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			mScoreTextView = (TextView) convertView.findViewById(R.id.score);
			mScoreTextView.setText(c.getScore());

			mLevelTextView = (TextView) convertView.findViewById(R.id.level);
			mLevelTextView.setText(c.getLevel());

			mDateTextView = (TextView) convertView.findViewById(R.id.date);
			mDateTextView.setText(dateFormat.format(c.getDate()) + "");

			return convertView;
		}
	}

}
