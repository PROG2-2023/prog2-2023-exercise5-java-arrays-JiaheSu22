package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.util.UUID;

public class FlightBooking {
    private final String flightCompany = "Flights-of-Fancy";//This must NOT be entered by the Passenger
    private String flightID;//This must NOT be entered by the Passenger
    private int size;
    private String[] passengerFullName;
    private String[] passengerGender;
    private int[] passengerAge;
    private String[] ticketNumber;/*This must NOT be entered by the Passenger*/

    public enum BookingClass {FIRST, BUSINESS, ECONOMY}

    public enum TripSource {NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS}

    public enum TripDestination {NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS}

    public enum TripType {ONE_WAY, RETURN}

    private TripType tripType;
    private TripType[] arrTripType;
    private TripSource tripSource;
    private TripSource[] arrTripSource;
    private TripDestination tripDestination;
    private TripDestination[] arrTripDestination;
    private BookingClass bookingClass;
    private BookingClass[] arrBookingClass;

    private enum DestinationAirport {Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport}

    private enum SourceAirport {Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport}

    private SourceAirport sourceAirport;
    private DestinationAirport destinationAirport;
    private LocalDate departureDate;
    private LocalDate[] arrDepartureDate;
    private LocalDate returnDate;
    private LocalDate[] arrReturnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice = 0; //This must NOT be entered by the Passenger
    private double returnTicketPrice = 0; //This must NOT be entered by the Passenger
    private double totalTicketPrice = 0; //This must NOT be entered by the Passenger
    private boolean flag = false;
    private String oldDate;
    private String[] arrOldDate;
    private double totalDepartureTicketPrice;

    private String generateFlightID() {
        int randomInt = (int) (Math.random() * 9999) + 1;
        return "FOF" + String.format("%04d", randomInt) + "IN";
    }

    private String generateTicketNumber() {
        String ticketNum = "11";
        if (tripType == TripType.RETURN) {
            ticketNum = "22";
        }
        if (bookingClass == BookingClass.FIRST) {
            ticketNum += "F";
        } else if (bookingClass == BookingClass.BUSINESS) {
            ticketNum += "B";
        } else if (bookingClass == BookingClass.ECONOMY) {
            ticketNum += "E";
        }
        ticketNum += UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        if (tripSource == null || tripDestination == null) {
            ticketNum += "DOM";
        } else {
            int temp = tripSource.toString().length() + tripDestination.toString().length();
            if (temp == 14 || temp == 12) {
                ticketNum += "DOM";
            } else ticketNum += "INT";
        }
        return ticketNum;
    }

    /*public FlightBooking(String name, LocalDate sdepart, LocalDate sreturn, int childNum, int adultNum) {
        this.passengerFullName = name;
        this.departureDate = sdepart;
        this.returnDate = sreturn;
        this.childPassengers = childNum;
        this.adultPassengers = adultNum;
        System.out.println();
    }*/

    public void displayTripDetails() {
        System.out.println("Thank you for booking your flight with " + flightCompany + "." );
        System.out.println("You reserved a total of" + size + "tickets.");
        for (int i = 0; i < size; i++) {
            System.out.println("Here are the trip details for Passenger No." + i);
            System.out.println("Passenger's Ticket Number: " + ticketNumber[i]);
            System.out.println("Passenger's Full Name: " + passengerFullName[i]);
            System.out.println("Passenger's Gender: " + passengerGender[i]);
            System.out.println("From: "+ arrTripSource[i]);
            System.out.println("to: "+ arrTripDestination[i]);
            System.out.println("The flight departs on: " + arrDepartureDate[i]);
            if(flag){
                System.out.println("And the return flight is on: " + arrReturnDate[i] + "(Changed from old " + arrOldDate[i] + " to new "
                        + arrReturnDate[i] );
            }else System.out.println("And the return flight is on: " + arrReturnDate[i]);
        }
    }


    public void setTripDestination(String tripDestinationChoice) {
        int choice = Integer.parseInt(tripDestinationChoice);
        switch (choice) {
            case 1:
                this.tripDestination = TripDestination.NANJING;
                break;
            case 2:
                this.tripDestination = TripDestination.BEIJING;
                break;
            case 3:
                this.tripDestination = TripDestination.OULU;
                break;
            case 4:
                this.tripDestination = TripDestination.HELSINKI;
                break;
            default:
                System.out.println("Invalid trip source choice: " + tripDestinationChoice);
        }
    }

    public void setTripDestination(int i, String tripDestinationChoice) {
        int choice = Integer.parseInt(tripDestinationChoice);
        switch (choice) {
            case 1:
                this.arrTripDestination[i] = TripDestination.NANJING;
                break;
            case 2:
                this.arrTripDestination[i] = TripDestination.BEIJING;
                break;
            case 3:
                this.arrTripDestination[i] = TripDestination.OULU;
                break;
            case 4:
                this.arrTripDestination[i] = TripDestination.HELSINKI;
                break;
            default:
                System.out.println("Invalid trip source choice: " + tripDestinationChoice);
        }
    }

    public void setBookingClass(String inputChoice) {
        int choice = Integer.parseInt(inputChoice);
        this.bookingClass = BookingClass.values()[choice - 1];
    }

    public void setBookingClass(int i, String inputChoice) {
        int choice = Integer.parseInt(inputChoice);
        this.arrBookingClass[i] = BookingClass.values()[choice - 1];
    }

    public BookingClass getBookingClass() {
        return this.bookingClass;
    }

    public TripSource getTripSource() {
        return tripSource;
    }

    public void setTripSource(String tripSourceChoice) {
        int choice = Integer.parseInt(tripSourceChoice);
        switch (choice) {
            case 1:
                this.tripSource = TripSource.NANJING;
                break;
            case 2:
                this.tripSource = TripSource.BEIJING;
                break;
            case 3:
                this.tripSource = TripSource.OULU;
                break;
            case 4:
                this.tripSource = TripSource.HELSINKI;
                break;
            default:
                System.out.println("Invalid trip source choice: " + tripSourceChoice);
        }
    }

    public void setTripSource(int i, String tripSourceChoice) {
        int choice = Integer.parseInt(tripSourceChoice);
        switch (choice) {
            case 1:
                this.arrTripSource[i] = TripSource.NANJING;
                break;
            case 2:
                this.arrTripSource[i] = TripSource.BEIJING;
                break;
            case 3:
                this.arrTripSource[i] = TripSource.OULU;
                break;
            case 4:
                this.arrTripSource[i] = TripSource.HELSINKI;
                break;
            default:
                System.out.println("Invalid trip source choice: " + tripSourceChoice);
        }
    }

    public void setTripDestination(String sourceInput, String destinationInput) {
        int sourceChoice = Integer.parseInt(sourceInput);
        int destinationChoice = Integer.parseInt(destinationInput);
        TripDestination[] destinations = TripDestination.values();
        this.tripDestination = destinations[destinationChoice - 1];
    }

    public TripDestination getTripDestination() {
        return this.tripDestination;
    }


    public void setTripType(String inputChoice) {
        int choice = Integer.parseInt(inputChoice);
        this.tripType = choice == 1 ? TripType.ONE_WAY : TripType.RETURN;
    }

    public void setTripType(int i, String inputChoice) {
        int choice = Integer.parseInt(inputChoice);
        this.arrTripType[i] = choice == 1 ? TripType.ONE_WAY : TripType.RETURN;
    }

    public TripType getTripType() {
        return this.tripType;
    }


    public FlightBooking() {

    }

   /* public void displayConfirmationMessage() {
        System.out.println("Dear " + passengerFullName + ". Thank you for booking your flight with " + flightCompany + ".");
        System.out.println("Following are the details of your booking and the trip:");
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("From " + tripSource + " to " + tripDestination);
        System.out.println("Date of departure: " + departureDate);
        System.out.println("Date of return: " + returnDate);
        System.out.println("Total passengers: " + getTotalPassengers());
        System.out.println("Total ticket price in Euros: " + getTotalTicketPrice());
        flightID = generateFlightID();
    }*/

    public String getFlightID() {
        return flightID;
    }


    public int getChildPassengers() {
        return childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getPassengerFullName(int i) {
        return passengerFullName[i];
    }

    public String getPassengerGender(int i) {
        return passengerGender[i];
    }

    public int getPassengerAge(int i) {
        return passengerAge[i];
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        if (returnDate != null && departureDate.plusDays(2).isAfter(returnDate)) {
            returnDate = departureDate.plusDays(2);
            System.out.println("Return date adjusted to " + returnDate);
        }
    }

    public void setDepartureDate(int i, LocalDate departureDate) {
        this.arrDepartureDate[i] = departureDate;
        if (arrReturnDate[i] != null && departureDate.plusDays(2).isAfter(arrReturnDate[i])) {
            arrReturnDate[i] = departureDate.plusDays(2);
            System.out.println("Return date adjusted to " + arrReturnDate[i]);
        }
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        if (departureDate != null && departureDate.plusDays(2).isAfter(returnDate)) {
            this.returnDate = departureDate.plusDays(2);
            flag = true;
            oldDate = returnDate.toString();
        } else {
            this.returnDate = returnDate;
        }
    }

    public void setReturnDate(int i, LocalDate returnDate) {
        if (arrDepartureDate[i] != null) {
            LocalDate minReturnDate = arrDepartureDate[i].plusDays(2);
            if (arrReturnDate[i] == null || arrReturnDate[i].isBefore(minReturnDate)) {
                this.arrReturnDate[i] = minReturnDate;
                flag = true;
                arrOldDate[i] = arrReturnDate[i].toString();
            }
        }
        if (arrReturnDate[i] == null || returnDate.isAfter(arrReturnDate[i])) {
            this.arrReturnDate[i] = returnDate;
        }
    }

    public int getTotalPassengers() {
        totalPassengers = childPassengers + adultPassengers;
        return totalPassengers;
    }


    public double getTotalTicketPrice() {
        totalTicketPrice = totalDepartureTicketPrice + returnTicketPrice;
        return totalTicketPrice;
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = totalDepartureTicketPrice + returnTicketPrice;
    }

    public void setTicketNumber(int i) {
        this.ticketNumber[i] = generateTicketNumber();
    }

    public String getTicketNumber(int i) {
        return ticketNumber[i];
    }

    public void setTotalPassengers(int num1, int num2) {
        totalPassengers = num1 + num2;
    }

    public void setTotalPassengers(int num) {
        totalPassengers = num;
    }

    public void setPassengerFullName(int i, String passengerFullName) {
        this.passengerFullName[i] = passengerFullName;
    }

    public void setPassengerGender(int i, String passengerGender) {
        this.passengerGender[i] = passengerGender;
    }

    public void setPassengerAge(int i, int passengerAge) {
        this.passengerAge[i] = passengerAge;
    }

    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }

    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public void setDepartingTicketPrice(int childNum, int adultNum) {
        for (int i = 0; i < size; i++) {
            ticketNumber[i] = generateTicketNumber();
            String tempString = ticketNumber[i].substring(7, 10);
            if (tempString.equals("DOM")) {
                double temp = 300 + (0.1 * 300) + (0.05 * 300);
                if (bookingClass.equals(BookingClass.ECONOMY)) {
                    departingTicketPrice = temp + 50;
                } else if (bookingClass.equals(BookingClass.BUSINESS)) {
                    departingTicketPrice = temp + 150;
                } else if (bookingClass.equals(BookingClass.FIRST)) {
                    departingTicketPrice = temp + 250;
                }
            } else if (tempString.equals("INT")) {
                double temp = 300 + (0.15 * 300) + (0.1 * 300);
                if (bookingClass.equals(BookingClass.ECONOMY)) {
                    departingTicketPrice = temp + 50;
                } else if (bookingClass.equals(BookingClass.BUSINESS)) {
                    departingTicketPrice = temp + 150;
                } else if (bookingClass.equals(BookingClass.FIRST)) {
                    departingTicketPrice = temp + 250;
                }
                totalDepartureTicketPrice += departingTicketPrice;
            }
        }
    }

    public void setReturnTicketPrice() {
        String temp = tripType.toString();
        if (temp.equals("RETURN")) {
            this.returnTicketPrice = totalDepartureTicketPrice;
        } else {
            this.returnTicketPrice = 0;
        }
    }

    public boolean getFlag() {
        return flag;
    }

    public FlightBooking(int sizeNum) {
        this.size = sizeNum;
        this.passengerFullName = new String[size];
        this.passengerGender = new String[size];
        this.passengerAge = new int[size];
        this.ticketNumber = new String[size];
    }

    public void reserveTickets(int i) {
        this.size = i;
        this.passengerFullName = new String[size];
        this.passengerGender = new String[size];
        this.passengerAge = new int[size];
        this.ticketNumber = new String[size];
        this.arrTripSource = new TripSource[size];
        this.arrTripDestination = new TripDestination[size];
        this.arrDepartureDate = new LocalDate[size];
        this.arrReturnDate = new LocalDate[size];
        this.arrOldDate = new String[size];
        this.arrTripType = new TripType[size];
        this.arrBookingClass = new BookingClass[size];
    }

    public void setDestinationAirport(String str) {
        int temp = Integer.parseInt(str);
        switch (temp) {
            case 1:
                this.destinationAirport = DestinationAirport.Nanjing_Lukou_International_Airport;
                break;
            case 2:
                this.destinationAirport = DestinationAirport.Beijing_Capital_International_Airport;
                break;
            case 3:
                this.destinationAirport = DestinationAirport.Shanghai_Pudong_International_Airport;
                break;
            case 4:
                this.destinationAirport = DestinationAirport.Oulu_Airport;
                break;
            case 5:
                this.destinationAirport = DestinationAirport.Helsinki_Airport;
                break;
            default:
                System.out.println("Invalid number!");
        }
    }

    public void setDestinationAirport(String str1, String str2) {
        setDestinationAirport(str1);
        int temp = Integer.parseInt(str2);
        switch (temp) {
            case 1:
                this.destinationAirport = DestinationAirport.Nanjing_Lukou_International_Airport;
                break;
            case 2:
                this.destinationAirport = DestinationAirport.Beijing_Capital_International_Airport;
                break;
            case 3:
                this.destinationAirport = DestinationAirport.Shanghai_Pudong_International_Airport;
                break;
            case 4:
                this.destinationAirport = DestinationAirport.Oulu_Airport;
                break;
            case 5:
                this.destinationAirport = DestinationAirport.Helsinki_Airport;
                break;
            default:
                System.out.println("Invalid number!");
        }
    }

    public void setSourceAirport(String num) {
        int temp = Integer.parseInt(num);
        switch (temp) {
            case 1:
                this.sourceAirport = SourceAirport.Nanjing_Lukou_International_Airport;
                break;
            case 2:
                this.sourceAirport = SourceAirport.Beijing_Capital_International_Airport;
                break;
            case 3:
                this.sourceAirport = SourceAirport.Oulu_Airport;
                break;
            case 4:
                this.sourceAirport = SourceAirport.Helsinki_Airport;
                break;
            default:
                System.out.println("Invalid number!");
        }
    }

    public int getSize() {
        return size;
    }

    public TripType getArrTripType(int i) {
        return arrTripType[i];
    }
}


