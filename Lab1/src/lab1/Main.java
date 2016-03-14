package lab1;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		// 解析订单字符串
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) {
			disArr[j] = args[j].toLowerCase();
		}
		
		Beverage order;

		
		if(disArr[0].charAt(0) <= '9' && disArr[0].charAt(0) >= '0')
		// The first argument is a number, indicating a multiple order
		{
			BeverageProducerMulti p = new BeverageProducerMulti();
			DecimalFormat df = new DecimalFormat(".0");
			System.out.println("The total cost of your order is: "
					+ df.format(p.produceMulti(disArr) ) );
		}
		else // old input
		{
			BeverageProducer p = new BeverageProducer();
			order = p.produce(disArr);

			/**
			 * How do I get the description of each order instead of doing this
			 * stupid thing forever (except for printing the args)?
			 */
			if (order instanceof BeverageWithIngredient) {
				((BeverageWithIngredient) order).getDescription();
			} else if (order instanceof Espresso) {
				((Espresso) order).getDescription();
			}
			// and so on...

			DecimalFormat df = new DecimalFormat(".0");
			System.out.println("The total cost of your order is: "
					+ df.format(order.cost()));
		}
	}
}