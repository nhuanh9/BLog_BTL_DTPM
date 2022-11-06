package model;

public class Post {
    private int id;
    private int accountId;
    private String title;
    private String content;
    private int status;
    private String image;

    public Post() {
    }

    public Post(int id, int accountId, String title, String content, int status, String image) {
        this.id = id;
        this.accountId = accountId;
        this.title = title;
        this.content = content;
        this.status = status;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
