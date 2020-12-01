package org.ampov.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFile {
	
	private List<String> lines;

	public InputFile(String name) {
		lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(Day1.class.getClassLoader().getResourceAsStream(name)))) {
			String line;
			while ((line = br.readLine()) != null) 
				lines.add(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getLines() {
		return lines;
	}
	
	public List<Integer> getAsIntegers() {
		return lines
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
