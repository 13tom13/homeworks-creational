import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int sizeList = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int max = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> randomList = new ArrayList<>();
        randomList.addAll(new Random().ints(0,max).limit(sizeList).boxed().collect(Collectors.toList()));
        System.out.println(randomList);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        List<Integer> filterList = new Filter(scanner.nextInt()).filterOut(randomList);
        logger.log("Выводим результат на экран");
        System.out.println(filterList);
        logger.log("Завершаем программу");
        scanner.close();
    }
}
