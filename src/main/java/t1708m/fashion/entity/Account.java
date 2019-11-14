package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private int role;

    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    @OneToOne(optional = true)
    @JoinColumn(name = "updated_by_id", referencedColumnName = "id", nullable = true)
    private Account updatedBy; // update bởi ai.

    @OneToMany(mappedBy = "createdBy", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Order> createdOrders;

    @OneToMany(mappedBy = "updatedBy", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Order> updatedOrders;

    public enum Role {

        CUSTOMER(1), ADMIN(99);

        private int value;

        Role(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum Status {

        ACTIVE(1), DEACTIVE(0), DELETED(-1);

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