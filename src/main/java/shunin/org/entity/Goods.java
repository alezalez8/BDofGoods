package shunin.org.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Goods")
public class Goods {

    @Id
    @Column(name = "goods_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "add_date")
    private Date addDate;

    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "client_id")
    private Order order;



}
