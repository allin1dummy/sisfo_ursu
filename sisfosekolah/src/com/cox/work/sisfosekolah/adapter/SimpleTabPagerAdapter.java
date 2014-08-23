package com.cox.work.sisfosekolah.adapter;

import com.cox.work.sisfosekolah.view.CourseGradeFragment;
import com.cox.work.sisfosekolah.view.SummaryGradeFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
			return "Nilai Mata Pelajaran";				
		case 1:
			return "Kesimpulan";					
		default:
			return "Nilai Mata Pelajaran";				
		}
	}
}
