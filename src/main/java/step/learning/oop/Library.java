package step.learning.oop;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Literature> funds;

    private void fallFunds() {
        funds = new ArrayList<>();

        Book book = new Book();
        book.setAuthor("D. Knuth");
        book.setTitle("Art of Programming");
        funds.add(book);

        Newspaper newspaper = new Newspaper();
        newspaper.setTitle("Daily Telegraph");
        try {
            newspaper.setDate("2023-08-19");
        }
        catch (ParseException e) {
            System.out.println("Invalid date");
        }
        funds.add(newspaper);

        Journal journal = new Journal();
        journal.setTitle("Forbes");
        journal.setNumber(113);
        funds.add(journal);

        Booklet booklet = new Booklet();
        booklet.setTitle("ЧАС ДО ШКОЛИ 2023");
        booklet.setTypography("типографія \"Артіль\"");
        funds.add(booklet);

        Poster poster = new Poster();
        poster.setTitle("Коли дощить - шукай веселку");
        poster.setColor(true);
        funds.add(poster);
    }

    /**
     * Виводить тільки періодичні видання
     */
    private void showPeriodic() {
        for (Literature literature : funds) {
            if (literature instanceof Periodic) {
                System.out.print(literature.getCard());
                System.out.println(" | Comes " + ((Periodic) literature).getPeriod());
            }
        }
    }
    private void showNonPeriodic() {
        for (Literature literature : funds) {
            if (! (literature instanceof Periodic)) {
                System.out.print(literature.getCard());
                System.out.println();
            }
        }
    }
    private void showCopyable() {
        for (Literature literature : funds) {
            if (literature instanceof Copyable) {
                System.out.print(literature.getCard());
                System.out.println(" | " + ((Copyable) literature).getCopyable());
            }
        }
    }
    private void showNonCopyable() {
        for (Literature literature : funds) {
            if (! (literature instanceof Copyable)) {
                System.out.print(literature.getCard());
                System.out.println();
            }
        }
    }
    public void demo() {
        System.out.println("---------- Library ----------");
        fallFunds();
        for (Literature literature : funds) {
            System.out.println(literature.getCard());
        }
        System.out.println("\n---------- PERIODIC ----------");
        showPeriodic();
        System.out.println("\n---------- NON PERIODIC ----------");
        showNonPeriodic();
        System.out.println("\n---------- COPYABLE ----------");
        showCopyable();
        System.out.println("\n---------- NON COPYABLE ----------");
        showNonCopyable();
    }
}
/*
Завдання:
Реалізувати метод showNonPeriodic(), який виводить тільки неперіодичні видання.

Створити інтерфейс-маркер Copyable ( чи можна скопіювати на ксерографі)
    можна копіювати книги та журнали, газети завеликі і не копіюються
Реалізвати методи showCopyable() nf showNonCopyable()

Додати декілька нових типів літератури:
    Буклети (назва, видавець(типографія)) - неперіодичний, копійований
    Постер (назва, кольоровість(boolean)) - неперіодичний, некопійований
    Створити декілька об'єктів, додати до фондів, переконатись у роботі
 */
/*
Бібліотека: є фонди, які містять різну літературу - книги, газети. журнали, тощо.
Є спільні риси - картка для каталога - вона існує для будь-якої лутератури
Є відмінні риси - у книги є автор(и). у газет - дата виходу, у журналів - номер
--------------------------
Предметна галузь: книги, газети, журнали
    створюємо об'єкти: Book{Author, Title}, Newspaper{Data, Title}, Journal{Number, Tittle}
    абстрагування: виділення структурно-ієрархічних "вузлів", які призначені для
        групування (поліморфізму) та спрощення (відокремлення спільних даних)
                            Literature{Title}
                          /         |         \
               Book{Author}  Newspaper{Data}  Journal{Number}
    спільна та індивідуальна функціональність
        потрібний засіб (метод, властивість) для формування картки (каталогу)
        Literature{Title, getCard()}
        на рівні класу Literature метод getCard() не має сенсу реалізовувати. тому
            він залишається абстрактним. Значить кожен з об'єктів має надати свою реалізацію
 */
/*
ООП - об'єктно-орієнтована парадигма програмування
Для того щоб опанувати ООП у новій мові прграмування слід розглянути:
- оголошення класів. різновиди. (чи є інтерфейси. enum, тощо)
- конструктори та створення об'єктів
- спадкування та реалізація
- поліморфізм - сумісність типів даних
- перетворення типів
 */
/*
Імперативна ~олгоритмічна  -повне управління виконавцем (процесором)
    поняття: шнструкція (її номер/адреса. перехід до іншої інструкції)
    відгалуження: процедурний підхід, структурне прграмування
    мови: машинний код. ассемблери, С/С++, Basic, Fortra...
Декларативна - встановлення певних правил, відношень, аксіом та перевірка
        на базі них різних тверджень
    поняття: домен, clause, бектрекінг
    відгалуження: логічна парадигма
    мова: Prolog
ООП - програма подається як об'єкти та їх взаємодія
    поняття: інкапсуляція, поліморфизм, наслідування (спадкування)
    відгалуження:прототипне програмування (JS)
    мови: C#, Java

Функціональна - послідовне виконання функцій над вхідними даними до досягнення
        потрібної мети.
    поняття: лямбда (функція), кортеж, голова-хвіст
    відгалуження: чисті парадигми
    мови: LISP, Python, J, Haskell
 */
