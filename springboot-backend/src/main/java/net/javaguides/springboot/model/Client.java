package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    @Column(name = "email")
    private String email;
    @Column(name = "parola")
    private String parola;
    @Column(name = "telefon")
    private long telefon;

    public Client() { }

    public Client(String email, String parola, long telefon) {
        this.email = email;
        this.parola = parola;
        this.telefon = telefon;
    }

    public long getId() {
        return idClient;
    }

    public void setId(long id) {
        this.idClient = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }
}
