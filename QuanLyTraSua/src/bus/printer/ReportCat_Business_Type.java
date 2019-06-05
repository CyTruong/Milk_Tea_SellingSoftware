package bus.printer;

public class ReportCat_Business_Type {
	public static final int BY_DATE = 1;
	public static final int BY_MONTH = 2;
	public static final int BY_HAFT_MONTH = 4;
	public static final int BY_SEASON = 8;
	public static final int BY_FOUR_MONTH = 16;
	public static final int BY_YEAR = 32;
	public static final int FROM_TO = 64;
	
	public static String getTitle(int key) {
		switch (key) {
		case BY_DATE:
			return "Doanh thu ngày ";
		case BY_MONTH:
			return "Doanh thu tháng ";
		case BY_HAFT_MONTH :
			return "Doanh thu nửa tháng (bỏ) ";
		case BY_SEASON:
			return "Doanh thu mùa ";
		case BY_FOUR_MONTH:
			return "Doanh thu theo quý ";
		case BY_YEAR:
			return "Doanh thu theo năm ";
		default:
			return "???";
		}
	}
}