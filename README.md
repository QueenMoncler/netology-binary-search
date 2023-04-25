# Домашнее задание к занятию "Введение в алгоритмическую сложность. Бинпоиск"
## Цель задания
1. Реализовать первую алгоритмическую задачу
2. Применить идеи бинарного поиска в решении задачи

## Задание 
Вам надо написать алгоритм для сувенирного магазина. Вам известен его ассортимент в виде массива цен (названия товаров нам не важны). Массив отсортирован в порядке возрастания. Клиенты могут оформлять подарочные сертификаты на определённую сумму, ваша задача по сумме сертификата находить количество товаров, которые невозможно будет на него приобрести (т.е. количество товаров, цена которых выше сертификата).

Пример
Пусть массив цен выглядит следующим образом: [13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30].

Тогда ответы будут такие:

![](https://ic.wampi.ru/2023/04/25/tableTask.png)
### Заготовка кода
Используйте этот код в качестве заготовки кода вашего проекта. 
Менять код в main нельзя.

    public class Main {

    public static void main(String[] args) {
        int[] prices = { 13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30 };

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        // Ваш алгоритм
        }
    }
### Алгоритм
Первая мысль при решении задачи может быть следующая: использование прямого перебора для подсчёта количества товаров, цена которых выше денег на сертификате. Асимптотика такого алгоритма будет O(n).

    public static int countMore(int[] prices, int money) {
        int count = 0;
        for (int price : prices) {
            if (price > money) {
                count++;
            }
        }
        return count;
    }
Можно улучшить алгоритм, заметив, что массив цен уже отсортирован, и наткнувшись на первый недоступный по цене товар, мы можем быть уверены, что все оставшиеся также недоступны. Тогда алгоритм преобразуется вот так:

    public static int countMore(int[] prices, int money) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > money) {
                return prices.length - i; // сколько осталось товаров
            }
        }
        return 0; // если не нашли ни одного товара дороже
    }
Хоть этот алгоритм и будет работать быстрее, его асимптотика всё ещё будет линейной, а если по цене доступны почти все товары, то эффективность улучшения будет едва заметна.

Вам предлагается написать более эффективное решение - бинарный поиск. Нам достаточно уметь находить первый недоступный товар в массиве, ведь тогда мы сразу сможем найти количество недоступных товаров (как в последней версии алгоритма).

Найти это место можно бинарным поиском. Обратите внимание, что посмотрев на любой из товаров, мы можем сразу определить, в какую сторону (лево или право) нам следует продолжить поиск первого недоступного товара. А именно: если товар допустимый, то нужно искать влево, а если недопустимый, то искать вправо, если предыдущий к нему тоже недопустимый.

Реализуйте метод поиска, основанный на бинарном поиске (таким образом, имеющий O(log n) асимптотику):

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // все недоступны
        }

        if (prices[prices.length - 1] < money) {
            return 0; // все доступны
        }

        int left = 0;
        int right = prices.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            
            // Ваш код:
            // Если в middle первый недоступный товар, вернуть размер массива минус middle
            // Если в middle доступная книга, то искать нужно правее - left = middle + 1
            // Если в middle недоступная книга, то искать нужно левее - right = middle - 1
            
        }
        return 0; // иначе не скомпилится, джава сама не знает бинпоиск
    }