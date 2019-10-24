package t1708m.fashion.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Table(name = "design")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "design_id")
    private int id;
    private int productId;
    private int categoryId;
    private String priceCategory;
    private String color;
    private String price;
    private String fabric;
    private String shoulderSize;
    private String stomachSize;
    private String armSize;
    private String image;
    private String description;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    @OneToOne(mappedBy = "design")
    private Category category;

}
