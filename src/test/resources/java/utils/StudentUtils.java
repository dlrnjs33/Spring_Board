package kr.co.prototype.utils;

import java.util.ArrayList;

import kr.co.prototype.domain.StudentScore;

public class StudentUtils {

	public int sum(ArrayList<StudentScore> list) {
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getSum();
		}
		return total;
	}

	public double avg(ArrayList<StudentScore> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += (list.get(i).getAvg());
		}
		return sum / list.size();
	}

	public void rank(ArrayList<StudentScore> list) {
		StudentScore temp;

		for (int i = list.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (list.get(j).getSum() < list.get(j + 1).getSum()) {
					int index = list.indexOf(list.get(j + 1));
					temp = new StudentScore();
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(index, temp);
				}
			}
		}
		for (int k = 0; k < list.size(); k++) {
			System.out.println(k + 1 + "등 : " + list.get(k).getName());
			System.out.println();
		}
	}
}