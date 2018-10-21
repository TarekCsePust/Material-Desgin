package com.example.hasantarek.materialdesign_10;

/**
 * Created by Hasan Tarek on 9/27/2017.
 */
public class Moviedataprovider {

    String movie_name;
    String email;
    String actor;
    int image;

    public Moviedataprovider(String movie_name, String email, String actor, int image) {

        this.movie_name = movie_name;
        this.email = email;
        this.actor = actor;
        this.image = image;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getEmail() {
        return email;
    }

    public String getActor() {
        return actor;
    }

    public int getImage() {
        return image;
    }
}