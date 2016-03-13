package lab1;

public class BeverageProducerMulti {
	// size names
	public static String[] size_label = { "small", "medium", "large", "grant" };
	// beverage names
	public static String[] beverage_label = { "espresso", "houseblend",
			"mocha", "latte", "cappuccino", "green tea", "red tea",
			"white tea", "flower tea", "ginger tea", "tea latte", "decaf mocha" };

	public double produce(String[] orderStr) {
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

		// parse the multiple orders
		int orderNum;
		double totalCost = 0;
		i = 1; // start position of the string arguments
		for (orderNum = 1; orderNum <= orderCount; orderNum++) {
			i++;
			String beveStr;
			boolean flagSize = false; // check if size is found
			for (int j = 0; j < size_label.length; j++)
				if (size_label[j].equals(orderStr[i])) {
					flagSize = true;
					break;
				}
			if (flagSize == true)
				beveStr = orderStr[i - 1];
			else // not found, check if the beverage name is two-word
			{
				i++;
				for (int j = 0; j < size_label.length; j++)
					if (size_label[j].equals(orderStr[i])) {
						flagSize = true;
						break;
					}
				if (flagSize == true)
					beveStr = orderStr[i - 2] + " " + orderStr[i - 1];
				else {
					System.out.println("Must set a size!");
					return 0;
				}
			}

			Beverage order = null;
			try {
				switch (beveStr) {
				// coffee
				case "espresso":
					order = new Espresso();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					break;
				case "houseblend":
					order = new HouseBlend();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					break;
				case "mocha":
					order = new Espresso();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					order = new Chocolate(order);
					break;
				case "latte":
					order = new Espresso();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					order = new Milk(order);
					break;
				case "cappuccino":
					order = new Espresso();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					order = new WhipCream(order);
					break;

				// the new drink
				case "decaf mocha":
					order = new Decaf();
					((CoffeeBeverage) order).setSize(orderStr[i]);
					order = new Chocolate(order);
					break;

				// tea
				case "green tea":
					order = new GreenTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					break;
				case "red tea":
					order = new RedTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					break;
				case "white tea":
					order = new WhiteTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					break;
				case "flower tea":
					order = new GreenTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					order = new Jasmine(order);
					break;
				case "ginger tea":
					order = new GreenTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					order = new Ginger(order);
					break;
				case "tea latte":
					order = new RedTea();
					((TeaBeverage) order).setSize(orderStr[i]);
					order = new Milk(order);
					break;
				default:
					System.out.println("Illegal input: " + beveStr);
					return 0;
				}
			} catch (ClassCastException e) {
				System.out
						.println("Recipe Error! Such combination can not be served.");
			}

			// 生成配料
			for (i++; i < orderStr.length && !orderStr[i].equals(";"); i++) {
				try {
					switch (orderStr[i]) {
					case "chocolate":
						order = new Chocolate(order);
						break;
					case "ginger":
						order = new Ginger(order);
						break;
					case "milk":
						order = new Milk(order);
						break;
					case "jasmine":
						order = new Jasmine(order);
						break;
					case "whip":
						i++;
						order = new WhipCream(order);
						break;
					default:
						System.out.println("Illegal input: " + orderStr[i]);
					}
				} catch (ClassCastException e) {
					if (order instanceof CoffeeBeverage) {
						System.out.println(orderStr[i]
								+ " can`t be added into coffee.");
					} else if (order instanceof TeaBeverage) {
						System.out.println(orderStr[i]
								+ "can`t be added into tea.");
					}
				}
			}
			totalCost += order.cost();
			i++;
		}
		return totalCost;
	}
}
