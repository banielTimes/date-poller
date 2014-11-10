package de.datepoller.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dsy on 07.11.14.
 */

@Entity(name = "poll")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "username")
    private User creator;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<User> users;

    @OneToMany(mappedBy = "poll", /*cascade = CascadeType.ALL,*/ fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Date> suggestedDates;

    @ManyToOne
    @JoinColumn
    private Date finalDate;

    private boolean finished;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Date> getSuggestedDates() {
        return suggestedDates;
    }

    public void setSuggestedDates(List<Date> suggestedDates) {
        this.suggestedDates = suggestedDates;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poll)) return false;

        Poll poll = (Poll) o;

        if (!id.equals(poll.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
