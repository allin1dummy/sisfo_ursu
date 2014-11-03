package com.cox.work.sisfosekolah.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cox.work.sisfosekolah.view.AspekKeterampilanFragment;
import com.cox.work.sisfosekolah.view.AspekPengetahuanFragment;
import com.cox.work.sisfosekolah.view.AspekSikapFragment;

public class SimpleTabPagerAdapter extends FragmentPagerAdapter {
	
	private AspekKeterampilanFragment aspekKeterampilanFragment;
	private AspekPengetahuanFragment aspekPengetahuanFragment;
	private AspekSikapFragment aspekSikapFragment;

	public SimpleTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
		case 0:
			aspekPengetahuanFragment = new AspekPengetahuanFragment();
			return aspekPengetahuanFragment;
		case 1:
			aspekKeterampilanFragment = new AspekKeterampilanFragment();
			return aspekKeterampilanFragment;
		case 2:
			aspekSikapFragment = new AspekSikapFragment();
			return aspekSikapFragment;
		default:
			return new Fragment();
		}
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return "Pengetahuan";
		case 1:
			return "Keterampilan";
		case 2:
			return "Sikap";
		default:
			return "";				
		}
	}
}
