package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="klient")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Imie")
    private String Imie;

    @Column(name="Nazwisko")
    private String Nazwisko;

    @Column(name="Miasto")
    private String Miasto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String miasto) {
        Miasto = miasto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public String getWaga() {
        return Waga;
    }

    public void setWaga(String waga) {
        Waga = waga;
    }

    @Column(name="Email")
    private String Email;

    @Column(name="password")
    private String password;

    @Column(name="Data_urodzenia")
    private String Data_urodzenia;

    @Column(name="Waga")
    private String Waga;

}
