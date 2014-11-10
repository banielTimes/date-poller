package de.datepoller.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by dsy on 07.11.14.
 */

@Entity(name = "date")
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id", updatable = false)
    private Poll poll;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "attendingDates")
    private List<User> attendingUsers;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<User> getAttendingUsers() {
        return attendingUsers;
    }

    public void setAttendingUsers(List<User> attendingUsers) {
        this.attendingUsers = attendingUsers;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (!id.equals(date.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
