package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private int status;
}
