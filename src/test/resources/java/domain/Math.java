package kr.co.prototype.domain;

public class Math extends Subject {

	public Math(int score) {
		super.score = score;
		super.title = "수학";
	}

	@Override
	public String toString() {
		return "Math [title=" + title + ", score=" + score + ", getScore()=" + getScore() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
