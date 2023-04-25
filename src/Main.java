public class Main {
    public static void main(String[] args) {
        int[] prices = { 13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30 };

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > money) {
                return prices.length - i; // сколько осталось товаров
            }
        }
        return 0; // если не нашли ни одного товара дороже
    }

}