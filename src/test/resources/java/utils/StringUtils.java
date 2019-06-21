package kr.co.prototype.utils;

public class StringUtils {

	public boolean isEmpty(String input) {
		if ("".equals(input) || input == null) {
			return true;
		} else {
			return false;
		}
	}

	public String toMasking(String input) {

		String star = "";
		int max = 2;
		int len = input.length() - max;

		for (int i = 0; i < len; i++) {
			star += "*";
		}

		String ex2 = input.replace(input.substring(max, input.length()), star);
		String result = ex2 + ',' + input.length();

		return result;
	}

	public boolean isExist(String input) {
		String str = "bb";
		String[] arr = input.split(",");
		boolean result = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				return true;
			}
		}

		return false;

	}

//	public boolean isNumber(String input) {
//		char ch; // char ch = ' ';
//
//		try {
//			for (int i = 0; i < input.length(); i++) {
//				ch = input.charAt(i);
//				if ('0' <= ch && ch <= '9') {
//					continue;
//				}
//				return false;
//			}
//		} catch (NullPointerException e) {
//			return false;
//		}
//
//		return true;
//	}

	public boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}