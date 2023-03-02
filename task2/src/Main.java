import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        int sizeList;
        int max;
        int filter;
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        while (true){
            System.out.print("Введите размер списка: ");
            try {
                sizeList = Integer.parseInt(scanner.next());
                if (sizeList <= 0 ) throw new Exception();
                break;
            } catch (Exception e){
                System.out.println("Не верный ввод!");
            }
        }
        while (true){
            System.out.print("Введите верхнюю границу для значений: ");
            try {
                max = Integer.parseInt(scanner.next());
                if (max <= 0 ) throw new Exception();
                break;
            } catch (Exception e){
                System.out.println("Не верный ввод!");
            }
        }
        logger.log("Создаём и наполняем список");
        List<Integer> randomList = new ArrayList<>();
        randomList.addAll(new Random().ints(0,max).limit(sizeList).boxed().collect(Collectors.toList()));
        System.out.println(randomList);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        while (true){
            System.out.print("Введите порог для фильтра: ");
            try {
                filter = Integer.parseInt(scanner.next());
                if (filter <= 0 ) throw new Exception();
                break;
            } catch (Exception e){
                System.out.println("Не верный ввод!");
            }
        }
        List<Integer> filterList = new Filter(filter).filterOut(randomList);
        logger.log("Выводим результат на экран");
        System.out.println(filterList);
        logger.log("Завершаем программу");
        scanner.close();
    }
}
