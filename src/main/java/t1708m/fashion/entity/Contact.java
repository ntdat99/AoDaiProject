package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
}
