public class Batch {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Integer target = 11;
		while (true) {

			if (target.toString().equals(Batch.reverse(target).toString())
					&& Integer.toBinaryString(target).toString().equals(Batch.reverse(Integer.toBinaryString(target)))
					&& Integer.toOctalString(target).toString().equals(Batch.reverse(Integer.toOctalString(target)))) {
				break;
			}
			target += 2;
		}

		System.out.println("10進数：" + target);
		System.out.println(" 2進数：" + Integer.toBinaryString(target));
		System.out.println(" 8進数：" + Integer.toOctalString(target));
	}


	private static Integer reverse(Integer target) {

		String str = new StringBuilder(target.toString()).reverse().toString();

		return Integer.parseInt(str);

	}

	private static String reverse(String target) {
		return new StringBuilder(target).reverse().toString();
	}
}
