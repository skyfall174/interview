package cz.moneta.interview.services;

import cz.moneta.interview.models.QueueItem;
import cz.moneta.interview.repository.QueueRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Component
public class Exercise3Impl implements Exercise3 {
    final QueueRepository repository = QueueRepository.getInstance();

    @Override
    public List<QueueItem> getActualStateOfQueue() {
        return repository.getItems();
    }

    @Override
    public QueueItem addToQueue() {

        QueueItem newItem = new QueueItem(repository.getLastIdAndUpdate(), Date.from(Instant.now()));
        repository.add(newItem);
        repository.update();
        return newItem;
    }

    @Override
    public QueueItem removeLast() {
        return repository.removeLast();
    }

    @Override
    public QueueItem getActual() {
        return repository.getActual();
    }
}
