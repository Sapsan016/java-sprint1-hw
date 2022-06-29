import java.util.Scanner;
public class StepTracker {

    int stepsGoal = 10000;     //Цель шагов по умолчанию;

    static MonthData[] monthToData; // Массив для хранения данных;

    public StepTracker() {                 //Конструктор для класса;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {

        int[] days = new int[30];    // Инициализация списка для дней;


        int findSum(int month) {           //Поиск суммарного количества шагов за месяц;
            int sum = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                sum = sum + days[i];   //Сложение шагов;
            }
            return sum;          //Возврат суммы;
        }

        int findMaxSteps(int month) {       // Поиск дня с наибольшим количеством шагов;

            int maxSteps = 0;     // Начальная переменная;
            for (int day : days) {
                if (day > maxSteps) {          // Сравнение количества шагов;
                    maxSteps = day;             // Присваивание нового значения;
                }
            }
            return maxSteps;                    //Возврат значения;
        }

        void findBestSeries(int month) {              // Поиск лучшей серии;

            int lengthBest = 0;         // Длина лучшей серии
            int lengthCurrent = 0;     // Длина текущей серии;

            for (int i = 0; i < monthToData[month].days.length; i++) {
                if (monthToData[month].days[i] >= stepsGoal) // Сравниваем кол-во шагов с целью;
                    lengthCurrent++;                        // Увеличиваем длину серии;

                if (i + 1 == monthToData[month].days.length || monthToData[month].days[i] < stepsGoal) {
                                                            // При достижении конца списка или кол-ва шагов меньше цели останавливаем серию;
                    if (lengthCurrent > lengthBest) {     // Если длина текущей серии больше длины лучшей серии меняем местами;
                        lengthBest = lengthCurrent;
                        lengthCurrent = 0;               // Сброс текущей серии на 0;
                    }
                }
            }
            System.out.println("Максимальное количество подряд идущих дней, " + // Печать серии;
                    "в течение которых количество шагов за день " +
                    "было равно или выше целевого:" + lengthBest);
        }
    }

    void changeGoal() {
        Scanner scanner = new Scanner(System.in); // Создаем сканер;
        System.out.println("Текущая цель по количеству шагов: " + stepsGoal + " шагов. Ввeдите новую цель.");

        while (!scanner.hasNextInt() ) {      // Проверка на ввод числа;
            System.out.println("Это не число! Введите число");
            scanner.next();
        }

        stepsGoal = scanner.nextInt(); // Ввод новой цели;

        while (stepsGoal < 0) {                   // Проверка на ввод отрицательного числа и повторный запрос;
                System.out.println("Некорректные данные, повторите ввод");
            stepsGoal = scanner.nextInt();
            }
            System.out.println("Новая цель по количеству шагов: " + stepsGoal + " шагов."); // Печать новой цели;
        }
    }
