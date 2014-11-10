package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Date;
import de.datepoller.domain.Poll;
import de.datepoller.domain.User;
import de.datepoller.services.DateService;
import de.datepoller.services.PollService;
import de.datepoller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsy on 09.11.14.
 */
public class ParticipatePollAction extends ActionSupport {

    @Autowired
    private UserService userService;

    @Autowired
    private PollService pollService;

    @Autowired
    private DateService dateService;

    private Long pollId;

    private List<Long> dateIdList;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public List<Long> getDateIdList() {
        return dateIdList;
    }

    public void setDateIdList(List<Long> dateIdList) {
        this.dateIdList = dateIdList;
    }

    @Override
    public String execute() throws Exception {

        Poll poll = pollService.findPollById(pollId);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);

        if (user.equals(poll.getCreator())) {
            return ERROR;
        }

        for (Date date : poll.getSuggestedDates()) {
            date.getAttendingUsers().remove(user);
            user.getAttendingDates().remove(date);

            dateService.update(date);
            userService.update(user);
        }

        for (Long dateId : dateIdList) {
            Date date = dateService.findDateById(dateId);
            date.getAttendingUsers().add(user);
            dateService.update(date);
        }

        if (!poll.getUsers().contains(user)) {
            poll.getUsers().add(user);
        }

        pollService.update(poll);

        return SUCCESS;
    }
}
