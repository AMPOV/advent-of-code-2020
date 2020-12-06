package org.ampov.aoc;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import org.ampov.aoc.puzzle.AbstractPuzzle;
import org.ampov.aoc.puzzle.Puzzle1;
import org.ampov.aoc.puzzle.Puzzle2;
import org.ampov.aoc.puzzle.Puzzle3;
import org.ampov.aoc.puzzle.Puzzle4;
import org.ampov.aoc.puzzle.Puzzle5;
import org.ampov.aoc.puzzle.Puzzle6;

public class AdventOfCode {

	public static void main(String[] args) {
		new AdventOfCode().printSolutions();
	}

	private Set<AbstractPuzzle> puzzles = new LinkedHashSet<>(LocalDate.now().getDayOfMonth());

	public AdventOfCode() {
		add(new Puzzle1());
		add(new Puzzle2());
		add(new Puzzle3());
		add(new Puzzle4());
		add(new Puzzle5());
		add(new Puzzle6());
	}

	private AdventOfCode add(AbstractPuzzle puzzle) {
		puzzles.add(puzzle);
		return this;
	}

	private void printSolutions() {
		puzzles.stream().forEach(System.out::println);
	}
}
