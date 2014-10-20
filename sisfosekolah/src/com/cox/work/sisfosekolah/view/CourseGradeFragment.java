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
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;
import com.github.mikephil.charting.utils.Legend.LegendPosition;
import com.github.mikephil.charting.utils.XLabels.XLabelPosition;
import com.github.mikephil.charting.utils.YLabels.YLabelPosition;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseGradeFragment extends Fragment implements OnClickListener{
	private View root;
	private TextView btnDetail1;
	private TextView btnDetail2;
	private TextView btnDetail3;
	private LinearLayout mLayoutDetail1;
	private LinearLayout mLayoutDetail2;
	private LinearLayout mLayoutDetail3;
	private ArrayList<View> buttonList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.course_grade_layout, container, false);
    	initView();

		createLineChart();
		createBarChart();
		//BarChart chart= (BarChart) root.findViewById(R.id.chart);
		//chart.setData(getBarData());
		
		
		//createLineChart();
		
		return root;
	}

	private void createBarChart() {
		BarChart mChart = (BarChart) root.findViewById(R.id.barchart);

        // enable the drawing of values
        mChart.setDrawYValues(true);

        mChart.setDescription(" ");

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        //mChart.setMaxVisibleValueCount(60);

        // sets the number of digits for values inside the chart
        //mChart.setValueDigits(2);

        // disable 3D
        mChart.set3DEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
//        mChart.setDrawBarShadow(true);

        //mChart.setUnit(" €");

        // change the position of the y-labels
        //YLabels yLabels = mChart.getYLabels();
        //yLabels.setPosition(YLabelPosition.LEFT);

        //XLabels xLabels = mChart.getXLabels();
        //xLabels.setPosition(XLabelPosition.TOP);
        // mChart.setDrawXLabels(false);

        mChart.setDrawGridBackground(true);
        mChart.setDrawHorizontalGrid(true);
        mChart.setDrawVerticalGrid(true);
        mChart.setDrawYLabels(true);
        
        // sets the text size of the values inside the chart
        mChart.setValueTextSize(10f);

        mChart.setDrawBorder(true);
        // mChart.setBorderPositions(new BorderPosition[] {BorderPosition.LEFT,
        // BorderPosition.RIGHT});
        
        BarData data = createBarData();
        mChart.setData(data);

        XLabels xl = mChart.getXLabels();
        xl.setPosition(XLabelPosition.BOTTOM);
        xl.setCenterXLabelText(true);
        
        YLabels yl = mChart.getYLabels();
        yl.setLabelCount(10);
        Log.e("cox", yl.toString());
        
        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.BELOW_CHART_LEFT);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);
	}

	private BarData createBarData() {
		ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("IPA");
        xVals.add("IPS");
        xVals.add("IPB");

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        yVals1.add(new BarEntry((float) (Math.random() * 10), 0));
        yVals1.add(new BarEntry((float) (Math.random() * 10), 1));
        yVals1.add(new BarEntry((float) (Math.random() * 10), 2));
        
        BarDataSet set1 = new BarDataSet(yVals1, "Dataset");
        set1.setBarSpacePercent(35f);
        //set1.setColor(Color.RED);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
		return data;
	}

	private void createLineChart() {
		LineChart chart = (LineChart) root.findViewById(R.id.linechart);
		chart.setData(getDataSet());
		chart.setDescription("Mata Pelajaran:");
		chart.setMaxScaleY(10f);

        XLabels xl = chart.getXLabels();
        xl.setPosition(XLabelPosition.BOTTOM);
	}

	private void initView() {
		btnDetail1 = (TextView) root.findViewById(R.id.tv_knowledge_tulis);
    	btnDetail1.setOnClickListener(this);
    	btnDetail2 = (TextView) root.findViewById(R.id.tv_knowledge_lisan);
    	btnDetail2.setOnClickListener(this);
    	btnDetail3 = (TextView) root.findViewById(R.id.tv_knowledge_tugas);
    	btnDetail3.setOnClickListener(this);
    	buttonList = new ArrayList<View>();
    	buttonList.add(btnDetail1);
    	buttonList.add(btnDetail2);
    	buttonList.add(btnDetail3);
    	mLayoutDetail1 = (LinearLayout) root.findViewById(R.id.detail_1);
    	mLayoutDetail1.setOnClickListener(this);
    	mLayoutDetail2 = (LinearLayout) root.findViewById(R.id.detail_2);
    	mLayoutDetail2.setOnClickListener(this);
    	mLayoutDetail3 = (LinearLayout) root.findViewById(R.id.detail_3);
    	mLayoutDetail3.setOnClickListener(this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		Log.e("cox", "onResume");
	}
	
	private LineData getDataSet() {
		ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
	    ArrayList<Entry> valsComp2 = new ArrayList<Entry>();
	    
	    Entry c1e1 = new Entry((float)(Math.random() * 10), 0);
	    valsComp1.add(c1e1);
	    Entry c1e2 = new Entry((float)(Math.random() * 10), 1);
	    valsComp1.add(c1e2);
	    Entry c1e3 = new Entry((float)(Math.random() * 10), 2);
	    valsComp1.add(c1e3);
	    Entry c1e4 = new Entry((float)(Math.random() * 10), 3);
	    valsComp1.add(c1e4);
	    // and so on ...

	    Entry c2e1 = new Entry((float)(Math.random() * 10), 0);
	    valsComp2.add(c2e1);
	    Entry c2e2 = new Entry((float)(Math.random() * 10), 1);
	    valsComp2.add(c2e2);
	    Entry c2e3 = new Entry((float)(Math.random() * 10), 2);
	    valsComp2.add(c2e3);
	    Entry c2e4 = new Entry((float)(Math.random() * 10), 3);
	    valsComp2.add(c2e4);
	    //...
	    
	    LineDataSet setComp1 = new LineDataSet(valsComp1, "Math");
	    setComp1.setColor(Color.RED);
	    LineDataSet setComp2 = new LineDataSet(valsComp2, "Social");
	    setComp2.setColor(Color.BLACK);
	    
	    ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
	    dataSets.add(setComp1);
	    dataSets.add(setComp2);

	    ArrayList<String> xVals = new ArrayList<String>();
	    xVals.add("I"); xVals.add("II"); xVals.add("III"); xVals.add("IV"); 

	    LineData data = new LineData(xVals, dataSets);
	    return data;
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

	@Override
	public void onClick(View v) {
		Log.e("cox", "onClick - id = " + v.getId());
		setBackground(v);
		setActiveTab(v);
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
