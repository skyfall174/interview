package cz.moneta.interview.repository;

import cz.moneta.interview.models.QueueItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Repository.
 * Tato trida neni THREAD SAFE!!!
 */
public class QueueRepository {

    static private QueueRepository instance = null;
    private List<QueueItem> list;
    private Integer lastId = 0;

    private QueueRepository() {
        list = new LinkedList<>();
    }

    public static QueueRepository getInstance() {
        if (instance == null) {
            synchronized (QueueRepository.class) {
                if (instance == null) {
                    instance = new QueueRepository();
                }
            }
        }
        return instance;
    }

    // Tady by melo byt neco jako RabbitMq nebo kavka asi nebo DB
    public synchronized List<QueueItem> getItems() {
        return new ArrayList<>(list);
    }

    public synchronized void add(QueueItem item) {
        list.add(item);
        update();
    }

    public synchronized QueueItem removeLast() {
        int index = list.size() - 1;
        return list.remove(index);
    }

    public synchronized QueueItem getActual() {

        return list.get(0);
    }

    public synchronized Integer getLastIdAndUpdate() {
        this.lastId++;
        return lastId;
    }

    public synchronized void update() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOrder(i);
        }
    }
}
