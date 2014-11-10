package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Poll;
import de.datepoller.domain.User;
import de.datepoller.services.PollService;
import de.datepoller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * Created by dsy on 09.11.14.
 */
public class PollListAction extends ActionSupport {

    @Autowired
    private UserService userService;

    @Autowired
    PollService pollService;

    private User user;

    private List<Poll> pollList;

    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        user = userService.findUserByUsername(username);

        pollList = pollService.findAllPolls();

        return SUCCESS;
    }
}
