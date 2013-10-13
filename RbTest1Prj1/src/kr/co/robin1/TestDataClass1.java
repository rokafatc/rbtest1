package kr.co.robin1;

public class TestDataClass1 {
	private int idxNumber;
	
	public TestDataClass1() {
		this.idxNumber = 0;
	}
	
	public int getIdxNumber() {
		return idxNumber*2;
	}
	
	public void setIdxNumber(int idx) {
		this.idxNumber = idx;
	}
}
