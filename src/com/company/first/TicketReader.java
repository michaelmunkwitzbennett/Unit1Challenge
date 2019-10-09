package com.company.first;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TicketReader {

    // static method for reading ticket file
    public static List<Ticket> readTicketFile(String fileName) {
        List<Ticket> TicketList = new ArrayList<>();
        Object obj = null;

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(file);

            while ((obj = ois.readObject()) != null) {
                Ticket ticket = (Ticket) obj;
                TicketList.add(ticket);
            }

            file.close();
            ois.close();
        } catch (Exception e) {
            System.out.println("File read completed");
        }

        return TicketList;
    }
}
