package reviews.data;

public class Review {
    User user;
    String comment;
    int rating;

    public Review(User user, String comment, int rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return user.getLogin() + "\n" + comment + "\n" + rating + "/5";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
