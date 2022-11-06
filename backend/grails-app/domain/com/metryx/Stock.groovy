package com.metryx

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter;

class Stock {

    static constraints = {
    }

    double price;
    LocalDateTime date;
    Company company;

    Stock(double price, LocalDateTime date, Company company) {
        this.price = price;
        this.date = date;
        this.company = company;
    }

    public double getPrice() {
        return price
    }

    public LocalDateTime getDate() {
        return date
    }

    public Company getCompany() {
        return company
    }
    public String quote() {
        return company.name + '[' +
            "price=" + price +
            ", date=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ']';
    }
}