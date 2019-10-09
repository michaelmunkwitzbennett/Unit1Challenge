package com.company.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int option = 1;
        // Collection for storing the active data from tickets.txt
        List<Ticket> myTickets = new ArrayList<>();

        //populate myTickets list with data from the file at the start of the program running
        myTickets.addAll(TicketReader.readTicketFile("tickets.txt"));

        // menu
        while (option != 3) {
            // initialize a new ticket
            Ticket ticket = new Ticket();
            //print the check in menu
            checkIn();

            // process user input
            option = Integer.parseInt(keyboard.nextLine());
            switch (option) {
                case 1:
                    // this ensures unique ticket ids and maintains a count between different sessions
                    int maxId = 0;
                    for (Ticket t: myTickets) {
                        if (t.getTicketId() > maxId) {
                            maxId = t.getTicketId();
                        }
                    }

                    // sets the automatic values that are generated when customer pulls a ticket
                    ticket.setTicketId(maxId + 1);
                    ticket.setCheckInTime();

                    // user will now checkout from the garage
                    //prints the checkout menu, gets user input
                    checkOut();
                    option = option = Integer.parseInt(keyboard.nextLine());
                    switch (option) {
                        case 1:
                            ticket.setCheckOutTime();
                            ticket.calcBill();
                            break;
                        case 2:
                            ticket.ticketGotLost();
                            ticket.setBill(25);
                            break;
                        default:
                            System.out.println("Invalid entry, ticket is assumed to be lost");
                            ticket.ticketGotLost();
                            ticket.setBill(25);
                    }
                    myTickets.add(ticket);
                    ticket.displayBill();
                    break;
                case 3:
                    // ends the program
                    break;
            }
        }

        // garage is closed at the end of the program
        Garage garage = new Garage(myTickets);
        garage.closeGarage();
        // saves myTickets list data into a file
        TicketWriter.writeTicketFile("tickets.txt", myTickets);
    }

    // this function prints a menu for checking in
    public static void checkIn() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.print("=> ");

    }

    // this function prints a menu for checking out
    public static void checkOut() {
        System.out.println("Best Value Parking Garage\n");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=> ");
    }
}
