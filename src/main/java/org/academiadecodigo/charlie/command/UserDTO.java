package org.academiadecodigo.charlie.command;

import javax.validation.constraints.*;

public class UserDto {

    private Integer id;

    @NotNull(message = "First Name is Mandatory")
    @NotBlank(message = "First Name is Mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "Last Name is Mandatory")
    @NotBlank(message = "Last Name is Mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    private String gender;

    @Min(value = 18, message = "Minimum Age is 18")
    @Max(value = 100, message = "Maximum Age is 100")
    private Integer age;

    @Email
    private String email;

    @Size(max = 150)
    private String biography;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
