package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Poll;
import de.datepoller.services.PollService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dsy on 10.11.14.
 */
public class FinishPollDialogAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest httpServletRequest;

    @Autowired
    private PollService pollService;

    private String id;

    private Poll poll;

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

    @Override
    public String execute() throws Exception {

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
