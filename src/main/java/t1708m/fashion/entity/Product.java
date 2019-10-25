package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int categoryId;
    private String name;
    private String price;
    private String description;
    private String image;
    private String size;
    private String color;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;

    public Product() {
    }

}
