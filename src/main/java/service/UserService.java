package service;

import model.Account;
import model.Post;

import java.util.List;

public interface UserService {
    public List<Post> findPostByAccountId(int id);
}
