package shunin.org.entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "create_date")
    @Timestamp
    private Date createDate;

    @Column(name = "order_done")
    private boolean isOrderDone;


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


    @ManyToMany
    @JoinTable(
            name = "Orders_Products",
            joinColumns = @JoinColumn(name = "order_id"), // order_id
            inverseJoinColumns = @JoinColumn(name = "product_id")) // product_id
    private List<Products> productsList;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
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
