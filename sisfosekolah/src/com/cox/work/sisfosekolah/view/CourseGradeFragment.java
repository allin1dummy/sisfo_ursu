package com.cox.work.sisfosekolah.view;

import java.util.ArrayList;

import com.cox.work.sisfosekolah.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

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

		LineChart chart = (LineChart) root.findViewById(R.id.chart);
		chart.setData(getDataSet());
		//BarChart chart= (BarChart) root.findViewById(R.id.chart);
		//chart.setData(getBarData());
		
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
	
	private LineData getDataSet() {
		ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
	    ArrayList<Entry> valsComp2 = new ArrayList<Entry>();
	    
	    Entry c1e1 = new Entry(100.000f, 0); // 0 == quarter 1
	    valsComp1.add(c1e1);
	    Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
	    valsComp1.add(c1e2);
	    // and so on ...

	    Entry c2e1 = new Entry(120.000f, 0); // 0 == quarter 1
	    valsComp2.add(c2e1);
	    Entry c2e2 = new Entry(110.000f, 1); // 1 == quarter 2 ...
	    valsComp2.add(c2e2);
	    //...
	    
	    LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
	    LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");
	    
	    ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
	    dataSets.add(setComp1);
	    dataSets.add(setComp2);

	    ArrayList<String> xVals = new ArrayList<String>();
	    xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q"); 

	    LineData data = new LineData(xVals, dataSets);
	    return data;
	}
	
	private BarData getBarData() {
		ArrayList<BarEntry> valsComp1 = new ArrayList<BarEntry>();
	    ArrayList<BarEntry> valsComp2 = new ArrayList<BarEntry>();
	    
	    Entry c1e1 = new Entry(100.000f, 0); // 0 == quarter 1
	    valsComp1.add((BarEntry) c1e1);
	    Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
	    valsComp1.add((BarEntry) c1e2);
	    // and so on ...

	    Entry c2e1 = new Entry(120.000f, 0); // 0 == quarter 1
	    valsComp2.add((BarEntry) c2e1);
	    Entry c2e2 = new Entry(110.000f, 1); // 1 == quarter 2 ...
	    valsComp2.add((BarEntry) c2e2);
	    //...
	    
	    BarDataSet setComp1 = new BarDataSet(valsComp1, "Company 1");
	    BarDataSet setComp2 = new BarDataSet(valsComp2, "Company 2");
	    
	    ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
	    dataSets.add(setComp1);
	    dataSets.add(setComp2);

	    ArrayList<String> xVals = new ArrayList<String>();
	    xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q"); 
	    
		BarData dt = new BarData(xVals, dataSets);
	    return dt;
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
