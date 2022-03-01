package reviews.data;

public abstract class Business {
    String name;
    String location;
    public Review[] reviewList;

    public Business(String name, String location, Review[] reviewList) {
        this.name = name;
        this.location = location;
        this.reviewList = new Review[3];
    }

    public float reviewAverage(){
        float average = 0;

        for (int i = 0; i < reviewList.length; i++){
            average = (average + reviewList[i].getRating());
        }

        return average/reviewList.length;
    }

    @Override
    public String toString() {
        return name + " (" + location + ")\n" + "Review average: " + reviewAverage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Review[] getReviewList() {
        return reviewList;
    }
}
