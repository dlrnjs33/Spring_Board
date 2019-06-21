package kr.co.prototype.domain;

public class Eng extends Subject {

	public Eng(int score) {
		super.score = score;
		super.title = "영어";
	}

	@Override
	public String toString() {
		return "Eng [title=" + title + ", score=" + score + ", getScore()=" + getScore() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
