package kr.co.robin1;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Hello World 1");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
