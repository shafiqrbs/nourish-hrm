package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class EmailSettingsDTO {

    private int Id;
    private String Form;
    private String FormName;
    private String SMTPHost;
    private String SMTPSecure;
    private String SMTPPort;
    private String Authentication;
    private String UserName;
    private String Password;

    public EmailSettingsDTO() {
    }

    public EmailSettingsDTO(int Id, String Form, String FormName, String SMTPHost, String SMTPSecure, String SMTPPort,
                            String Authentication, String UserName, String Password)
    {
        this.Id = Id;
        this.Form = Form;
        this.FormName = FormName;
        this.SMTPHost = SMTPHost;
        this.SMTPSecure = SMTPSecure;
        this.SMTPPort = SMTPPort;
        this.Authentication = Authentication;
        this.UserName = UserName;
        this.Password = Password;
    }

    public int getId(){
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

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
