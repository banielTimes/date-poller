package de.datepicker.login.action;

import de.datepicker.login.bo.UserBo;

/**
 * Created by dsy on 29.10.14.
 */
public class UserAction {
    //DI via Spring
    UserBo userBo;

    public UserBo getUserBo() {
        return userBo;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String execute() throws Exception {

        userBo.printUser();
        return "success";

    }
}
