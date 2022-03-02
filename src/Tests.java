import java.util.*;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {

    }
    /**
     * Получить List чисел в виде текстовых элементов
     */
    public void test_1() {
        List<Integer> integerList = getIntList();
        String listString = integerList.toString();
        System.out.println(listString);

    }

    /**
     * Отсортировать список по убыванию
     */
    public void test_2() {
        List<Integer> integerList = getIntList();
        List<Integer> sortedList = integerList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);}

    /**
     * Получить одну строку текста. Каждый элемент должен начинаться с текста "Number - ".
     * Элементы должны разделяться запятой и пробелом.
     * В начале итоговой строки должен быть текст "Number list: "
     * В конце итоговой строки должен быть текст "end of list.".
     */
    public void test_3() {
        List<String> stringList = getStringList();
        String text = stringList.stream().distinct().collect(Collectors.joining(", " ,"Number list: "," end of list."));
        System.out.println(text);
    }

    /**
     * Получить мапу со значениями, ключи которых больше трех и меньше девяти
     */
    public void test_4() {
        Map<Integer, String> map = getMap();
        SortedMap<Integer, String> treeMap = new TreeMap<Integer, String>(map);
        System.out.println(treeMap.subMap(3,9));
    }

    /**
     * Перемешать все элементы в мапе.
     * Пример результата:
     * Элемент 1: ключ - 5, значение "five"
     * Элемент 2: ключ - 7, значение "seven"
     * Элемент 3: ключ - 2, значение "two"
     * и так далее.
     */
    public void test_5() {
        Map<Integer, String> map = getMap();
        List<Map.Entry<Integer, String>> shuffleMap = new ArrayList<>(map.entrySet());
        Collections.shuffle(shuffleMap);

        for (Map.Entry<Integer, String> entry : shuffleMap) {
            System.out.println("Элемент : "+ "ключ " + entry.getKey() + " значение " + entry.getValue());
        }
    }

    /**
     * Установить во всех элементах isDisplayed = true, и оставить в списке только элементы с value NULL.
     */
    public void test_6() {
        List<WebElement> elements = getElements();
        List<WebElement> webE = elements.stream().map(x -> {x.setDisplayed(true); return x;})
                .filter(x -> x.getValue() == null).collect(Collectors.toList());
        webE.stream().forEach(x -> System.out.println(x.getValue()));
    }

    /**
     * Инвертировать isDisplayed параметр каждого элемента и отсортировать список по типу элемента
     * со следующим приоритетом:
     * 1. TEXT
     * 2. INPUT_FIELD
     * 3. CHECKBOX
     * 4. BUTTON
     * 5. RADIO_BUTTON
     * 6. IMAGE
     */
    public void test_7() {
        List<WebElement> elements = getElements();
        elements.stream().map(element -> {
                    element.setDisplayed(!element.isDisplayed());
                    return element;
                }).sorted(Comparator.comparing(ele -> ele.getType(), Comparator.reverseOrder())).
                collect(Collectors.toList());
    }

    /**
     * Создать мапу:
     * ключ - текст
     * значение - тип элемента
     */
    public void test_8() {
        List<WebElement> elements = getElements();
        Map<String, Type> map2 = elements.stream().
                collect(Collectors.toMap(
                        element -> (element.getText()),
                        element -> element.getType(),
                        (value1, value2)->value1));
        System.out.println(map2);
    }

    /**
     * Получить список элементов, у которых текст или значение оканчивается на число от 500 и более.
     * И отсортировать по увеличению сначала элементы с текстом, а затем по убыванию элементы со значением.
     */
    public void test_9() {
        List<WebElement> elements = getElements();
        //  List<WebElement> ele = getElements().stream().dropWhile(n -> (n.getText(), 500)).
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        return map;
    }

    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("one");
        list.add("nine");
        list.add("ten");
        return list;
    }

    public static List<Integer> getIntList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;
    }

    public static List<WebElement> getElements() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            result.add(new WebElement());
        }
        return result;
    }
}
