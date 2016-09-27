package com.example.bharatkumar.meritas;

/**
 * Created by Bharat Kumar on 25-Sep-16.
 */
public class RegisteredAccounts {
    private String _firstname;
    private String _lastname;
    private String _phone;
    private String _email;
    private String _username;
    private String _password;

    public RegisteredAccounts() {
    }

    public RegisteredAccounts(String _firstname, String _lastname, String _phone, String _email, String _username, String _password)
    {
        this._firstname = _firstname;
        this._lastname = _lastname;
        this._phone = _phone;
        this._email = _email;
        this._username = _username;
        this._password = _password;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_firstname() {
        return _firstname;
    }

    public String get_lastname() {
        return _lastname;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_email() {
        return _email;
    }

    public String get_username() {
        return _username;
    }

    public String get_password() {
        return _password;
    }
}
