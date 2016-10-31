package marketAisleSupervision.user.models.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "runningTask")
public class RunningTasks {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TaskId")
    private Integer taskId;
    @Column(name = "TaskName")
    private String taskName;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "AdminId")
    private Integer adminId;
    @Column(name = "Prize")
    private Integer prize;
    @Column(name = "CompletionPeriod")
    private Integer complationPeriod;
    @Column(name = "CreatedDate")
    private String createdDate;
    @Column(name = "IBAN")
    private String iban;
    @Column(name = "NameSurname")
    private String nameSurname;
    @Column(name = "Images")
    private String images;
    @Column(name = "AgreementId")
    private Integer agreementId;
    @Column(name = "Locasion")
    private String locasion;
    @Column(name = "XP")
    private Integer xp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public Integer getComplationPeriod() {
        return complationPeriod;
    }

    public void setComplationPeriod(Integer complationPeriod) {
        this.complationPeriod = complationPeriod;
    }

    public String  getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Integer agreementId) {
        this.agreementId = agreementId;
    }

    public String getLocasion() {
        return locasion;
    }

    public void setLocasion(String locasion) {
        this.locasion = locasion;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }


}