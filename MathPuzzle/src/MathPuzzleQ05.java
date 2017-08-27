import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MathPuzzleQ05 {

	private static List<List<Integer>> pattern = new ArrayList<>();

	public static void main(String[] args) {
		MathPuzzleQ05.takeChange(1000, new int[] { 500, 100, 50, 10 }, 15, null);

		System.out.println(pattern);
		System.out.println(pattern.size() + "通り");
	}

	private static void takeChange(int money, int[] coins, int limit, List<Integer> list) {

		if (list == null) {
			Arrays.stream(coins).forEach(value -> {
				List<Integer> l = new ArrayList<>();
				l.add(value);
				MathPuzzleQ05.takeChange(money,coins, limit, l);
			});
			return;
		}

		if(limit < list.size() || money < list.stream().mapToInt(value -> value).sum()) {
			return;
		}

		int sum = list.stream().mapToInt(value -> value).sum();
		if (sum < money) {
			Arrays.stream(coins).forEach(value -> {
				List<Integer> l = new ArrayList<>(list);

				if(money < sum + value) {
					return;
				}

				l.add(value);
				MathPuzzleQ05.takeChange(money, coins, limit, l);
			});
			return;
		}

		if (money == sum) {
			// 正解パターン
			List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());

			if (MathPuzzleQ05.pattern.indexOf(sorted) < 0) {
				System.out.println(MathPuzzleQ05.pattern);
				MathPuzzleQ05.pattern.add(sorted);
			}
		}
	}
}
