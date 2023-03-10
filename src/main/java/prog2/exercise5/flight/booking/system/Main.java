package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FlightBooking p = new FlightBooking();
        System.out.println("How many tickets do you want>> ");
        p.reserveTickets(in.nextInt());
        p.setTotalPassengers(p.getSize());
        for (int i = 0; i < p.getSize(); i++) {
            System.out.println("Please enter your full name>> ");
            p.setPassengerFullName(i, in.next());
            System.out.println("Please enter your age>> ");
            p.setPassengerAge(i, in.nextInt());
            System.out.println("Please enter your gender (Male, Female, Other)>> ");
            p.setPassengerGender(i, in.next());
            System.out.println("Please enter your trip source(1.NANJING 2.BEIJING 3.OULU 4.HELSINKI)>> ");
            p.setTripSource(i, in.next());
            System.out.println("Please enter your trip destination(1.NANJING 2.BEIJING 3.OULU 4.HELSINKI)>>");
            p.setTripDestination(i, in.next());
            System.out.println("Please enter your trip type(1.ONEWAY/2.RETURN)>>");
            p.setTripType(i, in.next());
            System.out.println("Please select your booking class(1.FIRST, 2.BUSINESS, 3.ECONOMY)>> ");
            p.setBookingClass(in.next());
            System.out.println("Date of departure(YYYY-MM-DD)>> ");
            p.setDepartureDate(i, LocalDate.parse(in.next()));
            if (p.getArrTripType(i).toString().equals("RETURN")) {
                System.out.println("Date of return(YYYY-MM-DD)>> ");
                p.setReturnDate(i, LocalDate.parse(in.next()));
            }
        }
        p.displayTripDetails();
        p.setDepartingTicketPrice(0,p.getSize());
        p.setReturnTicketPrice();
        p.setTotalTicketPrice();
        System.out.println("The total ticket price is: " + p.getTotalTicketPrice());
        if (p.getFlag()) {
            System.out.println("IMPORTANT NOTICE: As per our policy, the return date was changed because it was less\n" +
                    "than two days apart from your departure date.");
        }
    }
}
