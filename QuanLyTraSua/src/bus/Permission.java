package bus;

public class Permission {
	public static final int SALE_PERMISSION = 2;
	public static final int VIEW_REPORT_PERMISSION = 4;
	public static final int CHANGE_INFOMATION_PERMISSION = 8;
	public static final int FULL_PER = SALE_PERMISSION & VIEW_REPORT_PERMISSION & CHANGE_INFOMATION_PERMISSION;
}
