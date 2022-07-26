package shunin.org.entity;


import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Products {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "add_date")
    @Timestamp
    private Date addDate;

    @Column(name = "count")
    @Min(1)
    private int count;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "product_id")
    private Order order;



}
