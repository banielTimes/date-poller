package de.datepoller.actions;

import de.datepoller.domain.Date;
import de.datepoller.domain.Poll;
import de.datepoller.services.DateService;
import de.datepoller.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dsy on 09.11.14.
 */
public class UpdatePollAction extends CreatePollAction {

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
    public String execute() throws Exception {
        Poll poll = pollService.findPollById(pollId);

        poll.setName(name);
        poll.setDescription(description);

        dateService.deleteDateList(poll.getSuggestedDates());

        poll.getSuggestedDates().clear();
        poll.setSuggestedDates(addDatesToPoll(poll));

        pollService.update(poll);

        return SUCCESS;
    }
}
