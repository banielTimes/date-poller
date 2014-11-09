package de.datepoller.data;

import de.datepoller.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dsy on 07.11.14.
 */
public interface PollRepository extends JpaRepository<Poll, Long> {

    Poll findPollById(Long id);
}
