package kr.co.prototype.domain;

public class StudentScore {
	private String name;
	private Kor kor;
	private Eng eng;
	private Math math;
	private int sum;
	private double avg;
	private String grade;

	public StudentScore() {
		super();
	}

	public StudentScore(String name, Kor kor, Eng eng, Math math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor.getScore() + eng.getScore() + math.getScore();
		this.avg = (kor.getScore() + eng.getScore() + math.getScore()) / 3.0;
		this.grade = grade();
	}

	public StudentScore(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = new Kor(kor);
		this.eng = new Eng(eng);
		this.math = new Math(math);
		this.sum = kor + eng + math;
		this.avg = (kor + eng + math) / 3.0;
		this.grade = grade();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kor getKor() {
		return kor;
	}

	public void setKor(Kor kor) {
		this.kor = kor;
	}

	public Eng getEng() {
		return eng;
	}

	public void setEng(Eng eng) {
		this.eng = eng;
	}

	public Math getMath() {
		return math;
	}

	public void setMath(Math math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String grade() {
		if (avg >= 90) {
			return grade = "A";
		} else if (avg >= 80) {
			return grade = "B";
		} else {
			return grade = "C";
		}
	}

	@Override
	public String toString() {
		return " [sum=" + sum + "]";
	}

}
