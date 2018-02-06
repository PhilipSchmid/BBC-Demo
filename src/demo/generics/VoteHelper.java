package demo.generics;

public class VoteHelper {

	/**
	 * Prüft ob es eine Mehrheit unter den eingegeben Werten gibt.
	 * @param Value 1
	 * @param Value 2
	 * @param Value 3
	 * @return Mehrheit der hineingegebenen Werte 
	 * @return Null falls es keine Mehrheit gibt
	 */
	public static <T> T majority(T x, T y, T z) {
		if (x.equals(y)) {
			return x;
		}
		if (x.equals(z)) {
			return x;
		}
		if (y.equals(z)) {
			return y;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(VoteHelper.majority(11, 22, 11));
	}
}
