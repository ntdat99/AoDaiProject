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
public class Customer {
    @Id
    private int id;
    private String username;
    private String pass;
    private String email;
    private String address;
    private String phone;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;


}
