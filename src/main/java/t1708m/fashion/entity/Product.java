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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;
    private String price;
    private String description;

    private String image;
    private String size;
    private int gender;
    private int type; // 1. của cửa hàng 2. của khách hàng.    private long updatedAt;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "fabric_id")
    private Fabric fabric;
    @OneToMany(mappedBy = "product",cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<OrderDetail> orderDetails;

    public Product() {
    }

    public enum Type {

        SHOP_PRODUCT(1), CUSTOMER_PRODUCT(2);

        private int value;

        Type(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum SIZE {

        S(1), M(2);

        private int value;

        SIZE(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public enum GENDER {

        MALE(1), FEMALE(0);

        private int value;

        GENDER(int i) {
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
