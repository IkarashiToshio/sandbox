import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Sample {

	public static void main(String[] args) {
		SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

		// Subscriberの生成と登録
		Subscriber<Integer> subscriber1 = new SampleSubscriber<>("Sub1");
		publisher.subscribe(subscriber1);

		Subscriber<Integer> subscriber2 = new SampleSubscriber<>("Sub2");
		publisher.subscribe(subscriber2);

		Subscriber<Integer> subscriber3 = new SampleSubscriber<>("Sub3");
		publisher.subscribe(subscriber3);

		// データの登録
		IntStream.range(0, 5).forEach(publisher::submit);

		// 非同期で処理が終わってしまうので、実行終了するまで一時的に待つ。
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		publisher.close();
	}

}
