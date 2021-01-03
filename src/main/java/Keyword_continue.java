
public class Keyword_continue {
	// break - terminate the loop
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				continue; // terminate the current iteration

			System.out.println(i);
		}
	}

	public String getName() {
		String s = "Anupam";
		return s;
	}
}
