package org.ampov.aoc.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle4 extends AbstractPuzzle {

	private String input = inputFile.getContent();
	private List<String> required = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"); 
	private Map<String, Predicate<String>> predicateMap = getPredicates();

	public Puzzle4() {
		Pattern pattern = Pattern.compile("(\\w{3}):([^\\s]+)");
		int valid = 0;
		int validStrict = 0;
		String[] passports = input.split("\\n\\n");

		for (int i = 0; i < passports.length; i++) {
			Map<String, String> passport = new HashMap<>();
			Matcher matcher = pattern.matcher(passports[i]);
			int validFieldCount = 0;
			while (matcher.find()) {
				passport.put(matcher.group(1), matcher.group(2));
				try {
					if (predicateMap.get(matcher.group(1)).test(matcher.group(2)))	
						validFieldCount++;
				} catch (Exception e) {}
			}
			if (passport.keySet().containsAll(required)) {
				valid++;
				if (validFieldCount >= 7)
					validStrict++;
			}
		}
		solutionPart1 = valid;
		solutionPart2 = validStrict;
	}

	private Map<String, Predicate<String>> getPredicates() {
		Map<String, Predicate<String>> predicates = new HashMap<>();
		predicates.put("byr", v -> Integer.parseInt(v) >= 1920 && Integer.parseInt(v) <= 2002);
		predicates.put("iyr", v -> Integer.parseInt(v) >= 2010 && Integer.parseInt(v) <= 2020);
		predicates.put("eyr", v -> Integer.parseInt(v) >= 2020 && Integer.parseInt(v) <= 2030);
		predicates.put("hcl", v -> Pattern.compile("^#[a-f0-9]{6}$").matcher(v).find());
		predicates.put("ecl", v -> Arrays.asList("amb blu brn gry grn hzl oth".split(" ")).contains(v));
		predicates.put("pid", v -> Pattern.compile("^\\d{9}$").matcher(v).find());
		predicates.put("hgt", v -> {
			Matcher matcher = Pattern.compile("^(\\d+)(cm|in)$").matcher(v);
			matcher.find();
			int height = Integer.parseInt(matcher.group(1));
			String unit = matcher.group(2);
			if (unit.contentEquals("cm"))
				return height >= 150 && height <= 193;
			return height >= 59 && height <= 76;
		});
		return predicates;
	}
}
