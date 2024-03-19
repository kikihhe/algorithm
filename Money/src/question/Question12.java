package question;

import java.util.ArrayList;
import java.util.Date;


public class Question12 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Hotel.Guest s1 = new Hotel.Guest("aaa", 12, new Date());
        Hotel.Guest s2 = new Hotel.Guest("bbb", 123, new Date());
        Hotel.Guest s3 = new Hotel.Guest("ccc", 56, new Date());

        hotel.guests.add(s1);
        hotel.guests.add(s2);
        hotel.guests.add(s3);

        hotel.display();
    }
}

class Hotel   {
    public ArrayList<Guest> guests = new ArrayList<>();
    public static class Guest {
        public String name;
        public int roomNumber;
        public Date checkInDate;

        public Guest(String name, int roomNumber, Date checkInDate) {
            this.name = name;
            this.roomNumber = roomNumber;
            this.checkInDate = checkInDate;
        }

        @Override
        public String toString() {
            return "Guest{" +
                    "name='" + name + '\'' +
                    ", roomNumber=" + roomNumber +
                    ", checkInDate=" + checkInDate +
                    '}';
        }
    }
    public void display() {
        for (Guest g : guests) {
            System.out.println(g);
        }
    }
}
