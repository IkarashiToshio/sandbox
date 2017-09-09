import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathPuzzleQ12 {

	public static void main(String[] args) {
		Optional<Integer> first = Stream.iterate(2, i -> i + 1).sequential().filter(val -> {
			String[] sqrtStrArray = MathPuzzleQ12.sqrt(new BigDecimal(val)).toString().split("");
			OptionalInt min = MathPuzzleQ12.mintDigitToAllNumber(sqrtStrArray);
			return min.orElse(11) == 10;
		}).findFirst();
		System.out.println("整数部を含む：" + first);

		first = Stream.iterate(2, i -> i + 1).sequential().filter(val -> {
			String sqrt = MathPuzzleQ12.sqrt(new BigDecimal(val)).toString();
			String[] sqrtStrArray = sqrt.substring(sqrt.indexOf(".")).split("");
			OptionalInt min = MathPuzzleQ12.mintDigitToAllNumber(sqrtStrArray);
			return min.orElse(11) == 10;
		}).findFirst();
		System.out.println("整数部を含まない：" + first);


	}

	private static OptionalInt mintDigitToAllNumber(String[] sqrtStrArray) {
		Set<String> num = new HashSet<>();
		OptionalInt min = IntStream.range(0, sqrtStrArray.length)
				.filter(index -> MathPuzzleQ12.isNumber(sqrtStrArray[index]))
				.peek(index -> num.add(sqrtStrArray[index])).filter(value -> num.size() == 10).min();

		return min;

	}

	private static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}

	/**
	 * 精度が足りないかもしれないので自前で平方根を計算
	 *
	 * @param a
	 * @return
	 */
	private static BigDecimal sqrt(BigDecimal a) {

		int scale = 50;

		// とりあえずdoubleのsqrtを求める
		BigDecimal x = new BigDecimal(Math.sqrt(a.doubleValue()), MathContext.DECIMAL64);
		if (scale < 17)
			return x;

		BigDecimal b2 = new BigDecimal(2);
		for (int tempScale = 16; tempScale < scale; tempScale *= 2) {
			// x = x - (x * x - a) / (2 * x);
			x = x.subtract(x.multiply(x).subtract(a).divide(x.multiply(b2), scale, BigDecimal.ROUND_HALF_EVEN));
		}
		return x;
	}
}
