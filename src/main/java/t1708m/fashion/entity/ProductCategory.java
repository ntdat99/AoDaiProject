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
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String description;
    private String price;

    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "category")
    private Set<Product> products;

    public ProductCategory() {
    }

}
