package co.yuno.YunoTalkTrack.persistence.entity;


import co.yuno.YunoTalkTrack.persistence.enums.Area;
import co.yuno.YunoTalkTrack.persistence.enums.Role;
import jakarta.persistence.*;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Area area;

    @Column(length = 10, unique = true, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    public User(Integer idUser, String name, String email, String phone, Role role) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public User(){

    }
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
