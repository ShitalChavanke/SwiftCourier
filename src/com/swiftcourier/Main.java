package com.swiftcourier;

import com.swiftcourier.model.Parcel;
import com.swiftcourier.model.User;
import com.swiftcourier.service.CourierService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourierService svc = new CourierService();
        try {
            // register a user
            User u = new User();
            u.setName("Test Sender");
            u.setEmail("testsender@example.com");
            u.setPhone("+919999999999");
            u = svc.registerUser(u);
            System.out.println("Registered user: " + u);

            // book a parcel
            Parcel p = new Parcel();
            p.setSenderId(u.getId());
            p.setReceiverName("Receiver Name");
            p.setReceiverAddress("100, Example Street, City");
            p.setStatus("REGISTERED");
            p = svc.bookParcel(p);
            System.out.println("Booked parcel: " + p);

            // list parcels
            List<Parcel> parcels = svc.listParcels();
            System.out.println("All parcels:");
            parcels.forEach(System.out::println);

            // fetch by tracking code
            Parcel fetched = svc.getParcelByTracking(p.getTrackingCode());
            System.out.println("Fetched by tracking: " + fetched);

            // update status
            boolean updated = svc.updateParcelStatus(p.getTrackingCode(), "OUT_FOR_DELIVERY");
            System.out.println("Status updated: " + updated);

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
