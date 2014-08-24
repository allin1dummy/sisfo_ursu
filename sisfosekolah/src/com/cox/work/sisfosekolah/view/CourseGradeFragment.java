package com.cox.work.sisfosekolah.view;

import java.util.ArrayList;

import com.cox.work.sisfosekolah.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class CourseGradeFragment extends Fragment implements OnClickListener{
	private View root;
	private ImageButton btnDetail1;
	private ImageButton btnDetail2;
	private ImageButton btnDetail3;
	private ArrayList<View> buttonList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.course_grade_layout, container, false);

    	btnDetail1 = (ImageButton) root.findViewById(R.id.detail_1);
    	btnDetail1.setOnClickListener(this);
    	btnDetail2 = (ImageButton) root.findViewById(R.id.detail_2);
    	btnDetail2.setOnClickListener(this);
    	btnDetail3 = (ImageButton) root.findViewById(R.id.detail_3);
    	btnDetail3.setOnClickListener(this);
    	buttonList = new ArrayList<View>();
    	buttonList.add(btnDetail1);
    	buttonList.add(btnDetail2);
    	buttonList.add(btnDetail3);
		return root;
	}

    private void setBackground(View v){
		for(int i = 0 ; i < buttonList.size(); i++){
			View view = buttonList.get(i);
			if(v.getId() == view.getId()){
				v.setBackgroundResource(R.drawable.button_rounded_left_grey_selected);							
			}else{
				view.setBackgroundResource(R.drawable.button_rounded_left_grey_unselected);											
			}
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_1:
			setBackground(v);
			break;
		case R.id.detail_2:
			setBackground(v);
			break;
		default:
			setBackground(v);
			break;
		}
	}
}
