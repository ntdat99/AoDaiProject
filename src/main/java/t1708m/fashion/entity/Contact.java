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
public class Contact {
    @Id
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;


}
