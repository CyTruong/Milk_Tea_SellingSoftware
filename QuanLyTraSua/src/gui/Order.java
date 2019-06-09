package gui;

import java.util.ArrayList;

import bus.DoUongBus;
import dto.Douongdto;
import dto.ToppingDto;

public class Order extends Douongdto {
	public ArrayList<ToppingDto> arrTopping;
	public int Size = 1;
	public int Giatien = 0;

	public Order(Douongdto dto, int size) {
		super(dto);
		arrTopping = new ArrayList<>();
		this.Size = size;
		/*new Thread() {
			public void run() {
				Giatien = DoUongBus.getInstance().getGiatien(size, madouong);
			}
		}.start();*/
		Giatien = DoUongBus.getInstance().getGiatien(size, madouong);

	}

	public void setOrder(Douongdto dto) {

	}
}