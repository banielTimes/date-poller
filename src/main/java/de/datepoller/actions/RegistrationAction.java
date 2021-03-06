package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Role;
import de.datepoller.domain.User;
import de.datepoller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dsy on 06.11.14.
 */
public class RegistrationAction extends ActionSupport {

    @Autowired
    UserService userService;

    private String username;
    private String password;
    private boolean enabled = true;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(true);

        // set ROLE_USER as default
        user.setRole(Role.USER);

        userService.save(user);

        return SUCCESS;
    }
}
