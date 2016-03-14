package lab1;

public class BeverageProducerMulti {
	public double produceMulti(String[] orderStr) {
		int orderCount = Integer.parseInt(orderStr[0]);
		int i, semiCount = 0; // numbers of semicolons

		// check if semicolons are input correctly
		for (i = 0; i < orderStr.length; i++)
			if (orderStr[i].equals(";"))
				semiCount++;
		if (semiCount != orderCount - 1) {
			System.out
					.println("Make sure to split the orders by ';' and input spaces before and after it to split");
			return 0;
		}

		// handle each order
		BeverageProducer bp = new BeverageProducer();
		Beverage temp_b;
		double totalCost = 0.0;
		int j = 1; // start from orderStr[1]
		for (; j < orderStr.length; j++) {
			// generate order string
			int s = j;
			while (j < orderStr.length && !orderStr[j].equals(";"))
				j++;
			String[] ith_order = new String[j-s];
			for (int t = s; t < j; t++)
				ith_order[t-s] = orderStr[t];
			temp_b = bp.produce(ith_order);
			totalCost += temp_b.cost();
		}

		return totalCost;
	}
}
