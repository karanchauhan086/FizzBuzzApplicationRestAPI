package com.roche.hackathon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class FizzBuzzController {

	private final Map<FizzBuzzRequest, Integer> stats = new HashMap<>();

	@GetMapping("/fizzbuzz")
	public List<String> fizzBuzz(@RequestParam(defaultValue = "3") int int1, @RequestParam(defaultValue = "5") int int2,
			@RequestParam(defaultValue = "100") int limit, @RequestParam(defaultValue = "fizz") String str1,
			@RequestParam(defaultValue = "buzz") String str2) {

		List<String> result = fizzBuzzLogic(int1, int2, limit, str1, str2);

		// Update statistics
		FizzBuzzRequest request = new FizzBuzzRequest(int1, int2, limit, str1, str2);
		stats.put(request, stats.getOrDefault(request, 0) + 1);

		return result;
	}

	@GetMapping("/statistics")
	public Map<String, Object> statistics() {
		Map.Entry<FizzBuzzRequest, Integer> mostCommon = stats.entrySet().stream().max(Map.Entry.comparingByValue())
				.orElse(null);

		Map<String, Object> response = new HashMap<>();
		if (mostCommon != null) {
			response.put("most_used_request", mostCommon.getKey());
			response.put("hits", mostCommon.getValue());
		}

		return response;
	}

	private List<String> fizzBuzzLogic(int int1, int int2, int limit, String str1, String str2) {
		return IntStream.rangeClosed(1, limit).mapToObj(i -> {
			StringBuilder entry = new StringBuilder();
			if (i % int1 == 0)
				entry.append(str1);
			if (i % int2 == 0)
				entry.append(str2);
			return entry.length() == 0 ? String.valueOf(i) : entry.toString();
		}).collect(Collectors.toList());
	}

}