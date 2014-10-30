package de.datepicker.login.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by dsy on 30.10.14.
 */
public class LoginAction extends ActionSupport {
    String username;
    String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String execute() throws Exception {
        this.setUsername("admin");
        this.setMessage("GREAT SUCCESS");

        return "success";
    }
}
