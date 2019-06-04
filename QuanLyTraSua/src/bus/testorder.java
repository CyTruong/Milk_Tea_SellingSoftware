package bus;

public class testorder {

	public static void main(String[] args) {
		HoadonBus.getInstance();

		PurchaseBus.getInstance().creatnewOrder();
		PurchaseBus.getInstance().Themmon(1, 1, "Trân châu đường đen");
		PurchaseBus.getInstance().Themmon(2, 1, "1 loại topping kì bí nào đó");
		PurchaseBus.getInstance().finnishOrder(1,0,"ko có mã", 500000);
	}

}
