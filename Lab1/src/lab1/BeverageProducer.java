package lab1;

/**
 * Created by Joker on 3/11/16.
 */
public class BeverageProducer {
    // size names
    public static String[] size_label = {"small", "medium", "large", "grant"};

    public Beverage produce(String[] orderStr) {
        // Dissolve size data
        int i;
        OK_Size:
        for (i = 0; i < orderStr.length; i++)
            for (int j = 0; j < size_label.length; j++)
                if (size_label[j].equals(orderStr[i]))
                    break OK_Size;

        if (i >= orderStr.length) {
            System.out.println("Must set a size!");
            return null;
        }

        // Get the name of the beverage
        String beveStr;
        if (i == 2) {
            beveStr = orderStr[0] + " " + orderStr[1];
        } else {
            beveStr = orderStr[0];
        }

        // Generate Beverage
        Beverage order = null;
        boolean isCoffee = false;
        try {
            switch (beveStr) {
                // coffee
                case "espresso":
                    order = new Espresso();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    isCoffee = true;
                    break;
                case "houseblend":
                    order = new HouseBlend();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    isCoffee = true;
                    break;
                case "mocha":
                    order = new Espresso();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    order = new Chocolate(order);
                    isCoffee = true;
                    break;
                case "latte":
                    order = new Espresso();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    order = new Milk(order);
                    isCoffee = true;
                    break;
                case "cappuccino":
                    order = new Espresso();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    order = new WhipCream(order);
                    isCoffee = true;
                    break;
                case "decaf":
                    order = new Decaf();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    isCoffee = true;
                    break;
                
                // the new drink
                case "decaf mocha":
                    order = new Decaf();
                    ((CoffeeBeverage) order).setSize(orderStr[i]);
                    order = new Chocolate(order);
                    isCoffee = true;
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
                    return null;
            }
        } catch (ClassCastException e) {
            System.out.println("Recipe Error! Such combination can not be served.");
        }

        // add ingredient and judge if the ingredient matches the beverage
        boolean isMatch;
        for (i++; i < orderStr.length; i++) {
            switch (orderStr[i]) {
                case "chocolate":
                    order = new Chocolate(order);
                    isMatch = isCoffee;
                    break;
                case "ginger":
                    order = new Ginger(order);
                    isMatch = !isCoffee;
                    break;
                case "milk":
                    order = new Milk(order);
                    isMatch = true;
                    break;
                case "jasmine":
                    order = new Jasmine(order);
                    isMatch = !isCoffee;
                    break;
                case "whip":
                    i++;
                    order = new WhipCream(order);
                    isMatch = isCoffee;
                    break;
                default:
                    System.out.println("Illegal input: " + orderStr[i]);
                    return null;
            }
            if (!isMatch) {
                System.out.println("Illegal ingredient: " + orderStr[i] + " to " + (isCoffee ? "coffee." : "tea."));
                return null;
            }
        }

		System.out.println(order.getDescription());
        return order;
    }
}
