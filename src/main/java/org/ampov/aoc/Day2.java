package org.ampov.aoc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
	
	private final String FILE_NAME = this.getClass().getSimpleName() + ".txt";
	private List<String> input = new InputFile(FILE_NAME).getLines();
	
	public static void main(String[] args) {
		Day2 day2 = new Day2();
		long part1 = day2.countValid(new PasswordPolicy1());
		long part2 = day2.countValid(new PasswordPolicy2());
		System.out.println(part1);
		System.out.println(part2);
	}

	public long countValid(PasswordPolicy policy) {
		return input
				.stream()
				.filter(policy::validate)
				.count();
	}
}

interface PasswordPolicy {
	
	boolean validate(String record);
	
	Pattern PATTERN = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");

	default String[] getComponents(String policy) {
		Matcher matcher = PATTERN.matcher(policy);
		matcher.find();
		return new String[] {matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4)};
	}
	
	default long containsCount(String password, char c) {
		return password
				.chars()
				.filter(x -> x == c)
				.count();
	}
}

class PasswordPolicy1 implements PasswordPolicy {
	public boolean validate(String record) {
		String[] components = getComponents(record);
		int min = Integer.parseInt(components[0]);
		int max = Integer.parseInt(components[1]);
		char c = components[2].charAt(0);
		String password = components[3];
		long occurances = containsCount(password, c);
		return (occurances >= min && occurances <= max);
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