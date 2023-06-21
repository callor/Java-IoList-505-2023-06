package com.callor.iolist.exec;

public class IsEmptyAndIsBlank {
	
	public static void main(String[] args) {
		String nation1 = "";
		
		// white space : 다른 문자열이 없이 space 만 있는 문자열
		String nation2 = "    ";
		
		System.out.println(nation1.equals(""));
		
		System.out.println(nation1.isEmpty());
		System.out.println(nation1.isBlank());
		
		System.out.println(nation2.isEmpty());

		// java 11 에서는 isBlank 를 지원하지만
		// 이전 버전에서는 isBlank 를 사용할 수 없다.
		// 이때는 문자열을 trim() method 를 한번 통과시켜
		// white space 등을 제거한다
		System.out.println(nation2.isBlank()); // JDK 11 ~
		System.out.println(nation2.trim().isEmpty()); // JDK 11 이전
		
	}

}
