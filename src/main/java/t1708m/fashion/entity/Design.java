package t1708m.fashion.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Getter
@Setter
@Entity
public class Design {
    @Id
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


}
