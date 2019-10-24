package t1708m.fashion.entity;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @NaturalId
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

}

enum RoleName {
    CUSTOMER, ADMIN
}