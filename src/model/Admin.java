/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author acer
 */
public class Admin extends PersonAbstract {

    private String npwp;
    
    public Admin(int id, String username, String password, String npwp) {
        super(id, username, password);
        this.npwp = npwp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    @Override
    public String toString() {
        return "Admin{" + "npwp=" + npwp + '}';
    }
}
