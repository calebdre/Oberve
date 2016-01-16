package com.observe.Persistence.Models;

import java.util.List;

public class Profession {
    private String name;
    private Board board;
    private List<Professionals> professionals;

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public List<Professionals> getProfessionals() {
        return professionals;
    }
}
