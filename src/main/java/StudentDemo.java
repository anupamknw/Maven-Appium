import java.util.Date;
import java.util.Scanner;

//static  -    property of class
//non-static - property of instance
//this - current class's object reference

class Student {
	String name;
	String rollno;
	static String SCHOOL_NM;
	static boolean i;

	Student(int t) {
		System.out.println("Hi");
	}

	public Student(String name, String rollno) {
		this(34);
		this.name = name;
		this.rollno = rollno;
		this.getName();
	}

	String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Hello";
	}
}

public class StudentDemo {
	static int i = 10;

	public static void main(String[] args) {
		Student s = new Student("Hello", "rtyy");
		System.out.println(s);
		System.out.println(s.toString());

		Student s1 = new Student("Hi", "reg");
		System.out.println(s1);
		
		
		Date d=new Date();
		System.out.println(d);
		
		Scanner sc=new Scanner(System.in);
		
	}
}
