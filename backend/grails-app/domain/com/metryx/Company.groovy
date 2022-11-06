package com.metryx

class Company {

    static constraints = {
    }

    String name;
    String segment;
    
    public Company(String name, String segment) {
        this.name = name;
        this.segment = segment;
    }

    public String getName() {
        return name
    }

    public String getSegment() {
        return segment
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", segment='" + segment + '\'' +
                '}';
    }
}

