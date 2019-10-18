package harsh.rane.Exception;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ErrorHandler;

public class MyErrorHandler implements ErrorHandler{

	@Override
	public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
		
		System.out.println("My Thrown Exception- "+thrownException);
		if (data != null)
		{
			System.out.println("My failed Data "+data);
		}
	}

}
