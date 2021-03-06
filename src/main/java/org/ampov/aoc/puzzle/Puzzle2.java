package org.ampov.aoc.puzzle;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface PasswordPolicy {
	boolean validate(String record);
}

public class Puzzle2 extends AbstractPuzzle {
	
	private List<String> input = inputFile.getLines();
	private Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");
	
	public Puzzle2() {
		solutionPart1 = countValid(new PasswordPolicy1());
		solutionPart2 = countValid(new PasswordPolicy2());
	}

	private long countValid(PasswordPolicy policy) {
		return input
				.stream()
				.filter(policy::validate)
				.count();
	}
	
	private String[] getComponents(String record) {
		Matcher matcher = pattern.matcher(record);
		matcher.find();
		return new String[] {matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4)};
	}
	
	class PasswordPolicy1 implements PasswordPolicy {
		
		public boolean validate(String record) {
			String[] components = getComponents(record);
			int min = Integer.parseInt(components[0]);
			int max = Integer.parseInt(components[1]);
			char c = components[2].charAt(0);
			String password = components[3];
			long occurances = password
					.chars()
					.filter(x -> x == c)
					.count();
			return occurances >= min && occurances <= max;
		}
	}

	class PasswordPolicy2 implements PasswordPolicy {
		
		public boolean validate(String record) {
			String[] components = getComponents(record);
			int index1 = Integer.parseInt(components[0]) - 1;
			int index2 = Integer.parseInt(components[1]) - 1;
			char c = components[2].charAt(0);
			String password = components[3];
			return (password.charAt(index1) != c && password.charAt(index2) == c) ||
					(password.charAt(index1) == c && password.charAt(index2) != c);
		}
	}
}
