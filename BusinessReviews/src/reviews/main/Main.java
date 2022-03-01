package reviews.main;
import reviews.data.Business;
import reviews.data.Review;
import reviews.data.User;

public class Main {
    static void main() {
        Management management = new Management();
        String login;
        String password;
        String option = "0";
        Business busi = null;
        Review revi = null;
        boolean isValid = false;

        do{
            System.out.println("Enter username: ");
            login = System.console().readLine();
            System.out.println("Enter password: ");
            password = System.console().readLine();
        }while(management.login(login, password) != null);
        User user = management.login(login, password);

        do{
            System.out.println("1-My Reviews");
            System.out.println("2-Business list");
            System.out.println("3-Top rated business");
            System.out.println("4-Edit my review");
            System.out.println("0-Quit");
            option = System.console().readLine();

            switch (option) {
                case "1":
                    System.out.println("Showing personal reviews...");
                    management.showReviews(user);
                    break;
                case "2":
                    management.sortBusinessesByName();
                    break;
                case "3":
                    System.out.println("Choose Restaurant, Hairdresser or Garage (1, 2, 3): ");
                    option = System.console().readLine();
                    if (option.compareTo("1") == 0 || option.compareTo("2") == 0 || option.compareTo("3") == 0){
                        int opInt = Integer.parseInt(option);
                        management.sortBusinessesByRating(opInt);
                    }
                    else{
                        System.out.println("Incorrect option.");
                    }
                    break;
                case "4":
                    System.out.println("Enter the business you want to modify your review: ");
                    option = System.console().readLine();
                    busi = management.findBusiness(option);
                    revi = management.findReview(user, busi);
                    System.out.println("Enter your new comment: ");
                    String comment = System.console().readLine();
                    System.out.println("Enter your new rating (0 to 5): ");
                    String rating = System.console().readLine();
                    int ratingInt = Integer.parseInt(rating);
                    management.changeReview(revi, comment, ratingInt);
                    break;
                case "0":
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Enter a valid option please.");
                    break;
            }
        } while(option.compareTo("0") == 0);
    }
}
