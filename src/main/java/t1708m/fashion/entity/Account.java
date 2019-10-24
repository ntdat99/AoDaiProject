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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private long updatedAt;
    private long updatedBy;
    private long createdAt;
    private long createdBy;
    private long deletedAt;
    private Role role;
    private int status;

}
