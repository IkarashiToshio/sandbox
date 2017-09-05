import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathPuzzleQ08 {

	private static List<Point> MOVE = Arrays.asList(
			new Point(0,1)
			, new Point(0, -1)
			, new Point(1,0)
			, new Point(-1, 0)
			);

	public static void main(String[] args) {
		System.out.println(MathPuzzleQ08.move(12, Arrays.asList(new Point(0, 0))));
	}

	private static Integer move(int cnt,List<Point> moveLog) {
		if(moveLog.size() == cnt + 1) {
			return 1;
		}

		int sum = MOVE.stream().map(move -> {
			Point last = moveLog.get(moveLog.size() -1);
			return new Point(last.x + move.x, last.y + move.y);
		}).mapToInt(point -> {
			if(moveLog.indexOf(point) < 0) {
				List<Point> log = new ArrayList<>(moveLog);
				log.add(point);
				return MathPuzzleQ08.move(cnt, log);
			} else {
				return Integer.valueOf(0);
			}
		}).sum();
		return sum;
	}

}
