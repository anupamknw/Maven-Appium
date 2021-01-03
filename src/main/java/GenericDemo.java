
class XYZ<T> {
	private T x;

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}
	


}

public class GenericDemo {
	public static void main(String[] args) {
		XYZ<String> xyz = new XYZ<String>();
		xyz.setX("Hello");
		System.out.println(xyz.getX());

		XYZ<Integer> abc = new XYZ<Integer>();
		abc.setX(89);
		System.out.println(abc.getX());
	}
}
