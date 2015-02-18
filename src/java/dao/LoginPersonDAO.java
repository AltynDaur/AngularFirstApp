package dao;

import entity.LoginPerson;

/**
 * Created by admin on 2/18/2015.
 */
public interface LoginPersonDAO {
    public LoginPerson find(String login);
}
