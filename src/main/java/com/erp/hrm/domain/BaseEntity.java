package com.erp.hrm.domain;

import com.erp.hrm.util.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sohag on 4/7/17.
 */
@MappedSuperclass
public abstract class BaseEntity  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", columnDefinition = "BIGINT")
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
        this.UpdatedDate = UpdatedDate == null? null :DateUtils.getFormatedDate(UpdatedDate);
    }

    @PrePersist
    public void setUpdatedDate() {
        this.UpdatedDate = DateUtils.getFormatedDate( new Date());
    }

    @PreUpdate
    public void setDateAdded() {
        this.DateAdded = DateUtils.getFormatedDate(new Date());
    }

}
