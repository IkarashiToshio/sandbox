import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MathPuzzleQ10 {

	private static int[] EUROPEAN = { 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16,
			33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 };

	private static int[] AMERICAN = { 0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1, 0, 27, 10,
			25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2 };

	public static void main(String[] args) throws Exception {

		long count = IntStream.range(2, 37).filter(cnt -> MathPuzzleQ10.euMax(cnt) < MathPuzzleQ10.americaMax(cnt))
				.count();

		System.out.println(count);
	}

	private static int euMax(int cnt) {

		OptionalInt max = IntStream.range(0, MathPuzzleQ10.EUROPEAN.length).map(start -> {
			return IntStream.range(0, cnt).map(index -> start + index)
					.map(index -> MathPuzzleQ10.EUROPEAN[index % MathPuzzleQ10.EUROPEAN.length])
					.sum();
		}).max();

		return max.orElse(0);
	}

	private static int americaMax(int cnt) {

		OptionalInt max = IntStream.range(0, MathPuzzleQ10.AMERICAN.length).map(start -> {
			return IntStream.range(0, cnt).map(index -> start + index)
					.map(index -> MathPuzzleQ10.AMERICAN[index % MathPuzzleQ10.AMERICAN.length])
					.sum();
		}).max();

		return max.orElse(0);
	}

}
