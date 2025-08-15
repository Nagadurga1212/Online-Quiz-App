package com.app;

public class QuizQuestion {
	private String question;
	private String[] options;
	private int correctOption; // 1-based index

	public QuizQuestion(String question, String[] options, int correctOption) {
		this.question = question;
		this.options = options;
		this.correctOption = correctOption;
	}

	public void displayQuestion() {
		System.out.println(question);
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
	}

	public boolean isCorrect(int userChoice) {
		return userChoice == correctOption;
	}
}
