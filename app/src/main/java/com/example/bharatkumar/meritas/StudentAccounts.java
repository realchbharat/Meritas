package com.example.bharatkumar.meritas;

/**
 * Created by Bharat Kumar on 27-Sep-16.
 */
public class StudentAccounts {

    private String _studentname;
    private String _phone;
    private String _email;
    private String _address;
    private String _course;

    public StudentAccounts() {
    }

    public StudentAccounts(String _studentname, String _phone, String _email, String _address, String _course) {
        this._studentname = _studentname;
        this._phone = _phone;
        this._email = _email;
        this._address = _address;
        this._course = _course;
    }

    public void set_studentname(String _studentname) {
        this._studentname = _studentname;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public void set_course(String _course) {
        this._course = _course;
    }

    public String get_studentname() {
        return _studentname;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_email() {
        return _email;
    }

    public String get_address() {
        return _address;
    }

    public String get_course() {
        return _course;
    }
}
