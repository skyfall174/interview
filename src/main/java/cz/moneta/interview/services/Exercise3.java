package cz.moneta.interview.services;

import cz.moneta.interview.models.QueueItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Exercise3 {

    List<QueueItem> getActualStateOfQueue();

    QueueItem addToQueue();

    QueueItem removeLast();

    QueueItem getActual();

}
