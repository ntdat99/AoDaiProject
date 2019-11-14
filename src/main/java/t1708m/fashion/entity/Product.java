package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    private double price;
    private String description;
    private String photos;
    private int size;
    private int gender;
    private int accountType; // mẫu này được tạo bởi người dùng hay shop.
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    @OneToOne(optional = true)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id", nullable = true)
    private Account createdBy; // tạo bởi ai.

    @OneToOne(optional = true)
    @JoinColumn(name = "updated_by_id", referencedColumnName = "id", nullable = true)
    private Account updatedBy; // update bởi ai.

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<OrderDetail> orderDetails;

    public enum Gender {

        MALE(1), FEMALE(0);

        private int value;

        Gender(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum AccountType {

        MEMBER(1), SHOP(2);

        private int value;

        AccountType(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum Size {

        XS(1), S(2), M(3), L(4), XL(5), XXL(6);

        private int value;

        Size(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public Product() {

    }

}
