import java.util.*;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int i : source) {
            if (i < treshold) {
                logger.log(String.format("Элемент \"%d\" не проходит", i));
            } else {
                result.add(i);
                logger.log(String.format("Элемент \"%d\" проходит", i));
            }
        }
        logger.log(String.format("Прошло фильтр %d эелемента(ов) из %d", result.size(), source.size()));
        return result;
    }
}
