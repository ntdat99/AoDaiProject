package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String updatedAt;
    private String deletedAt;
    private String createdAt;
    private int status;

}
