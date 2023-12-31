package step.learning;

import com.google.inject.Guice;
import com.google.inject.Injector;
import step.learning.db.DbApp;
import step.learning.eventone.TicTacToe;
import step.learning.ioc.ConfigModule;
import step.learning.ioc.IocApp;
import step.learning.oop.Library;

public class App
{
    public static void main( String[] args )
    {
        //new Variables().demo();
        //new ArraysLoops().demo();
        //new Collections().demo();
        //new TicTacToe().main();
        //new Library().demo();
        Injector injector = Guice.createInjector(new ConfigModule());
        //injector.getInstance(IocApp.class).demo();
        injector.getInstance(DbApp.class).demo();
    }
}
/*
Встановлення
Win-R cmd (terminal)
> java -version
якщо працює, переходимо далі,
якщо помилка - встановлюємо JRE
Встановлюємо JDK
або) через скачаний файл
або) через інструмент "новий проєкт" в Idea
Новий проєкт
- (ліворуч) Maven Archetype
- назва проєкту Java-SPU-121
- JDK - вибираємо (або скачуємо) 1.8
- Archetype: quickstart
     org.apache.maven.archetypes:maven-archetype-quickstart
- Advanced Settings
  = GroupId: step.learning

Після створення проєкту налаштовуємо конфігурацію запуску
(за замовчанням - Current File)
Edit Configuration -- + -- Application -- назва: App, Main class -
 вибір - App
 */
/* Вступ
Java - мова програмування
 - тип: транслятор (з проміжним кодом)
    - платформа: JRE (Java Runtime Environment) [ JVM ]
    - засоби (компілятор): JDK (Development Kit)
        - вихідний код: *.java
         - проміжний код: *.class
 - покоління: 4GL
 - парадигма: ООП (+мультипарадигма)
Комплекти:
 Java SE (Standard Edition) - базовий набір - консоль, десктоп
 Java EE (Enterprise Edition) - SE + мережа ( ут.ч. веб)
Версії:
 1: 1.0 - 1.8 + підтримка ... 1.8.361 ...
 11+
 Особливості - у Java повна підтримка зворотної сумістності,
 будь-який код, написаний на попередніх версіях, має виконуватися
 на наступних
Системи збирання:
 Maven, Gradle, Ant -- структура папок проєкту, способи зазначення
 залежностей, тощо
Особливості:
 - залежність структури проєкту та файлової системи:
 - назва файлу має збігатися із назвою класу. що в ньому описаний
    = в одному файлі може бути тільки один клас (public)
    = один клас повністю визначається в одному файлі
    = для імен класів рекомендується CapitalCamelCase
    = для змінних та методів - lowerCamelCase
 - папка відповідає за пакет (package) ~ namespace
    = назва пакету має збігатися з назвою папки (та її структурою)
    = для просторів імен рекомендується snake_case
 */
