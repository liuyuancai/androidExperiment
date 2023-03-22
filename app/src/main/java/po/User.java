package po;

public class User {
    private String name;
    private String url;
    private String message;

    public User(String name, String url, String message) {
        this.name = name;
        this.url = url;
        this.message = message;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
