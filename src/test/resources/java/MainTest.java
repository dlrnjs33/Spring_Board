package kr.co.prototype.utils;



public class MainTest {

	public static void main(String[] args) {

		String empty = "";
		String masking = "abcdef";
		String exist = "aa,bb,cc,dd";
		String number = null;

		StringUtils stringUtils = new StringUtils();

		/*
		 * boolean isEmpty = stringUtils.isEmpty(empty); System.out.println(isEmpty);
		 * 
		 * System.out.println(stringUtils.toMasking(masking));
		 * 
		 * boolean isExist = stringUtils.isExist(exist); System.out.println(isExist);
		 */
		boolean isNumber = stringUtils.isNumber(number);
		System.out.println(isNumber);
		
		

	}

}
