package com.observe.Persistence.Models;

import java.util.List;

public class Board {
    private String name;
    private List<Profession> professions;

    public List<Profession> getProfessions() {
        return professions;
    }

    public String getName() {
        return name;
    }
}
