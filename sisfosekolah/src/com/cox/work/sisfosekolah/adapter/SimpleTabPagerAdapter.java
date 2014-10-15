package com.cox.work.sisfosekolah.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cox.work.sisfosekolah.view.CourseGradeFragment;
import com.cox.work.sisfosekolah.view.SummaryGradeFragment;

public class SimpleTabPagerAdapter extends FragmentPagerAdapter {
	
	private CourseGradeFragment courseGradeFragment;
	private SummaryGradeFragment summaryGradeFragment;

	public SimpleTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
		case 0:
			courseGradeFragment = new CourseGradeFragment();
			return courseGradeFragment;
		case 1:
			summaryGradeFragment = new SummaryGradeFragment();
			return summaryGradeFragment;				
		default:
			return new Fragment();
		}
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return "Aspek Pengetahuan";				
		case 1:
			return "Aspek Lainnya";
		default:
			return "";				
		}
	}
}
