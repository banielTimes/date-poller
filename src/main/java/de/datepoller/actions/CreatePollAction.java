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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsy on 07.11.14.
 */
public class CreatePollAction extends ActionSupport {

    @Autowired
    private UserService userService;

    @Autowired
    private PollService pollService;

    @Autowired
    private DateService dateService;

    private String name;
    private String description;
    private List<String> start;
    private List<String> end;

    public List<String> getStart() {
        return start;
    }

    public void setStart(List<String> start) {
        this.start = start;
    }

    public List<String> getEnd() {
        return end;
    }

    public void setEnd(List<String> end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String execute() throws Exception {

        Poll poll = new Poll();
        List<Date> suggestedDates = new ArrayList<Date>();

        if(start.size() == end.size()) {

            for (int i = 0; i < start.size(); i++) {
                Date date = new Date();

                date.setStartTime(LocalDateTime.parse(start.get(i)));
                date.setEndTime(LocalDateTime.parse(end.get(i)));

                date.setPoll(poll);

                suggestedDates.add(date);
            }

        } else {
            throw new IllegalArgumentException("There must be a start and an end for each date");
        }


        poll.setName(name);
        poll.setDescription(description);
        poll.setSuggestedDates(suggestedDates);

        // set current user as creator
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);
        poll.setCreator(user);
        
        pollService.save(poll);

        Poll poll1 = pollService.findPollById(1);

        System.out.print(poll1);

        return SUCCESS;
    }
}
