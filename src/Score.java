
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fahadahmed
 */
public class Score implements Comparator<Score> {
	private int score;
	private String name;

	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Score() {
	}
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
	}

	@Override
	public int compare(Score score1, Score score2) {
		return score1.getScore() - score2.getScore();
	}
}
