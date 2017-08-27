
public class MathPuzzleQ04 {

	public static void main(String[] args) {

		System.out.println(MathPuzzleQ04.cut(20, 3, 1));
		System.out.println(MathPuzzleQ04.cut(100, 5, 1));

	}

	private static int cut(int len, int persons, int current) {

		if (len <= current) {
			return 0;
		} else if (current < persons) {
			return MathPuzzleQ04.cut(len, persons, current * 2) + 1;
		} else {
			return MathPuzzleQ04.cut(len, persons, current + persons) + 1;
		}
	}
}
