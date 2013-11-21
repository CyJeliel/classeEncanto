package br.com.classeencanto.transformer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ArrayTransformer {

	public Set<String> arrayToSet(String[] stringArray) {

		Set<String> strings = new HashSet<>();

		for (String string : stringArray) {

			strings.add(string);
		}

		return strings;
	}

}
