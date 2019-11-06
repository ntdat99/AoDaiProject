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
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int role; // 1 customer, 99 admin.
    private int status;

    @OneToMany(mappedBy = "account", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Order> orders;
//
//    public enum Role {
//
//        CUSTOMER(1), ADMIN(99);
//
//        private int value;
//
//        Role(int i) {
//            this.value = i;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }

}