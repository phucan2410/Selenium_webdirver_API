package javafortest;

import java.util.Iterator;

public class Topic_07_Loop_Statement {
	
	public static void main(String[] args) {
	
		String[] studentName = {"Trường", "Tiến", "Thơm", "Thu"};
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			
		}
		
		for (int i = 0; i < studentName.length; i++) {
			String string = studentName[i];
			System.out.println(studentName[i]);
		}
		
		for (String add : studentName) {
			System.out.println(add);
		}
	}

}
