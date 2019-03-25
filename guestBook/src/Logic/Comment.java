package Logic;

public class Comment {
    private String email;
    private String name;
    private String text;

    public Comment( String email, String name, String text){
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
