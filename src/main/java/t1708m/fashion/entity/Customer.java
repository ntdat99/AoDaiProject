package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private String username;
    private String pass;
    private String email;
    private String address;
    private String phone;
    private String updatedAt;
    private String createdAt;
    private String deletedAt;
    private int status;

}
