import java.util.stream.IntStream;

public class MathPuzzleQ06 {

	public static void main(String[] args) {


		long count = IntStream.range(1, 10000).filter(value -> value % 2 == 0).mapToObj(value -> MathPuzzleQ06.coratz(value, value * 3 + 1)).filter(value -> value).count();
		System.out.println(count);

	}


	private static boolean coratz(int first, int target) {

		if(target == first) {
			return true;
		} else if(target == 1) {
			return false;
		}


		if(target % 2 == 0) {
			return MathPuzzleQ06.coratz(first, target / 2);
		} else {
			return MathPuzzleQ06.coratz(first, target * 3 + 1);
		}
	}

}
