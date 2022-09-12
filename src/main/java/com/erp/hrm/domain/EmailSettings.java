package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 05/05/2018.
 */
@Entity
@Table( name = "EmailSettings" )
public class EmailSettings extends BaseIntEntity {

    @Size(max = 50)
    @Column(name = "Form")
    private String Form;

    @Size(max = 150)
    @Column(name = "FormName")
    private String FormName;

    @Size(max = 50)
    @Column(name = "SMTPHost")
    private String SMTPHost;

    @Size(max = 50)
    @Column(name = "SMTPSecure")
    private String SMTPSecure;

    @Size(max = 50)
    @Column(name = "SMTPPort")
    private String SMTPPort;

    @Size(max = 150)
    @Column(name = "Authentication")
    private String Authentication;

    @Size(max = 150)
    @Column(name = "UserName")
    private String UserName;

    @Size(max = 150)
    @Column(name = "Password")
    private String Password;

    public String getForm() {
        return Form;
    }

    public void setForm(String Form) {
        this.Form = Form;
    }

    public String getFormName() {
        return FormName;
    }

    public void setFormName(String FormName) {
        this.FormName = FormName;
    }

    public String getSMTPHost() {
        return SMTPHost;
    }

    public void setSMTPHost(String SMTPHost) {
        this.SMTPHost = SMTPHost;
    }

    public String getSMTPSecure() {
        return SMTPSecure;
    }

    public void setSMTPSecure(String SMTPSecure) {
        this.SMTPSecure = SMTPSecure;
    }

    public String getSMTPPort() {
        return SMTPPort;
    }

    public void setSMTPPort(String SMTPPort) {
        this.SMTPPort = SMTPPort;
    }

    public String getAuthentication() {
        return Authentication;
    }

    public void setAuthentication(String Authentication) {
        this.Authentication = Authentication;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
