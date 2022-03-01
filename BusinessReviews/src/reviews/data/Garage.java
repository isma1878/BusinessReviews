package reviews.data;

public class Garage extends Business{
    float price;

    public Garage(String name, String location, Review[] reviewList, float price) {
        super(name, location, reviewList);
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + location + ") - " + price + " eur/h"  + "\n" + "Review average: " + reviewAverage();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
