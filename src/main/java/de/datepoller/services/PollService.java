package de.datepoller.services;

import de.datepoller.data.PollRepository;
import de.datepoller.domain.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dsy on 07.11.14.
 */

@Service
@Transactional
public class PollService {

    @Autowired
    private PollRepository pollRepository;


    public Poll findPollById(long id) {
        return pollRepository.findPollById(id);
    }

    public List<Poll> findAllPolls() {
        return pollRepository.findAll();
    }

    public void update(Poll poll) {
        pollRepository.save(poll);
    }

    public void save(Poll poll) {
        pollRepository.save(poll);
    }

    public void delete(Poll poll) {
        pollRepository.delete(poll);
    }

}
