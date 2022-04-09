import java.util.Objects;

public class CommercialPremises extends Room implements Comparable<CommercialPremises>{

    private String type;

    public CommercialPremises(String name, String subwayStation, String address, int area, int cost, int rating, String type) {
        super(name, subwayStation, address, area, cost, rating);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommercialPremises that = (CommercialPremises) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Название помещения: " + name +
                ", станция метро: " + subwayStation +
                ", адрес: " + address +
                ", площадь, м^2: " + area +
                ", стоимость, руб.: " + cost +
                ", рейтинг: " + rating +
                ", тип помещения: " + type;
    }

    @Override
    public int compareTo(CommercialPremises o) {
        return o.getCost() - this.cost;
    }
}
