package reviews.main;
import java.util.*;
import reviews.data.Business;
import reviews.data.Restaurant;
import reviews.data.Hairdresser;
import reviews.data.Garage;
import reviews.data.Review;
import reviews.data.User;

public class Management {
    User[] users = new User[10];
    Review[] reviewsRest1 = new Review[2];
    Review[] reviewsRest2 = new Review[2];
    Review[] reviewsHair1 = new Review[2];
    Review[] reviewsHair2 = new Review[2];
    Review[] reviewsGar1 = new Review[2];
    Review[] reviewsGar2 = new Review[2];
    Business[] businesses = new Business[6];

    void initialize() {
        users[0] = new User("a", "a");
        users[1] = new User("b", "b");
        users[2] = new User("c", "c");
        users[3] = new User("d", "d");
        users[4] = new User("e", "e");
        users[5] = new User("f", "f");
        users[6] = new User("g", "g");
        users[7] = new User("h", "h");
        users[8] = new User("i", "i");
        users[9] = new User("j", "j");

        reviewsRest1[0] = new Review(users[0], "yes", 4);
        reviewsRest1[1] = new Review(users[1], "yes", 3);
        reviewsRest2[0] = new Review(users[2], "no", 2);
        reviewsRest2[1] = new Review(users[3], "no", 1);
        reviewsHair1[0] = new Review(users[4], "yes", 5);
        reviewsHair1[1] = new Review(users[5], "no", 2);
        reviewsHair2[0] = new Review(users[6], "yes", 4);
        reviewsHair2[1] = new Review(users[7], "no", 2);
        reviewsGar1[0] = new Review(users[8], "no", 0);
        reviewsGar1[1] = new Review(users[9], "no", 1);
        reviewsGar2[0] = new Review(users[0], "yes", 3);
        reviewsGar2[1] = new Review(users[1], "no", 2);

        businesses[0] = new Restaurant("Aa", "Alicante", reviewsRest1, "Italian");
        businesses[1] = new Restaurant("Bb", "Barcelona", reviewsRest2, "Japanese");
        businesses[2] = new Hairdresser("Cc", "Cádiz", reviewsHair1, true);
        businesses[3] = new Hairdresser("Dd", "Navarra", reviewsHair2, false);
        businesses[4] = new Garage("Ee", "Madrid", reviewsGar1, 3);
        businesses[5] = new Garage("Ff", "Valencia", reviewsGar2, 2);
    }

    User login(String login, String password) {
        User searched = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getLogin() == login && users[i].getPassword() == password) {
                searched = new User(login, password);
            }
        }
        return searched;
    }

    void showReviews(User user) {
        Review myReview = new Review(null, null, 0);
        for (int i = 0; i < businesses.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (businesses[i].reviewList[j].getUser().getLogin() == user.getLogin()) {
                    System.out.println(businesses[i].reviewList[j].toString());
                }
            }
        }
    }

    void sortBusinessesByName() {
        Business auxBusi;
        for (int i = 0; i < businesses.length - 1; i++)
        {
            for (int j = i + 1; j < businesses.length; j++)
            {
                if (businesses[i].getName().compareTo(businesses[j].getName()) < 0)
                {
                    auxBusi = businesses[i];
                    businesses[i] = businesses[j];
                    businesses[j] = auxBusi;
                }
            }
        }
        for (int i = 0; i < businesses.length; i++){
            System.out.println(businesses[i].toString());
        }
    }

    void sortBusinessesByRating(int type){
        Business auxBusi;
        int[] numoftypes;
        Business[] auxbusinesses = new Business[3];

        for (int i = 0; i < businesses.length - 1; i++) {
            for (int j = i + 1; j < businesses.length; j++) {
                if (businesses[i].reviewAverage() > businesses[j].reviewAverage()) {
                    auxBusi = businesses[i];
                    businesses[i] = businesses[j];
                    businesses[j] = auxBusi;
                }
            }
        }

        for (int i = 0; i < businesses.length; i++){
            if (type == 1 && businesses[i].getClass().equals(Restaurant.class) && i < 3) {
                auxbusinesses[i] = businesses[i];
            }
            if (type == 2 && businesses[i].getClass().equals(Hairdresser.class) && i < 3) {
                auxbusinesses[i] = businesses[i];
            }
            if (type == 3 && businesses[i].getClass().equals(Garage.class) && i < 3){
                auxbusinesses[i] = businesses[i];
            }
        }

        for (int i = 0; i < auxbusinesses.length; i++){
            System.out.println(auxbusinesses[i].toString());
        }
    }

    public Business findBusiness(String name){
        Business searched = null;

        for (int i = 0; i < businesses.length; i++){
            if (businesses[i].getName().compareTo(name) == 0){
                searched = businesses[i];
            }
        }

        return searched;
    }

    public Review findReview(User user, Business business){
        Review searched = null;
        for (int j = 0; j < business.reviewList.length; j++){
            if (user == business.reviewList[j].getUser()){
                searched = business.reviewList[j];
            }
        }
        return searched;
    }

    public static void changeReview(Review r, String comment, int rating){
        r.setComment(comment);
        r.setRating(rating);
    }
}
