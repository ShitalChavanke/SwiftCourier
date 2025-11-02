--Db Schema
CREATE DATABASE IF NOT EXISTS swift_courier_db;
USE swift_courier_db;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) UNIQUE NOT NULL,
  phone VARCHAR(30),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS parcels (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tracking_code VARCHAR(50) UNIQUE NOT NULL,
  sender_id INT NOT NULL,
  receiver_name VARCHAR(100) NOT NULL,
  receiver_address TEXT NOT NULL,
  status VARCHAR(30) NOT NULL DEFAULT 'REGISTERED',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE
);

--// Sample data//
INSERT INTO users (name, email, phone) VALUES
('Rahul Patil', 'rahul@abc.com', '+919000000011'),
('Ananya Sahane', 'ananya@abc.com', '+919000000012');

INSERT INTO parcels (tracking_code, sender_id, receiver_name, receiver_address, status) VALUES
('SWFT000001', 1, 'Neha Raikar', '12, MG Road, Pune, Maharashtra', 'IN_TRANSIT'),
('SWFT000002', 2, 'Karan Singh', '45, Park Street, Kolkata, West Bengal', 'DELIVERED');
