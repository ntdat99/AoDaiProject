package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int categoryId;
    private String proName;
    private String proCode;
    private String proColor;
    private String proSize;
    private String proCateFab;
    private String proPrice;
    private String proPriceFab;
    private String proDescription;
    private String proQuantity;
    private String proImage;
    private String proGender;
    private String proShoulderSize;
    private String proStomachSize;
    private String proArmSize;
    private long updatedAt;
    private long updatedBy;
    private long createdAt;
    private long createdBy;
    private long deletedAt;
    private int status;


    public Product() {
    }

}
