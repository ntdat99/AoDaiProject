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
    private String name;
    private String price;
    private String description;
    private String image;
    private String size;
    private String color;
    private String updatedAt;
    private String createdAt;
    private String deletedAt;
    private int status;





}
