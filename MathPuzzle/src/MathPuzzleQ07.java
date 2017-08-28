import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class MathPuzzleQ07 {

	private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

	public static void main(String[] args) {

		LocalDate start = LocalDate.parse("19641010", DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate end = LocalDate.parse("20200724", DateTimeFormatter.ofPattern("yyyyMMdd"));

		Stream.iterate(start, date -> date.plusDays(1)).limit(ChronoUnit.DAYS.between(start, end)).filter(MathPuzzleQ07::test).forEach(System.out::println);

	}

	public static boolean test(LocalDate date) {

		String str = date.format(MathPuzzleQ07.FORMAT);
		String befor = Integer.toBinaryString(Integer.valueOf(str));
		String after = new StringBuilder(befor).reverse().toString();

		return befor.equals(after);
	}

}
