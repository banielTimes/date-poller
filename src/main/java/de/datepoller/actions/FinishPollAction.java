package de.datepoller.actions;

import com.opensymphony.xwork2.ActionSupport;
import de.datepoller.domain.Date;
import de.datepoller.domain.Notification;
import de.datepoller.domain.Poll;
import de.datepoller.services.DateService;
import de.datepoller.services.NotificationService;
import de.datepoller.services.PollService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dsy on 10.11.14.
 */
public class FinishPollAction extends ActionSupport {

    HttpServletRequest httpServletRequest;

    @Autowired
    private PollService pollService;

    @Autowired
    private DateService dateService;

    @Autowired
    private NotificationService notificationService;

    private Long pollId;

    private Long dateId;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    @Override
    public String execute() throws Exception {

        Poll poll = pollService.findPollById(pollId);
        Date date = dateService.findDateById(dateId);

        Notification notification = new Notification();

        notification.setMessage("Poll ended");
        notification.setPoll(poll);

        poll.setFinished(true);
        poll.setFinalDate(date);

        pollService.update(poll);
        notificationService.save(notification);

        return SUCCESS;
    }

}
