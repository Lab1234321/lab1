package lab1;

public class TeaBased implements SizeFactor {
	public static double[] size_price = {0.2, 0.5, 0.7, 0.9};

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
