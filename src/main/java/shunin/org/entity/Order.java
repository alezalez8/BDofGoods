package shunin.org.entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "create_date")
    @Timestamp
    private Date createDate;

    @Column(name = "order_done")
    private boolean isOrderDone;


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isOrderDone() {
        return isOrderDone;
    }

    public void setOrderDone(boolean orderDone) {
        isOrderDone = orderDone;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate +
                ", isOrderDone=" + isOrderDone +
                ", client=" + client +
                '}';
    }
}
