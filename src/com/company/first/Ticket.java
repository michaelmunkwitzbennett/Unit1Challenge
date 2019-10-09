package com.company.first;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket implements Serializable {
    public int ticketId;
    public LocalTime checkInTime;
    public LocalTime checkOutTime;
    public double bill;
    public boolean lost = false;

    // default constructor
    public Ticket() {
        this.ticketId = 1;
        this.checkInTime = LocalTime.now();
        this.checkOutTime = LocalTime.now();
        this.bill = 0;
    }



    // getters and setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setCheckInTime() {
        this.checkInTime = TimeGenerator.randomMorning();
    }

    public void setCheckOutTime() {
        this.checkOutTime = TimeGenerator.randomEvening();
    }

    public double getBill() { return bill; }

    public void setBill(double bill) { this.bill = bill; }

    // sets a lost ticket value of true
    public void ticketGotLost() { lost = true; }

    public boolean isLost() {
        return lost;
    }

    // calculates the time in hours (as a double) between check in and check out
    public double calcDuration() {
        double timeCheckedIn = 0;
        Duration d = Duration.between(checkInTime, checkOutTime);
        timeCheckedIn = d.toHours();
        return timeCheckedIn;
    }

    // calculates the bill based off the duration
    public void calcBill() {
        bill = 5;
        if (calcDuration() > 3){
            double timeOverThree = calcDuration() - 3;
            bill = bill + timeOverThree;
        }
    }

    // prints the bill for a lost ticket or a successfull check out
    public void displayBill() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ha");
        DecimalFormat df = new DecimalFormat("$0.00");

        if (lost) {
            System.out.println("Best Value Parking Garage\n");
            System.out.println("=========================");
            System.out.println("Receipt for a vehicle id " + ticketId);
            System.out.println();
            System.out.println("Lost Ticket");
            System.out.println(df.format(bill));
        } else {
            System.out.println("Best Value Parking Garage\n");
            System.out.println("=========================");
            System.out.println("Receipt for a vehicle id " + ticketId);
            System.out.println();
            System.out.println((int)calcDuration() + " hours parked " + checkInTime.format(dtf) + " - " + checkOutTime.format(dtf));
            System.out.println(df.format(bill));
        }
    }

}
