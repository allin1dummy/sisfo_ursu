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

public class CourseGradeFragment extends Fragment implements OnClickListener{
	private View root;
	private ImageButton btnDetail1;
	private ImageButton btnDetail2;
	private ImageButton btnDetail3;
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

        mChart.setDescription("Mata Pelajaran:");

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
        yl.setLabelCount(8);
        
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
        yVals1.add(new BarEntry((float) (Math.random() * 9), 1));
        yVals1.add(new BarEntry((float) (Math.random() * 8), 2));
        
        BarDataSet set1 = new BarDataSet(yVals1, "Dataset");
        set1.setBarSpacePercent(35f);
        //set1.setColor(Color.RED);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
		return data;
	}

	private void createBarChartX() {
		BarChart bChart =  (BarChart) root.findViewById(R.id.barchart);
		bChart.setData(getBarData());
		bChart.setDescription("Mata Pelajaran:");
		bChart.setValueTextSize(10f);
		//bChart.setDrawingEnabled(true);
        // scaling can now only be done on x- and y-axis separately
		bChart.setPinchZoom(false);
		bChart.setTouchEnabled(false);
		bChart.setDrawGridBackground(false);
		bChart.setDrawHorizontalGrid(true);
		bChart.setDrawVerticalGrid(true);
		bChart.setDrawBorder(false);
		bChart.setDrawValueAboveBar(false);

        XLabels xl = bChart.getXLabels();
        xl.setPosition(XLabelPosition.BOTTOM);
        xl.setCenterXLabelText(true);
        
        YLabels yl = bChart.getYLabels();
        yl.setLabelCount(8);
        
        Legend l = bChart.getLegend();
        l.setPosition(LegendPosition.BELOW_CHART_LEFT);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);
	}

	private void createLineChart() {
		LineChart chart = (LineChart) root.findViewById(R.id.linechart);
		chart.setData(getDataSet());
		chart.setDescription("Mata Pelajaran:");
	}

//	private void createLineChart() {
//		int[] x = new int[]{0,1,2,3,4,5,6,7,8,9};
//		int[] y = new int[]{10,12,23,13,24,15,36,27,20,9};
//		XYSeries series = new XYSeries("Test Nilai");
//		for (int i=0; i<x.length; i++) {
//		    series.add(x[i], y[i]);
//		}
//		
//		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
//		dataset.addSeries(series);
//		
//		// Now we create the renderer
//		XYSeriesRenderer renderer = new XYSeriesRenderer();
//		renderer.setLineWidth(5);
//		renderer.setColor(Color.RED);
//		// Include low and max value
//		renderer.setDisplayBoundingPoints(true);
//		// we add point markers
//		renderer.setPointStyle(PointStyle.CIRCLE);
//		renderer.setPointStrokeWidth(7);
//		
//		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
//		mRenderer.addSeriesRenderer(renderer);
//		// We want to avoid black border
//		mRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00)); // transparent margins
//		// Disable Pan on two axis
//		mRenderer.setPanEnabled(false, false);
//		mRenderer.setYAxisMax(51);
//		mRenderer.setYAxisMin(0);
//		mRenderer.setShowGrid(false); // we show the grid
//		mRenderer.setChartTitle("Testtt");
//		mRenderer.setXTitle("xxx");
//		mRenderer.setYTitle("yyy");
//		mRenderer.setAxesColor(Color.BLUE);
//		mRenderer.setGridColor(Color.YELLOW);
//		mRenderer.setXLabelsColor(Color.GREEN);
//		mRenderer.setYAxisColor(Color.MAGENTA);
//		//mRenderer.setYLabelsColor(Color.CYAN, Color.BLACK);
//		
//		GraphicalView chartView = ChartFactory.getLineChartView(getActivity(), dataset, mRenderer);
//		mLayoutDetail2.addView(chartView);
//	}

	private void initView() {
		btnDetail1 = (ImageButton) root.findViewById(R.id.ib_detail_1);
    	btnDetail1.setOnClickListener(this);
    	btnDetail2 = (ImageButton) root.findViewById(R.id.ib_detail_2);
    	btnDetail2.setOnClickListener(this);
    	btnDetail3 = (ImageButton) root.findViewById(R.id.ib_detail_3);
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
	    
	    Entry c1e1 = new Entry(9f, 0); // 0 == quarter 1
	    valsComp1.add(c1e1);
	    Entry c1e2 = new Entry(7.8f, 1); // 1 == quarter 2 ...
	    valsComp1.add(c1e2);
	    // and so on ...

	    Entry c2e1 = new Entry(8.5f, 0); // 0 == quarter 1
	    valsComp2.add(c2e1);
	    Entry c2e2 = new Entry(9.5f, 1); // 1 == quarter 2 ...
	    valsComp2.add(c2e2);
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
	
	private BarData getBarData() {
		ArrayList<BarEntry> valsComp1 = new ArrayList<BarEntry>();
	    ArrayList<BarEntry> valsComp2 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> valsComp3 = new ArrayList<BarEntry>();
	    ArrayList<BarEntry> valsComp4 = new ArrayList<BarEntry>();
	    
	    BarEntry be1 = new BarEntry(85f, 0);
	    valsComp1.add(be1);
	    BarEntry be2 = new BarEntry(95f, 1);
	    valsComp2.add(be2);
	    BarEntry be3 = new BarEntry(78f, 2);
	    valsComp3.add(be3);
	    BarEntry be4 = new BarEntry(69f, 3);
	    valsComp4.add(be4);
	    //BarEntry be5 = new BarEntry(60f, 4);
	    //valsComp5.add(be5);
	    // and so on ...

	    BarDataSet setComp1 = new BarDataSet(valsComp1, "Matematika");
	    BarDataSet setComp2 = new BarDataSet(valsComp2, "Kesenian");
	    BarDataSet setComp3 = new BarDataSet(valsComp3, "IPA");
	    BarDataSet setComp4 = new BarDataSet(valsComp4, "IPS");
	    
	    ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
	    dataSets.add(setComp1);
	    dataSets.add(setComp2);
	    dataSets.add(setComp3);
	    dataSets.add(setComp4);

	    ArrayList<String> xVals = new ArrayList<String>();
	    xVals.add("I"); xVals.add("II"); xVals.add("III"); xVals.add("IV"); 
	    
		BarData dt = new BarData(xVals, dataSets);
	    return dt;
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
