package lab1;

public class CoffeeBased implements SizeFactor {
	public static double[] size_price = {0.4, 0.7, 1, 1.3};

	@Override
	public double sizeCost(String size) {
		for (int i = 0; i < BeverageProducer.size_label.length; i++) {
			if (BeverageProducer.size_label[i].equals(size)) {
				return size_price[i];
			}
		}
		// 默认返回small的price
		return size_price[0];
	}

}
