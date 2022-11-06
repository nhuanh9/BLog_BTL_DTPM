package service;

import model.Comment;
import model.Post;

import java.util.List;

public interface BlogService {
    public List<Post> selectAllPosts();
    public List<Post> searchPost(String title);
    public Post selectPostById(int id);

//    void addUserComment(Comment comment);
}
