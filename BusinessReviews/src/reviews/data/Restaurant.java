package reviews.data;

public class Restaurant extends Business{
    String foodType;

    public Restaurant(String name, String location, Review[] reviewList, String foodType) {
        super(name, location, reviewList);
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return name + " (" + location + ") - " + foodType + "\n" + "Review average: " + reviewAverage();
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
