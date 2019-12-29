package cz.moneta.interview.models;


import java.util.Date;

/**
 * Data class of Queue item.
 */
public class QueueItem {
    private Integer id;
    private Date date;
    private Integer order;

    public QueueItem(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
