package Logic;

import java.util.ArrayList;

public class Guests {
    ArrayList<User> guests = new ArrayList<>();

    public boolean hasGuest(String username, String password) {
        for (User user : this.guests){
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public void addGuest(User user){
        this.guests.add(user);
    }
}
