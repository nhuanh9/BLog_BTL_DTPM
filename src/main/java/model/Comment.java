package model;

public class Comment {
    private int id;
    private String content;
    private int accountId;
    private int postId;

    public Comment() {
    }
public  Comment(String content, int accountId, int postId){
    this.content = content;
    this.accountId = accountId;
    this.postId = postId;
}
    public Comment(int id, String content, int accountId, int postId) {
        this.id = id;
        this.content = content;
        this.accountId = accountId;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
