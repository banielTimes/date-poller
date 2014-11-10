package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Poll;
import de.datepoller.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dsy on 09.11.14.
 */
public class PollListAction extends ActionSupport {

    @Autowired
    PollService pollService;

    private List<Poll> pollList;

    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
    }

    @Override
    public String execute() throws Exception {
        pollList = pollService.findAllPolls();

        return SUCCESS;
    }
}
