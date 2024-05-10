package Game;
import Game.Questions;
import Game.Quiz;
public class print {
	
	public static void main(String[] args) {
		Questions questions = new Questions();
		String[] secondQuestions = questions.getquestions();
		char[] secondAnswer = questions.getanswer();
		int secondAnswer_2 = secondAnswer.length;
		int secondQuestions_2 = secondQuestions.length;
		System.out.println(secondQuestions_2);
		System.out.print(secondAnswer_2);
	}

}
