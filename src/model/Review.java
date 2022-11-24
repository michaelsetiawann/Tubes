/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Review {
    private int id_user;
    private String pesan_review;
    private int rating;

    public Review(int id_user, String pesan_review, int rating) {
        this.id_user = id_user;
        this.pesan_review = pesan_review;
        this.rating = rating;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPesan_review() {
        return pesan_review;
    }

    public void setPesan_review(String pesan_review) {
        this.pesan_review = pesan_review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
   
    
    
}
