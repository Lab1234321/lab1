package lab1;

/**
 * Created by Joker on 3/11/16.
 */
public class BeverageProducer {
    // 提供size名字的信息
    public static String[] size_label = {"small", "medium", "large", "grant"};

    public Beverage produce(String[] orderStr) {
        // 解析size数据
        int i;
        for (i = 0; i < orderStr.length; i++)
            if (orderStr[i].equals("small") || orderStr[i].equals("medium")
                    || orderStr[i].equals("large"))
                break;

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
        Beverage order;
        if (beveStr.equals("espresso")) {
            order = new Espresso();
            ((CoffeeBeverage) order).setSize(orderStr[i]);
        } else if (beveStr.equals("houseblend")) {
            order = new HouseBlend();
            ((CoffeeBeverage) order).setSize(orderStr[i]);
        } else if (beveStr.equals("mocha")) {
            order = new Espresso();
            ((CoffeeBeverage) order).setSize(orderStr[i]);
            order = new Chocolate(order);
        } else if (beveStr.equals("latte")) {
            order = new Espresso();
            ((CoffeeBeverage) order).setSize(orderStr[i]);
            order = new Milk(order);
        } else if (beveStr.equals("cappuccino")) {
            order = new Espresso();
            ((CoffeeBeverage) order).setSize(orderStr[i]);
            order = new WhipCream(order);
        } else if (beveStr.equals("green tea")) {
            order = new GreenTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
        } else if (beveStr.equals("red tea")) {
            order = new RedTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
        } else if (beveStr.equals("white tea")) {
            order = new WhiteTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
        } else if (beveStr.equals("flower tea")) {
            order = new GreenTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
            order = new Jasmine(order);
        } else if (beveStr.equals("ginger tea")) {
            order = new GreenTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
            order = new Ginger(order);
        } else if (beveStr.equals("tea latte")) {
            order = new RedTea();
            ((TeaBeverage) order).setSize(orderStr[i]);
            order = new Milk(order);
        } else {
            System.out.println("Illegal input: " + beveStr);
            return null;
        }

        // 生成配料
        for (i++; i < orderStr.length; i++) {
            if (orderStr[i].equals("chocolate")) {
                order = new Chocolate(order);
            } else if (orderStr[i].equals("ginger")) {
                order = new Ginger(order);
            } else if (orderStr[i].equals("milk")) {
                order = new Milk(order);
            } else if (orderStr[i].equals("jasmine")) {
                order = new Jasmine(order);
            } else if (orderStr[i].equals("whip")) {
                i++;
                order = new WhipCream(order);
            } else {
                System.out.println("Illegal input: " + orderStr[i]);
            }
        }

        return order;
    }
}
