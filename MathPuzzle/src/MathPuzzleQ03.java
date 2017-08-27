import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathPuzzleQ03 {

	public static void main(String[] args) {
		Boolean[] cardList = Stream.generate(() -> Boolean.FALSE).limit(100).toArray(Boolean[]::new);

		Boolean[] revers = null;
		for (int i = 2; i <= 100; i++) {

			revers = MathPuzzleQ03.reverse(cardList, i);

			cardList = revers;

		}

		for (int j = 0; j < revers.length; j++) {
			if (!revers[j]) {
				System.out.println((j + 1) + ",");
			}
		}

	}

	private static Boolean[] reverse(Boolean[] cardList, int startIndex) {

		Boolean[] result = cardList.clone();

		int skip = startIndex;

		IntStream.range(startIndex - 1, cardList.length).filter(index -> (index + 1) % skip == 0)
				.forEach(index -> result[index] = !cardList[index]);

		return result;
	}
}
