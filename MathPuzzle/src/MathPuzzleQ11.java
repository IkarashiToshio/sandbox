import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MathPuzzleQ11 {

	public static void main(String[] args) {
		Stream.iterate(Arrays.asList(new BigDecimal(1)), (list) -> {
			List<BigDecimal> result = new ArrayList<>();

			BigDecimal sum = list.parallelStream().reduce(BigDecimal.ZERO, (pre, now) -> pre.add(now));

			if (sum.equals(BigDecimal.ONE)) {
				result.add(BigDecimal.ONE);
			} else {
				result.add(list.get(list.size() - 1));
			}

			result.add(sum);
			return result;
		}).map(list -> list.parallelStream().reduce(BigDecimal.ZERO, (pre, now) -> pre.add(now))).filter((value) -> {

			int sum = Arrays.asList(value.toString().split("")).parallelStream().mapToInt(Integer::valueOf).sum();

			return value.remainder(BigDecimal.valueOf(sum)).equals(BigDecimal.ZERO);
		}).limit(12).forEach(System.out::println);

	}

}
