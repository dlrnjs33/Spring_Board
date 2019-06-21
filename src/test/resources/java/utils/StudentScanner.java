package kr.co.prototype.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import kr.co.prototype.domain.StudentScore;

public class StudentScanner {

	Scanner scan = new Scanner(System.in);
	ArrayList<StudentScore> list = new ArrayList<StudentScore>();
	StudentUtils ut = new StudentUtils();

	public void scanner() {
		try {
			System.out.println("1.등록   2.조회   3.수정   4.삭제");
			System.out.print(">>> ");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				register();
				System.out.println("등록 완료");
				System.out.println();
				scanner();
				break;
			case 2:
				lookup();
				ut.rank(list);
				scanner();
				break;
			case 3:
				modify();
				System.out.print("변경 완료");
				System.out.println();
				scanner();
				break;
			case 4:
				delete();
				System.out.print("삭제 완료");
				System.out.println();
				scanner();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력");
		}

	}

	public void register() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.println();
		System.out.print("국어 점수 : ");
		int kor = scan.nextInt();
		System.out.println();
		System.out.print("수학 점수 : ");
		int math = scan.nextInt();
		System.out.println();
		System.out.print("영어 점수 : ");
		int eng = scan.nextInt();
		System.out.println();

		list.add(new StudentScore(name, kor, eng, math));
	}

	public void lookup() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + list.get(i).getName());
			System.out.println("국어점수 : " + list.get(i).getKor().getScore());
			System.out.println("영어점수 : " + list.get(i).getEng().getScore());
			System.out.println("수학점수 : " + list.get(i).getMath().getScore());
			System.out.println("총점 : " + list.get(i).getSum());
			System.out.println("평균 : " + list.get(i).getAvg());
			System.out.println("등급 : " + list.get(i).getGrade());
			System.out.println("--------------------------");
		}
	}

	public void modify() {
		System.out.println("변경할 이름 입력");
		String modifyName = scan.next();
		System.out.println("변경할 과목명");
		String modifySubject = scan.next();
		System.out.println("변경할 점수");
		int modifyScore = scan.nextInt();

		StudentScore tmp = new StudentScore();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(modifyName)) {
				tmp = list.get(i);
			}
		}

		if (tmp.getKor().getTitle().contains(modifySubject)) {
			tmp.getKor().setScore(modifyScore);
		} else if (tmp.getEng().getTitle().contains(modifySubject)) {
			tmp.getEng().setScore(modifyScore);
		} else {
			tmp.getMath().setScore(modifyScore);
		}
	}

	public void delete() {
		System.out.println("삭제할 이름 입력 : ");
		String deleteName = scan.next();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(deleteName)) {
				list.remove(i);
			}
		}
	}

}
