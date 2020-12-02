package org.ampov.aoc.puzzle;

public abstract class AbstractPuzzle {
	
	protected final String inputFileName = this.getClass().getSimpleName() + ".txt";
	protected final InputFile inputFile = new InputFile(inputFileName);
	protected Object solutionPart1;
	protected Object solutionPart2;
	
	@Override 
	public String toString() {
		return this.getClass().getSimpleName() + "[Part1: " + solutionPart1 + ", Part2: " + solutionPart2 + "]";
	}
}
