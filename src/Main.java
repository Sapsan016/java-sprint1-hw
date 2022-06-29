import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput;

        while (!scanner.hasNextInt()) {         //Проверяем, что вводится число;
            System.out.println("Пожалуйста,введите номер команды");
            scanner.next();

        }
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker();
        userInput = scanner.nextInt();
        while (userInput != 4) {
            // обработка разных случаев
            if (userInput == 1) {
                int month;

                System.out.println("Введите номер месяца (от 0 до 11)");
                while (!scanner.hasNextInt()) {         //Проверяем, что вводится число;
                    System.out.println("Это не число! Введите число");
                    scanner.next();
                }
                month = scanner.nextInt();

                while (month < 0 || month >= 12) {
                    System.out.println("Некорректные данные, введите номер месяца (от 0 до 11)");
                    month = scanner.nextInt();
                }

                int day;
                System.out.println("Введите номер дня (от 0 до 29)");
                while (!scanner.hasNextInt()) {      //Проверяем, что вводится число;
                    System.out.println("Это не число! Введите число");
                    scanner.next();
                }

                day = scanner.nextInt();

                while (day < 0 || day >= 29) {          // Проверяем,что число от 0 до 29;
                    System.out.println("Некорректные данные, введите номер дня (от 0 до 29)");
                    day = scanner.nextInt();
                }

                int steps;
                System.out.println("Введите количество шагов");
                while (!scanner.hasNextInt()) { // Проверяем, что вводится число;
                    System.out.println("Это не число! Введите число");
                    scanner.next();
                }
                steps = scanner.nextInt();

                while (steps < 0) {             // Проверяем, что число не отрицательное;
                    System.out.println("Некорректные данные, число шагов не может быть меньше 0");
                    steps = scanner.nextInt();
                }

                StepTracker.monthToData[month].days[day] = steps;
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца за который вы хотите посмотреть статистику (от 0 до 11)");
                while (!scanner.hasNextInt()) {         //Проверяем, что вводится число;
                    System.out.println("Это не число! Введите номер месяца (от 0 до 11) ");
                    scanner.next();
                }

                int month = scanner.nextInt();
                while (month < 0 || month >= 12) {
                    System.out.println("Некорректные данные, введите номер месяца (от 0 до 11)");
                    month = scanner.nextInt();
                }
                for (int i = 0; i < 30; i++)
                    System.out.println((i + 1) + " день " + +StepTracker.monthToData[month].days[i]);  //Печать кол-ва шагов;

                System.out.println("Общее количество шагов за месяц: " + StepTracker.monthToData[month].findSum(month));
                System.out.println("Наибольшее количество шагов за месяц: " + StepTracker.monthToData[month].findMaxSteps(month));
                System.out.println("Среднее количество шагов за месяц: " + (StepTracker.monthToData[month].findSum(month)) / 30);
                System.out.println("Пройдено километров за месяц: " + converter.convertStepsKM(StepTracker.monthToData[month].findSum(month)));
                System.out.println("Сожжено килокалорий за месяц: " + converter.convertStepsCalories(StepTracker.monthToData[month].findSum(month)));
                StepTracker.monthToData[month].findBestSeries(month);                //Вызов метода для поиска лучшей серии;
            } else if (userInput == 3) {   //Вызов метода для смены целевого количества шагов;
                stepTracker.changeGoal();
            } else {
                System.out.println("Такой команды нет, пожалуйста, выберите один из предложенных вариантов.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия

            while (!scanner.hasNextInt()) {         //Проверяем, что вводится число;
                System.out.println("Пожалуйста,введите номер команды");
                scanner.next();
            }

            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Здравствуйте! Пожалуйста, введите номер команды.");
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Напечатать статистику за определённый месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выйти из приложения.");
    }

 }

