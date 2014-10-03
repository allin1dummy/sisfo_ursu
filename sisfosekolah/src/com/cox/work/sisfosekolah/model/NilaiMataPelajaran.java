package com.cox.work.sisfosekolah.model;

public class NilaiMataPelajaran {
	
	private int[] testTertulis;
	private int[] testLisan;
	private int[] tugas;
	private int[] unjukKerja;
	private int[] unjukKerja2;
	private int[] unjukKerja3;
	private float averageTestTertulis;
	private float averageTestLisan;
	private float averageTugas;
	private float averageUnjukKerja;
	private float averageUnjukKerja2;
	private float averageUnjukKerja3;
	
	public int[] getTestTertulis() {
		return testTertulis;
	}
	public void setTestTertulis(int[] testTertulis) {
		this.testTertulis = testTertulis;
	}
	public int[] getTestLisan() {
		return testLisan;
	}
	public void setTestLisan(int[] testLisan) {
		this.testLisan = testLisan;
	}
	public int[] getTugas() {
		return tugas;
	}
	public void setTugas(int[] tugas) {
		this.tugas = tugas;
	}
	public int[] getUnjukKerja() {
		return unjukKerja;
	}
	public void setUnjukKerja(int[] unjukKerja) {
		this.unjukKerja = unjukKerja;
	}
	public int[] getUnjukKerja2() {
		return unjukKerja2;
	}
	public void setUnjukKerja2(int[] unjukKerja2) {
		this.unjukKerja2 = unjukKerja2;
	}
	public int[] getUnjukKerja3() {
		return unjukKerja3;
	}
	public void setUnjukKerja3(int[] unjukKerja3) {
		this.unjukKerja3 = unjukKerja3;
	}
	public float getAverageTestTertulis() {
		int tot = 0;
		for(int idx=0; idx<testTertulis.length; idx++) {
			tot += testTertulis[idx];
		}
		return tot/testTertulis.length;
	}
	public void setAverageTestTertulis(float averageTestTertulis) {
		this.averageTestTertulis = averageTestTertulis;
	}
	public float getAverageTestLisan() {
		int tot = 0;
		for(int idx=0; idx<testLisan.length; idx++) {
			tot += testLisan[idx];
		}
		return tot/testLisan.length;
	}
	public void setAverageTestLisan(float averageTestLisan) {
		this.averageTestLisan = averageTestLisan;
	}
	public float getAverageTugas() {
		int tot = 0;
		for(int idx=0; idx<tugas.length; idx++) {
			tot += tugas[idx];
		}
		return tot/tugas.length;
	}
	public void setAverageTugas(float averageTugas) {
		this.averageTugas = averageTugas;
	}
	public float getAverageUnjukKerja() {
		int tot = 0;
		for(int idx=0; idx<unjukKerja.length; idx++) {
			tot += unjukKerja[idx];
		}
		return tot/unjukKerja.length;
	}
	public void setAverageUnjukKerja(float averageUnjukKerja) {
		this.averageUnjukKerja = averageUnjukKerja;
	}
	public float getAverageUnjukKerja2() {
		int tot = 0;
		for(int idx=0; idx<unjukKerja2.length; idx++) {
			tot += unjukKerja2[idx];
		}
		return tot/unjukKerja2.length;
	}
	public void setAverageUnjukKerja2(float averageUnjukKerja2) {
		this.averageUnjukKerja2 = averageUnjukKerja2;
	}
	public float getAverageUnjukKerja3() {
		int tot = 0;
		for(int idx=0; idx<unjukKerja3.length; idx++) {
			tot += unjukKerja3[idx];
		}
		return tot/unjukKerja3.length;
	}
	public void setAverageUnjukKerja3(float averageUnjukKerja3) {
		this.averageUnjukKerja3 = averageUnjukKerja3;
	}
}
