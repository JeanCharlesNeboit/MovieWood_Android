package com.example.moviewood.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    public int code;
    public String title;
    public Poster poster;
    public int runtime;
    public ArrayList<Genre> genre;
    public Release release;
    public Statistics statistics;
}
