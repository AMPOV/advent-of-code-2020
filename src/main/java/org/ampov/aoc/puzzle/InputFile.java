package org.ampov.aoc.puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFile {
	
	private List<String> lines;
	private String content;

	public InputFile(String name) {
		StringBuilder sb = new StringBuilder();
		lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(InputFile.class.getClassLoader().getResourceAsStream(name)))) {
			String line;
			
			while ((line = br.readLine()) != null) {
				lines.add(line);
				sb.append(line);
			}
			content = Files.readString(Paths.get("src/main/resources/", name));
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

	public String getContent() {
		return content;
	}

	public void print() {
		lines
			.stream()
			.forEach(System.out::println);
	}
}
