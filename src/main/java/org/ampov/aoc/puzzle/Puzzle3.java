package org.ampov.aoc.puzzle;

import java.util.List;

public class Puzzle3 extends AbstractPuzzle {

	private List<String> input = inputFile.getLines();

	public Puzzle3() {
		long trees = new Route(3, 1).trees;
		
		solutionPart1 = trees;
		solutionPart2 = trees *
				new Route(1, 1).trees *
				new Route(5, 1).trees *
				new Route(7, 1).trees *
				new Route(1, 2).trees;
	}

	class Route {

		private long trees = 0;
		private int positionX = 0;
		private int positionY = 0;

		private Route(int deltaX, int deltaY) {
			try {
				for (int i = 0; i < input.size(); i++) 
					if (isTree(deltaX, deltaY))
						trees++;
			} catch (IndexOutOfBoundsException e) {}
		}

		private boolean isTree(int deltaX, int deltaY) {
			positionX += deltaX;
			positionY += deltaY;
			char[] line = input.get(positionY).toCharArray();
			return line[positionX % line.length] == '#';
		}
	}
}
