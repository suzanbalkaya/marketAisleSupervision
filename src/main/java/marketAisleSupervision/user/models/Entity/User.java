package marketAisleSupervision.user.models.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "users")
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "NameSurname")
    private String nameSurname;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Adress")
    private String adress;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "ConditionsOfUseContract")
    private Boolean conditionsOfUseContract;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {this.userName = userName;}

    public Boolean getConditionsOfUseContract() {
        return conditionsOfUseContract;
    }

    public void setConditionsOfUseContract(Boolean conditionsOfUseContract) {
        this.conditionsOfUseContract = conditionsOfUseContract;
    }
}

