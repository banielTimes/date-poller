package de.datepoller.services;

import de.datepoller.data.DateRepository;
import de.datepoller.domain.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dsy on 07.11.14.
 */

@Service
@Transactional
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public Date findDateById(long id) {
        return dateRepository.findDateById(id);
    }

    public List<Date> findAllDates() {
        return dateRepository.findAll();
    }

    public void update(Date date) {
        dateRepository.save(date);
    }

    public void save(Date date) {
        dateRepository.save(date);
    }

    public void delete(Date date) {
        dateRepository.delete(date);
    }

    public void deleteDateList(List<Date> dateList) {
        for (Date date : dateList) {
            dateRepository.delete(date);
        }
    }

}
