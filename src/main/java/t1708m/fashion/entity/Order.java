package t1708m.fashion.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long price;
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private long createdAt;
    private long updatedAt;
    private long preferTimeAt;
    private long deliveryAt;
    private int status;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<OrderDetail> orderDetails;

    public enum Status {

        SUCCESS(1), CONFIRMED(2), WAIT_TO_CONFIRM(3), CANCELED(4);

        private int value;

        Status(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
