package com.fixmyride.model.dto.mechanic;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MechanicDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty
    @Size(min = 5)
    private String certification;

    @NotEmpty
    @Size(min = 5)
    private String phone;

    @NotEmpty
    @Email
    private String email;

    public MechanicDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

