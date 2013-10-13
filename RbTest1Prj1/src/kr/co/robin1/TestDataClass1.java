package kr.co.robin1;

public class TestDataClass1 {
	private int idxNumber;
	
	public TestDataClass1() {
		this.idxNumber = 0;
	}
	
	public int getIdxNumber() {
		return idxNumber*3;
	}
	
	public void setIdxNumber(int idx) {
		this.idxNumber = idx;
	}
	
	public int getDouble() {
		return idxNumber*2;
	}

	public int getDouble1() {
		return idxNumber*2 + 15;
	}
	
	public int getDouble2() {
		return idxNumber*2 + 10;
	}
}
