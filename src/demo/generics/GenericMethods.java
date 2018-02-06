package demo.generics;

public class GenericMethods {

	public static <T extends CharSequence> T random(T m, T n)
	{
		return Math.random() > 0.5 ? m : n;
	}

	public static void main(String[] args) {
		System.out.println(GenericMethods.random("Aufstehen", "Weiterschlafen"));
	}

}
