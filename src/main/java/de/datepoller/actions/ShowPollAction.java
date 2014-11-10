package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Poll;
import de.datepoller.domain.User;
import de.datepoller.services.PollService;
import de.datepoller.services.UserService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dsy on 09.11.14.
 */
public class ShowPollAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @Autowired
    private PollService pollService;

    private String id;

    private Poll poll;

    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
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

        id = getHttpServletRequest().getParameter("id");

        Long pollId = Long.parseLong(id);

        poll = pollService.findPollById(pollId);

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
}