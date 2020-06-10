package com.et.user;

import com.et.validation.FieldMatch;
import com.et.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "[_\\-\\.0-9a-z]{8,20}", message = "Length should be at least 8 characters and at most 20 characters, and could only contains'0-9-_.'")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "[_\\-\\.0-9a-z]{8,20}", message = "Length should be at least 8 characters and at most 20 characters, and could only contains'0-9-_.'")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "[_\\-\\.0-9a-z]{8,20}", message = "Length should be at least 8 characters and at most 20 characters, and could only contains'0-9-_.'")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "[_\\-\\.0-9a-z]{8,20}", message = "Length should be at least 8 characters and at most 20 characters, and could only contains'0-9-_.'")
    private String lastName;

    @ValidEmail
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "[_\\-\\.0-9a-z]{8,20}", message = "Length should be at least 8 characters and at most 20 characters, and could only contains'0-9-_.'")
    private String email;

    @NotNull
    @Pattern(regexp = "(0\\.[0-9]{1,2})|([1-9][0-9]*\\.[0-9]{1,2})|([1-9][0-9]*)", message = "Need double input without leading zeros and two decimals at most")
    private String balance;

    public CrmUser() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
