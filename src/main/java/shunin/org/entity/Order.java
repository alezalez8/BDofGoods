package shunin.org.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Products> productsList = new ArrayList<>();

}
