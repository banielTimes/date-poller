package de.datepoller.data;

import de.datepoller.domain.Date;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dsy on 07.11.14.
 */
public interface DateRepository extends JpaRepository<Date, Long> {

    Date findDateById(long id);
}
