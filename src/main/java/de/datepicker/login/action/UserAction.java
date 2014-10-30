package de.datepicker.login.action;

import com.opensymphony.xwork2.ActionSupport;
import de.datepicker.login.bo.UserBo;

/**
 * Created by dsy on 29.10.14.
 */

public class UserAction extends ActionSupport {
    //DI via Spring
    UserBo userBo;

    public UserBo getUserBo() {
        return userBo;
    }

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String execute() throws Exception {

        userBo.getYolo();
        userBo.printUser();
        return "success";

    }
}
