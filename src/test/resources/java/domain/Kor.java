package kr.co.prototype.domain;

public class Kor extends Subject {

	public Kor(int score) {
		super.score = score;
		super.title = "국어";
	}

	@Override
	public String toString() {
		return "Kor [title=" + title + ", score=" + score + ", getScore()=" + getScore() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
