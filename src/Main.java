import java.util.Date;

class RoomBookingSystem {
    public int BookRoom(Date startDate, Date endDate, int guests) {
        return 203;
    }

    public boolean Payment(int roomNumber) {
        return true;
    }
}

class CleaningService {
    public void NotifyCleaning(Date startDate, Date endDate, int roomNumber) {
        System.out.println("Cleaning scheduled for room " + roomNumber);
    }

    public void CheckOut(Date endDate, int roomNumber) {
        System.out.println("Checked out room " + roomNumber + " on " + endDate);
    }
}

class RestaurantSystem {
    public void NotifyRestaurant(Date startDate, Date endDate, int guests) {
        System.out.println("Restaurant notified for guests from " + startDate + " to " + endDate);
    }
}

class HotelFacade {
    public void ReserveRoom(Date startDate, Date endDate, int guests) {
        RoomBookingSystem roomBookingSystem = new RoomBookingSystem();
        int roomId = roomBookingSystem.BookRoom(startDate, endDate, guests);

        if (roomBookingSystem.Payment(roomId)) {
            CleaningService cleaningService = new CleaningService();
            cleaningService.NotifyCleaning(startDate, endDate, roomId);
            cleaningService.CheckOut(endDate, roomId);

            RestaurantSystem restaurantSystem = new RestaurantSystem();
            restaurantSystem.NotifyRestaurant(startDate, endDate, guests);

            System.out.println("Room " + roomId + " successfully reserved.");
        } else {
            System.out.println("Payment failed. Room reservation not completed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HotelFacade hotel = new HotelFacade();
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 2 * 24 * 60 * 60 * 1000);
        int guests = 2;

        hotel.ReserveRoom(startDate, endDate, guests);
    }
}
