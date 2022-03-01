package reviews.data;

public class Hairdresser extends Business{
    boolean isUnisex;

    public Hairdresser(String name, String location, Review[] reviewList, boolean isUnisex) {
        super(name, location, reviewList);
        this.isUnisex = isUnisex;
    }

    @Override
    public String toString() {
        if (isUnisex == true)
            return name + " (" + location + ") - unisex"  + "\n" + "Review average: " + reviewAverage();
        else
            return name + " (" + location + ") - not unisex"  + "\n" + "Review average: " + reviewAverage();
    }

    public boolean isUnisex() {
        return isUnisex;
    }

    public void setUnisex(boolean unisex) {
        isUnisex = unisex;
    }
}
