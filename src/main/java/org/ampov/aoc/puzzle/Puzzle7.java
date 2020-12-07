package org.ampov.aoc.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle7 extends AbstractPuzzle {
	
	private static final Pattern bagPattern = Pattern.compile(".+?(?= bags)");
	private static final Pattern contentPattern = Pattern.compile("(?<=(contain|,) )(\\d) ((\\w|\\s)+)(?= bags?([.]|,))");
	private Map<String, Map<String, Integer>> ruleMap = new HashMap<>();
	
	public Puzzle7() {
		inputFile
			.getLines()
			.stream()
			.forEach(this::parseRule);
		
		solutionPart1 = ruleMap
				.keySet()
				.stream()
				.filter(bag -> bagContains(bag, "shiny gold"))
				.count();
		
		solutionPart2 = countAll("shiny gold");
	}
	
	private void parseRule(String definition){
		Matcher matcher = bagPattern.matcher(definition);
		matcher.find();
		String bag = matcher.group(0);
		Map<String, Integer> mustContain = new HashMap<>();
		contentPattern
			.matcher(definition)
			.results()
			.forEach(r -> mustContain.put(r.group(3), Integer.parseInt(r.group(2))));
		ruleMap.put(bag, mustContain);
	}
	
	private boolean bagContains(String container, String contains) {
		if (ruleMap.get(container).containsKey(contains)) 
			return true;
		for (String bag : ruleMap.get(container).keySet()) 
			if (bagContains(bag, contains))
				return true;
		return false;
	}
	
	private long countAll(String bag) {
		long count = 0L;
	    for (Map.Entry<String, Integer> e : ruleMap.get(bag).entrySet()) 
	    	count += e.getValue() + e.getValue() * countAll(e.getKey());
	    return count;
	}
}
