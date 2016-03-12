package lab1;

/**
 * Created by Joker on 3/11/16.
 */
public class BeverageProducer {
    // 提供size名字的信息
    public static String[] size_label = {"small", "medium", "large", "grant"};
    // 提供beverage名字信息
    public static String[] beverage_label = {
            "espresso", "houseblend", "mocha", "latte", "cappuccino", "green tea", "red tea",
            "white tea", "flower tea", "ginger tea", "tea latte"
    };

    public Beverage produce(String[] orderStr) {
        // 解析size数据
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

        // 解析饮料名
        String beveStr;
        if (i == 2) {
            beveStr = orderStr[0] + " " + orderStr[1];
        } else {
            beveStr = orderStr[0];
        }

        // 生成饮料
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

        // 生成配料
        for (i++; i < orderStr.length; i++) {
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
                    System.out.println(orderStr[i] + " can`t be added into coffee.");
                } else if (order instanceof TeaBeverage) {
                    System.out.println(orderStr[i] + "can`t be added into tea.");
                }
            }
        }

        return order;
    }
}
