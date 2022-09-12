package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sohag on 4/7/17.
 */
@MappedSuperclass
public abstract class BaseIntEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", columnDefinition = "INT")
    private int id;

    @Size(max = 20)
    @Column(name = "AddedBy", length = 20)
    private String AddedBy;

    @Column(name = "DateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateAdded;

    @Size(max = 20)
    @Column(name = "UpdatedBy", length = 20)
    private String UpdatedBy;

    @Column(name = "UpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(String AddedBy) {
        this.AddedBy = AddedBy;
    }

    public Date getCreatedAt() {
        return DateAdded;
    }

    public void setDateAdded(Date DateAdded) {
        this.DateAdded = DateAdded;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    @PrePersist
    public void setUpdatedDate() {
        this.UpdatedDate = new Date();
    }

    @PreUpdate
    public void setDateAdded() {
        this.DateAdded = new Date();
    }

}
