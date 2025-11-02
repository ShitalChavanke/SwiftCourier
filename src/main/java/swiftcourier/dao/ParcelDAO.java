package swiftcourier.dao;

import swiftcourier.config.DBConnection;
import swiftcourier.model.Parcel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelDAO {
    public Parcel create(Parcel p) throws SQLException {
        String sql = "INSERT INTO parcels (tracking_code, sender_id, receiver_name, receiver_address, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getTrackingCode());
            ps.setInt(2, p.getSenderId());
            ps.setString(3, p.getReceiverName());
            ps.setString(4, p.getReceiverAddress());
            ps.setString(5, p.getStatus());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getInt(1));
            }
        }
        return p;
    }

    public Parcel findByTrackingCode(String code) throws SQLException {
        String sql = "SELECT * FROM parcels WHERE tracking_code = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Parcel p = new Parcel();
                    p.setId(rs.getInt("id"));
                    p.setTrackingCode(rs.getString("tracking_code"));
                    p.setSenderId(rs.getInt("sender_id"));
                    p.setReceiverName(rs.getString("receiver_name"));
                    p.setReceiverAddress(rs.getString("receiver_address"));
                    p.setStatus(rs.getString("status"));
                    p.setCreatedAt(rs.getTimestamp("created_at"));
                    p.setUpdatedAt(rs.getTimestamp("updated_at"));
                    return p;
                }
            }
        }
        return null;
    }

    public List<Parcel> findAll() throws SQLException {
        String sql = "SELECT * FROM parcels";
        List<Parcel> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Parcel p = new Parcel();
                p.setId(rs.getInt("id"));
                p.setTrackingCode(rs.getString("tracking_code"));
                p.setSenderId(rs.getInt("sender_id"));
                p.setReceiverName(rs.getString("receiver_name"));
                p.setReceiverAddress(rs.getString("receiver_address"));
                p.setStatus(rs.getString("status"));
                p.setCreatedAt(rs.getTimestamp("created_at"));
                p.setUpdatedAt(rs.getTimestamp("updated_at"));
                list.add(p);
            }
        }
        return list;
    }

    public boolean updateStatus(String trackingCode, String newStatus) throws SQLException {
        String sql = "UPDATE parcels SET status = ? WHERE tracking_code = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setString(2, trackingCode);
            return ps.executeUpdate() > 0;
        }
    }
}
