public class Room {
    protected String name;
    protected String subwayStation;
    protected String address;
    protected int area;
    protected int cost;
    protected int rating;

    public Room(String name, String subwayStation, String address, int area, int cost, int rating) {
        this.name = name;
        this.subwayStation = subwayStation;
        this.address = address;
        this.area = area;
        this.cost = cost;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
