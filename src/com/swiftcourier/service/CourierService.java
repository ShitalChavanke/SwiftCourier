package com.swiftcourier.service;

import com.swiftcourier.dao.ParcelDAO;
import com.swiftcourier.dao.UserDAO;
import com.swiftcourier.model.Parcel;
import com.swiftcourier.model.User;

import java.sql.SQLException;
import java.util.List;

public class CourierService {
    private final UserDAO userDao = new UserDAO();
    private final ParcelDAO parcelDao = new ParcelDAO();

    public User registerUser(User u) throws SQLException {
        return userDao.create(u);
    }

    public Parcel bookParcel(Parcel p) throws SQLException {
        // generate simple tracking code if not provided
        if (p.getTrackingCode() == null || p.getTrackingCode().isEmpty()) {
            p.setTrackingCode("SWFT" + System.currentTimeMillis());
        }
        return parcelDao.create(p);
    }

    public Parcel getParcelByTracking(String code) throws SQLException {
        return parcelDao.findByTrackingCode(code);
    }

    public List<Parcel> listParcels() throws SQLException {
        return parcelDao.findAll();
    }

    public boolean updateParcelStatus(String trackingCode, String newStatus) throws SQLException {
        return parcelDao.updateStatus(trackingCode, newStatus);
    }
}
