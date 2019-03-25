package Logic;

public class BeerExpert {
    public String proposeBeer(String color){
        switch (color){
            case "yellow":
                return "Okocim Jasne";
            case "amber":
                return "Tatra mocna";
            case "brown":
                return "Okocim ciemne";
            case "black":
                return "Carlsberg";
        }
        return "Beer not found";
    }
}
