package step.learning.basics;

import java.util.*;

public class Collections {
    public void demo() {
        // listDemo();
        mapDemo();
    }
    private void mapDemo() {
        Map<String, String> headers;
        //headers = new LinkedHashMap<>();  // зі збереженням порядку додавання елементів
        headers = new HashMap<>();          // без збереженням порядку додавання елементів
        headers.put("Content-Type", "test/html");
        headers.put("Content-Length", "100500");
        headers.put("Connection", "close");
        headers.put("Host", "localhost");
        headers.put("Authorization", "basic admin:password");
        for (String key : headers.keySet()) {
            System.out.println(String.format(
                    " %s: %s",
                    key, headers.get(key)
            ));
        }
    }
    private void listDemo() {
        List<String> list1 =            // List - interface для колекцій-переліків
                new ArrayList<>();      // ArrayList - реалізація (з массивом)
        List<String> list2 =
                new LinkedList<>();     // Реалізація - з зв'язуванням
        list2.add("String 1");
        list2.add("String 2");
        list2.add("String 3");
        list2.add(2,"String 2.5");
        for (String str : list2) {
            System.out.println(str);
        }
        String[] arr = list2.toArray(new String[0]);
        // List<int> list3;     error -- Type argument cannot be of primitive type
        List<Integer> list3;    // OK
    }
}
/* Колекції
   Поділяються на переліки (list), множини (set) та асоціативні (map)
   ! Особливість Java у тому, що немає повного контролю Generic типів,
   тобто колекція сприймається як колекція<Object>
    - немає гарантії перетворення типу      (List<String>) json
        [насправді гарантується (List<?>)]
    - при перетворенні колекції у масив слді зазначати зразок його типу
        [ list2.toArray(new String[0]) ]
    - інтенсивна робота з колекціями не є бажаною, рекомендовано їх використовувати
        для прийому даних, після чого перевести дані у масив і вже з ним
        продовжувати активну роботу
    - ArrayList можна вважати певним компромісом, оскільки в еьому вживається масив,
        тобто після отримання всіх даних перетворення не є необхідним. але саме
        отримання даних може бути сповільнене. якщо в ньому багато операцій
        вставляння елементів (не у кінець масиву), вилучення елементів
 */
/*
    Д.З. Реалізувати гру "хрестики-нолики"
    Поле реалізувати у вигляді подвійного масиву
    Хід користувача приймати або (номером клітинки) координатами
        A   B   C
    1   X           X 2 3
    2       0       4 0 6
    3           X   7 8 X

    Ваш хід: B1     Ваш хід: 2

    Ускладнення: обирати розмір поля (три-в-ряд на полі більшго розміру)
    Вести статистику гри (всього, виграшівб програшів -- рахунок)
    Вибір опонента
    Складність гри (випадкові ходи ПК чи осмислені)
    Корольове оформлення
 */