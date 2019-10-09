package com.company.first;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.io.FileOutputStream;

public class TicketWriter {

    //static method for writing to ticket file
    public static void writeTicketFile(String fileName, List<Ticket> ticketList) throws IOException {
        //try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

            for (Ticket ticket : ticketList) {
                objOutputStream.writeObject(ticket);
            }

            outputStream.close();
            objOutputStream.close();
        //} catch (Exception e){
            //System.out.println("There was an error");
        //}
    }
}
