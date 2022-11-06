package service;

import model.Account;

import java.util.List;

public interface AccountService {
    public  List<Account> findAll();
    public Account checkLogin(String username, String password);
    public void signUp(String username, String password);
    public Account checkExistAccount(String username);
}
