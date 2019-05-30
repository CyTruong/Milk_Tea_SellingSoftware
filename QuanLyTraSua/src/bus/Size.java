package bus;

public class Size {
	public static final int S = 1;
	public static final int M = 2;
	public static final int L = 3;

	public static String getSize(int size) {
		switch (size) {
		case 1:
			return "S";
		case 2:
			return "M";
		case 3:
			return "L";
		default:
			return "S";
		}
	}
}
