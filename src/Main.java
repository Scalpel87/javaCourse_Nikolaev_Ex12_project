import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<FlatRoom> flatRooms = new ArrayList<>();
    private static List<CommercialPremises> commercialPremises = new ArrayList<>();
    ;

    public static void main(String[] args) throws IOException {
        flatRooms.add(new FlatRoom("На Арбате", "Арбатская", "Ул. Старый Арбат, д. 7, кв. 34", 125, 90000000, 8, 4));
        flatRooms.add(new FlatRoom("На Каширке", "Каширская", "Каширское ш., д. 3, кв. 78", 75, 50000000, 6, 3));
        commercialPremises.add(new CommercialPremises("На Войковской", "Войковская", "Ленинградское ш., 9К1", 258, 180000000, 8, "Общего назначения"));
        commercialPremises.add(new CommercialPremises("На 3-x вокзалах", "Комсомольская", "Ул. Краснопрудная, 54", 158, 110000000, 7, "Свободного назначения"));
        boolean flag = true;
        do {
            switch (mainMenu()) {
                case 1:
                    flatRooms.clear();
                    commercialPremises.clear();
                    break;
                case 2:
                    System.out.println("Квартиры:");
                    flatRooms.forEach(System.out::println);
                    System.out.println("Коммерческие помещения:");
                    commercialPremises.forEach(System.out::println);
                    break;
                case 3:
                    flag = true;
                    do {
                        switch (menuFlat()) {//Работаем с квартирами
                            case 1:
                                addFlat();
                                break;
                            case 2:
                                removeFlat();
                                break;
                            case 3:
                                System.out.println("Отсортированные квартиры по цене (по возрастанию):");
                                flatRooms.stream().sorted(Comparator.comparing(FlatRoom::getCost)).forEach(System.out::println);
                                break;
                            case 4:
                                System.out.println("Отсортированные квартиры по цене (по убыванию):");
                                flatRooms.stream().sorted().forEach(System.out::println);
                                break;
                            case 5:
                                System.out.println("Сгруппированные квартиры по станции метро");
                                flatRooms.stream().sorted(Comparator.comparing(FlatRoom::getSubwayStation)).forEach(System.out::println);
                                break;
                            case 6:
                                System.out.println("Лучшая квартира по оценке:");
                                flatRooms.stream().max(Comparator.comparing(FlatRoom::getRating)).ifPresent(System.out::println);
                                break;
                            case 7:
                                System.out.println("Квартиры:");
                                flatRooms.forEach(System.out::println);
                                break;
                            case 8:
                                flag = false;
                                break;
                            case 9:
                                reader.close();
                                System.exit(0);
                                break;
                        }
                    } while (flag);
                    break;
                case 4:
                    flag = true;
                    do {
                        switch (menuСommercial()) {//Работаем с помещениями
                            case 1:
                                addPremises();
                                break;
                            case 2:
                                removePremises();
                                break;
                            case 3:
                                System.out.println("Отсортированные помещения по цене (по возрастанию):");
                                commercialPremises.stream().sorted(Comparator.comparing(CommercialPremises::getCost)).forEach(System.out::println);
                                break;
                            case 4:
                                System.out.println("Отсортированные помещения по цене (по убыванию):");
                                commercialPremises.stream().sorted().forEach(System.out::println);
                                break;
                            case 5:
                                System.out.println("Сгруппированные помещения по станции метро");
                                commercialPremises.stream().sorted(Comparator.comparing(CommercialPremises::getSubwayStation)).forEach(System.out::println);
                                break;
                            case 6:
                                System.out.println("Лучшее помещение по оценке:");
                                commercialPremises.stream().max(Comparator.comparing(CommercialPremises::getRating)).ifPresent(System.out::println);
                                break;
                            case 7:
                                System.out.println("Коммерческие помещения:");
                                commercialPremises.forEach(System.out::println);
                                break;
                            case 8:
                                flag = false;
                                break;
                            case 9:
                                reader.close();
                                System.exit(0);
                                break;
                        }
                    } while (flag);
                    break;
                case 5:
                    reader.close();
                    System.exit(0);
                    break;
            }
        }
        while (true);
    }

    private static int mainMenu() throws IOException {
        int select = 0;
        do {
            System.out.println("Выберите пункт меню:\n" +
                    "1. Удалить всё из списков.\n" +
                    "2. Вывести сгруппированные списки (Квартиры - список, Коммерческие помещения - список).\n" +
                    "3. Работать с квартирами.\n" +
                    "4. Работать с помещениями.\n" +
                    "5. Выход.");
            select = Integer.parseInt(reader.readLine());
        } while ((select < 1) && (select > 5));
        return select;
    }

    public static int menuFlat() throws IOException {
        int select = 0;
        do {
            System.out.println("Выберите пункт меню:\n" +
                    "1. Добавить квартиру в список для аренды.\n" +
                    "2. Удалить квартиру из списка для аренды.\n" +
                    "3. Отсортировать квартиры по цене (по возрастанию) и вывести.\n" +
                    "4. Отсортировать квартиры по цене (по убыванию) и вывести.\n" +
                    "5. Сгруппировать квартиры по станции метро и вывести.\n" +
                    "6. Выбрать лучшую квартиру по оценке и вывести.\n" +
                    "7. Вывести изначальный список квартир для аренды (порядок, в котором они были добавлены).\n" +
                    "8. Вернуться в главное меню.\n" +
                    "9. Выход.");
            select = Integer.parseInt(reader.readLine());
        } while ((select < 1) && (select > 9));
        return select;
    }

    public static int menuСommercial() throws IOException {
        int select = 0;
        do {
            System.out.println("Выберите пункт меню:\n" +
                    "1. Добавить помещение в список для аренды.\n" +
                    "2. Удалить помещение из списка для аренды.\n" +
                    "3. Отсортировать помещения по цене (по возрастанию) и вывести.\n" +
                    "4. Отсортировать помещения по цене (по убыванию) и вывести.\n" +
                    "5. Сгруппировать помещения по станции метро и вывести.\n" +
                    "6. Выбрать лучшую помещение по оценке и вывести.\n" +
                    "7. Вывести изначальный список помещений для аренды (порядок, в котором они были добавлены).\n" +
                    "8. Вернуться в главное меню.\n" +
                    "9. Выход.");
            select = Integer.parseInt(reader.readLine());
        } while ((select < 1) && (select > 9));
        return select;
    }

    public static void addFlat() throws IOException {
        System.out.println("Введите название помещения");
        String name = reader.readLine();
        System.out.println("Введите станцию метро");
        String subwayStation = reader.readLine();
        System.out.println("Введите адрес");
        String address = reader.readLine();
        System.out.println("Введите кол-во комнат");
        int numberOfRooms = Integer.parseInt(reader.readLine());
        System.out.println("Введите метраж");
        int area = Integer.parseInt(reader.readLine());
        System.out.println("Введите цену");
        int cost = Integer.parseInt(reader.readLine());
        System.out.println("Введите среднюю оценку");
        int rating = Integer.parseInt(reader.readLine());
        flatRooms.add(new FlatRoom(name, subwayStation, address, area, cost, rating, numberOfRooms));
    }

    public static void addPremises() throws IOException {
        System.out.println("Введите название помещения");
        String name = reader.readLine();
        System.out.println("Введите станцию метро");
        String subwayStation = reader.readLine();
        System.out.println("Введите адрес");
        String address = reader.readLine();
        System.out.println("Введите тип помещения");
        String type = reader.readLine();
        System.out.println("Введите метраж");
        int area = Integer.parseInt(reader.readLine());
        System.out.println("Введите цену");
        int cost = Integer.parseInt(reader.readLine());
        System.out.println("Введите среднюю оценку");
        int rating = Integer.parseInt(reader.readLine());
        commercialPremises.add(new CommercialPremises(name, subwayStation, address, area, cost, rating, type));
    }

    public static void removeFlat() throws IOException {
        if (flatRooms.size() >= 1) {
            System.out.println("Введите номер квартиры для удаления");
            for (int i = 0; i < flatRooms.size(); i++) {
                System.out.println((i + 1) + ". " + flatRooms.get(i));
            }
            int number = Integer.parseInt(reader.readLine());
            if ((number > 0) && (number <= flatRooms.size())) flatRooms.remove(number - 1);
            else System.out.println("Нужно ввести число от 1 до " + flatRooms.size());
        } else System.out.println("Нет квартир.");
    }

    public static void removePremises() throws IOException {
        if (commercialPremises.size() >= 1) {
            System.out.println("Введите номер помещения для удаления");
            for (int i = 0; i < commercialPremises.size(); i++) {
                System.out.println((i + 1) + ". " + commercialPremises.get(i));
            }
            int number = Integer.parseInt(reader.readLine());
            if ((number > 0) && (number <= commercialPremises.size())) commercialPremises.remove(number - 1);
            else System.out.println("Нужно ввести число от 1 до " + commercialPremises.size());
        } else System.out.println("Нет помещений.");
    }
}