import java.util.Objects;

public class FlatRoom extends Room implements Comparable<FlatRoom>{
    private int numberOfRooms;

    public FlatRoom(String name, String subwayStation, String address, int area, int cost, int rating, int numberOfRooms) {
        super(name, subwayStation, address, area, cost, rating);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }


    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatRoom flatRoom = (FlatRoom) o;
        return numberOfRooms == flatRoom.numberOfRooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRooms);
    }

    @Override
    public String toString() {
        return  "Название квартиры: " + name +
                ", станция метро: " + subwayStation +
                ", адрес: " + address +
                ", площадь, м^2: " + area +
                ", стоимость, руб.: " + cost +
                ", рейтинг: " + rating +
                ", количество комнат: " + numberOfRooms;
    }

    @Override
    public int compareTo(FlatRoom o) {//метод для сортировки по убыванию цены
        return o.getCost() - this.cost;
    }
}
