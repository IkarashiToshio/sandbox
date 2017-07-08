import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class SampleSubscriber<T> implements Subscriber<T> {

	private Subscription subscription;
	private final String name;

	public SampleSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void onComplete() {
		System.out.println(name + ": " + Thread.currentThread().getName() + ": Complete.");
	}

	@Override
	public void onError(Throwable arg0) {
	}

	@Override
	public void onNext(T item) {
		// 配布されたデータを出力する
		System.out.println(name + ": " + Thread.currentThread().getName() + ": " + item);

		// データの要求
		subscription.request(1);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;

		subscription.request(1);
	}

}
