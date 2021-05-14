package com.company;

    public class Character {
    private int id;
    private String name;
    private String _class;
    private int feature;

    public Character(int id, String name, String _class, int feature) {
        this.id = id;
        this.name = name;
        this._class = _class;
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

        public int getFeature() {
            return feature;
        }
    }
