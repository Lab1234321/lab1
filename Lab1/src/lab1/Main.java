package lab1;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No order detected. Thank you for coming!");
			return ;
		}

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

			DecimalFormat df = new DecimalFormat(".0");
			System.out.println("The total cost of your order is: "
					+ df.format(order.cost()));
		}
	}
}