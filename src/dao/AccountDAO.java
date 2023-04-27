package dao;

import entity.User;

public class AccountDAO <T>{
    private User user;
    private T userTypeObj;

    public AccountDAO(User user, T userTypeObj) {
        this.user = user;
        this.userTypeObj = userTypeObj;
    }


}
