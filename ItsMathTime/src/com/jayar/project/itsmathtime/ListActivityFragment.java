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
		//if(adapter.getCount() > 5) {
			//adapter.notifyDataSetChanged();
		//}
		setListAdapter(adapter);
	}

	private class ForListAdapter extends ArrayAdapter<ModelClass> {

		public ForListAdapter(ArrayList<ModelClass> modelClasses) {
			super(getActivity(), 0, modelClasses);
		}

		@SuppressLint("SimpleDateFormat")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView scoreTextView;
			TextView levelTextView;
			TextView dateTextView;

			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.fragment_main_odd, parent, false);
			}
			
			ModelClass c = getItem(position);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			scoreTextView = (TextView) convertView.findViewById(R.id.score);
			scoreTextView.setText(c.getScore());
			
			levelTextView = (TextView) convertView.findViewById(R.id.level);
			levelTextView.setText(c.getLevel());
			
			dateTextView = (TextView) convertView.findViewById(R.id.date);
			dateTextView.setText(dateFormat.format(c.getDate())+"");

			return convertView;
		}
	}

}
