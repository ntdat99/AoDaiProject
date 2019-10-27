package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int id;
    private String deliAdress;
    private String quantity;
    private String phone;
    private String totalPrice;
    private long createdAt;
    private int status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderProduct orderProduct;
}
