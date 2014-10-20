package com.cox.work.sisfosekolah.view;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cox.work.sisfosekolah.R;

public class SummaryGradeFragment extends Fragment implements OnClickListener{
	private View root;
	private ArrayList<View> buttonList;
	private TextView btnDetail1;
	private TextView btnDetail2;
	private TextView btnDetail3;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		root =  inflater.inflate(R.layout.summary_layout, container, false);

		btnDetail1 = (TextView) root.findViewById(R.id.tv_xxx_tulis);
    	btnDetail1.setOnClickListener(this);
    	btnDetail2 = (TextView) root.findViewById(R.id.tv_xxx_lisan);
    	btnDetail2.setOnClickListener(this);
    	btnDetail3 = (TextView) root.findViewById(R.id.tv_xxx_tugas);
    	btnDetail3.setOnClickListener(this);
    	
    	buttonList = new ArrayList<View>();
    	buttonList.add(btnDetail1);
    	buttonList.add(btnDetail2);
    	buttonList.add(btnDetail3);
    	
		
//	    LineSet lineSet = new LineSet();
//	    lineSet.addPoint(new Point("x", 10f));
//
//	    // Style dots
//	    lineSet.setDots(true);
//	    lineSet.setDotsColor(color.black);
//	    //lineSet.setDotsRadius(dimen);
//	    //lineSet.setDotsStrokeThickness(dimen);
//	    //lineSet.setDotsStrokeColor(color);
//
//	    // Style line
//	    lineSet.setLineThickness(2f);
//	    lineSet.setLineColor(color.black);
//
//	    // Style background fill
//	    lineSet.setFill(true);
//	    //lineSet.setFillColor(color);
//
//	    // Style type
//	    lineSet.setDashed(true);
//	    lineSet.setSmooth(true);
//	    
//	    LineChartView lc = (LineChartView)root.findViewById(R.id.chartview);
//	    lc.addData(lineSet);
		
		return root;
	}
	

	@Override
	public void onClick(View v) {
		Log.e("cox", "onClick - id = " + v.getId());
		setBackground(v);
		setActiveTab(v);
	}

    private void setBackground(View v){
		for(int i = 0 ; i < buttonList.size(); i++){
			if (v.getId() == buttonList.get(i).getId()) {
				v.setBackgroundResource(R.drawable.button_rounded_left_grey_selected);
			} else {
				buttonList.get(i).setBackgroundResource(R.drawable.button_rounded_left_grey_unselected);
			}
		}
	}

	private void setActiveTab(View v) {
		Log.e("cox", "setActiveTab");
		for(int i=0; i<buttonList.size(); i++) {
			if(v.getId()==buttonList.get(0).getId()) {
				Log.e("cox", "setActiveTab - detail_1");
				root.findViewById(R.id.detail_1).setVisibility(View.VISIBLE);
				root.findViewById(R.id.detail_2).setVisibility(View.GONE);
				root.findViewById(R.id.detail_3).setVisibility(View.GONE);
			} else if(v.getId()==buttonList.get(1).getId()) {
				Log.e("cox", "setActiveTab - detail_2");
				root.findViewById(R.id.detail_1).setVisibility(View.GONE);
				root.findViewById(R.id.detail_2).setVisibility(View.VISIBLE);
				root.findViewById(R.id.detail_3).setVisibility(View.GONE);
			} else if(v.getId()==buttonList.get(2).getId()) {
				Log.e("cox", "setActiveTab - detail_3");
				root.findViewById(R.id.detail_1).setVisibility(View.GONE);
				root.findViewById(R.id.detail_2).setVisibility(View.GONE);
				root.findViewById(R.id.detail_3).setVisibility(View.VISIBLE);
			}
		}
	}
}
