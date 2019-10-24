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
public class Admin {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private long updatedAt;
    private long deletedAt;
    private long createdAt;
    private int status;


}
