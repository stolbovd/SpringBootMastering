package ru.inkontext.exercise;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
public class Subject {
	private String name;
	private List<Exerciseable> exercises;

	public List<Exerciseable> getRandomExercise(Integer count) {
		List<Exerciseable> copy = new LinkedList<Exerciseable>(exercises);
		Collections.shuffle(copy);
		return copy.subList(0, count);
	}

}
