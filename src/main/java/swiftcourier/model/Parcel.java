package swiftcourier.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Parcel {
    private int id;
    private String trackingCode;
    private int senderId;
    private String receiverName;
    private String receiverAddress;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Parcel() {}

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTrackingCode() {
        return trackingCode;
    }
    public void setTrackingCode(String trackingCode) { this.trackingCode = trackingCode; }
    public int getSenderId() { return senderId; }
    public void setSenderId(int senderId) { this.senderId = senderId; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverAddress() { return receiverAddress; }
    public void setReceiverAddress(String receiverAddress) { this.receiverAddress = receiverAddress; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Parcel{id=" + id + ", trackingCode='" + trackingCode + "', status='" + status + "'}";
    }
}
