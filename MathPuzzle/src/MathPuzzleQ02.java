import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathPuzzleQ02 {

	private static String[] CALC = { "+", "-", "*", "/", "" };

	public static void main(String[] args) throws ScriptException {
		IntStream.range(1000, 10000).mapToObj(Integer::valueOf)
		.flatMap(intVar -> {
			return Stream.of(intVar)
				.flatMap(value -> MathPuzzleQ02.assembleCalculation(value.toString()).stream())
				.map(str -> MathPuzzleQ02.eval(str))
				.filter(opt -> opt.isPresent())
				.map(opt -> opt.get())
				.filter(value -> value.equals(MathPuzzleQ02.reverse(intVar)))
				;
		}).forEach(System.out::println);
	}

	private static String reverse(Integer target) {
		return new StringBuilder(target.toString()).reverse().toString();
	}

	private static Optional<String> eval(String str) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		try {
			String result = engine.eval(str).toString();
			if(result.equals("NaN")) {
				return Optional.empty();
			} else {
				return Optional.of(result);
			}
		} catch (ScriptException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	private static List<String> assembleCalculation(String target) {

		char[] strArray = target.toCharArray();

		List<String> list = Stream.of(CALC).parallel().map(calc -> strArray[0] + calc)
				.flatMap(str -> Stream.of(CALC).map(calc -> str + strArray[1] + calc))
				.flatMap(str -> Stream.of(CALC).map(calc -> str + strArray[2] + calc))
				.flatMap(str -> Stream.of(CALC).map(calc -> str + strArray[3])).sequential().distinct()
				.filter(str -> str.length() != 4) // 演算子のない文字列は除外する
				.collect(Collectors.toList());

		return list;
	}
}
