package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Date;
import de.datepoller.domain.Poll;
import de.datepoller.services.DateService;
import de.datepoller.services.PollService;
import de.datepoller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dsy on 10.11.14.
 */
public class DeletePollAction extends ActionSupport {

    @Autowired
    private UserService userService;

    @Autowired
    private PollService pollService;

    @Autowired
    private DateService dateService;

    private Long pollId;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    @Override
    @Transactional
    public String execute() throws Exception {
        Poll poll = pollService.findPollById(pollId);

        for (Date date : poll.getSuggestedDates()) {
            dateService.delete(date);
        }

        poll.getCreator().getCreatedPolls().clear();
        poll.getCreator().getPolls().clear();

        userService.update(poll.getCreator());

        poll.setCreator(null);
        poll.getSuggestedDates().clear();
        poll.getUsers().clear();

        pollService.delete(poll);

        return SUCCESS;
    }
}
