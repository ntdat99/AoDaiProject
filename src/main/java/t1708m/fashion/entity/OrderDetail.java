package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    private int productId;
    private String deliAdress;
    private String quantity;
    private String phone;
    private String totalPrice;
    private long createdAt;
    private int status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetail orderDetail;
}
