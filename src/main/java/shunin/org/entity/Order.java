package shunin.org.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // @ManeToOne
    @Column(name = "client_id")
    private Long clientId;

    //@OneToMany
    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "create_date")
    private Date date;

}
