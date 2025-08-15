package com.app;

import java.util.*;

public class QuizApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Step 1: Create a List of questions
		List<QuizQuestion> quiz = new ArrayList<>();
		quiz.add(new QuizQuestion("Which language runs in a web browser?",
				new String[] { "Java", "C", "Python", "JavaScript" }, 4));
		quiz.add(new QuizQuestion("Which company developed Java?",
				new String[] { "Microsoft", "Sun Microsystems", "Apple", "Google" }, 2));
		quiz.add(new QuizQuestion("Which keyword is used to inherit a class in Java?",
				new String[] { "this", "extends", "implements", "inherits" }, 2));
		quiz.add(new QuizQuestion("What is the default value of a boolean in Java?",
				new String[] { "true", "false", "null", "0" }, 2));
		quiz.add(new QuizQuestion("Who is known as the father of computers?",
				new String[] { "Alan Turing", "Charles Babbage", "Tim Berners-Lee", "Steve Jobs" }, 2));
		quiz.add(new QuizQuestion("Which of these is not a Java primitive type?",
				new String[] { "int", "String", "float", "char" }, 2));
		quiz.add(new QuizQuestion("Which data structure uses FIFO (First In First Out)?",
				new String[] { "Stack", "Queue", "Array", "Tree" }, 2));
		quiz.add(new QuizQuestion("Which OOP principle allows using the same method name with different parameters?",
				new String[] { "Inheritance", "Polymorphism", "Encapsulation", "Abstraction" }, 2));
		quiz.add(new QuizQuestion("In Java, what is 'null'?",
				new String[] { "A keyword", "A class", "A variable", "An object" }, 1));
		quiz.add(new QuizQuestion("Which method is the entry point of any Java program?",
				new String[] { "start()", "run()", "main()", "execute()" }, 3));

		int score = 0;

		// Step 2: Ask each question and take answers
		System.out.println("===== Welcome to the Quiz =====");
		for (int i = 0; i < quiz.size(); i++) {
			QuizQuestion q = quiz.get(i);
			System.out.println("\nQuestion " + (i + 1) + ":");
			q.displayQuestion();

			System.out.print("Enter your answer (1-" + qOptionsLength(q) + "): ");
			int answer = sc.nextInt();

			if (q.isCorrect(answer)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Wrong!");
			}
		}

		// Step 3: Show final score
		System.out.println("\n===== Quiz Finished =====");
		System.out.println("Your score: " + score + " out of " + quiz.size());

		sc.close();
	}

	// Helper method to get number of options (avoids hardcoding 4)
	private static int qOptionsLength(QuizQuestion q) {
		try {
			java.lang.reflect.Field optionsField = QuizQuestion.class.getDeclaredField("options");
			optionsField.setAccessible(true);
			String[] options = (String[]) optionsField.get(q);
			return options.length;
		} catch (Exception e) {
			return 4;
		}
	}
}
