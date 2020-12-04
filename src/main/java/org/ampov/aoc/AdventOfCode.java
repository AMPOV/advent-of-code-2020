package org.ampov.aoc;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import org.ampov.aoc.puzzle.AbstractPuzzle;
import org.ampov.aoc.puzzle.Puzzle1;
import org.ampov.aoc.puzzle.Puzzle2;
import org.ampov.aoc.puzzle.Puzzle3;
import org.ampov.aoc.puzzle.Puzzle4;

public class AdventOfCode {
	
	public static void main(String[] args) {
		new AdventOfCode().printSolutions();
	}
	
	private Set<AbstractPuzzle> puzzles = new LinkedHashSet<>(LocalDate.now().getDayOfMonth());
	
	public AdventOfCode() {
		puzzles.add(new Puzzle1());
		puzzles.add(new Puzzle2());
		puzzles.add(new Puzzle3());
		puzzles.add(new Puzzle4());
	}
	
	private void printSolutions() {
		puzzles
			.stream()
			.forEach(System.out::println);
	}
}
