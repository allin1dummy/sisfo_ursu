package com.cox.work.sisfosekolah.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cox.work.sisfosekolah.R;

public class SummaryGradeFragment extends Fragment{
	private View root;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root =  inflater.inflate(R.layout.summary_layout, container, false);
		
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
}
