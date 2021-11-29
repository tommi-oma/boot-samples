package fi.digitalentconsulting.samples;

import org.springframework.stereotype.Component;
@Component
public class MyCounter {
	private int value;
	public int increment() {
		return ++value;
	} 
	public int decrement() {
		return --value;
	} 
	public int get() {
		return value;
	}
	public void set(int value) {
		this.value = value;
	}
}
