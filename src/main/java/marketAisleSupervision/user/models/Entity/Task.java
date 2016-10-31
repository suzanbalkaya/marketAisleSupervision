package marketAisleSupervision.user.models.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TaskName")
    private String taskName;
    @Column(name = "TaskTitle")
    private String taskTitle;
    @Column(name = "Description")
    private String description;
    @Column(name = "Location")
    private String location;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "Adress")
    private String adress;
    @Column(name = "AdminId")
    private Integer adminId;
    @Column(name = "Prize")
    private Integer prize;
    @Column(name = "RequestSize")
    private Integer requestSize;
    @Column(name = "CompletionPeriod")
    private String completionPeriod;
    @Column(name = "CreatedDate")
    private String  createdDate;
    @Column(name = "FinishedDate")
    private String finishedDate;
    @Column(name = "ModifilDate")
    private String modifilDate;
    @Column(name = "TaskAcceptedContract")
    private Boolean taskAcceptedContract;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public Integer getRequestSize() {
        return requestSize;
    }

    public void setRequestSize(Integer requestSize) {
        this.requestSize = requestSize;
    }

    public String getCompletionPeriod() {
        return completionPeriod;
    }

    public void setCompletionPeriod(String completionPeriod) {
        this.completionPeriod = completionPeriod;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getModifilDate() {
        return modifilDate;
    }

    public void setModifilDate(String modifilDate) {
        this.modifilDate = modifilDate;
    }

    public Boolean getTaskAcceptedContract() {
        return taskAcceptedContract;
    }

    public void setTaskAcceptedContract(Boolean taskAcceptedContract) {
        this.taskAcceptedContract = taskAcceptedContract;
    }
}
