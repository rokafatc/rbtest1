package kr.co.robin1;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Hello World 1");
		
		TestDataClass1 tdc1 = new TestDataClass1();
		tdc1.setIdxNumber(22);
		String rtnMsg = String.format("Return Result: %d", tdc1.getIdxNumber());
		System.out.println(rtnMsg);
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
