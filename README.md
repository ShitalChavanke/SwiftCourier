# Swift Courier - Backend (Java, JDBC, SQL)

## Overview
`Swift Courier` is a simple courier management backend project that demonstrates
basic courier booking, tracking and delivery update workflows using Java, JDBC and SQL.

This repository contains:
- Java source code that uses JDBC to connect to a relational database (MySQL).
- SQL schema and sample data.
- Instructions to compile and run.

## Tech Stack
- Java (SE)
- JDBC (Java Database Connectivity)
- MySQL (or any relational DB; update JDBC URL/credentials accordingly)

## Files
- `src/` : Java source files
- `sql/schema.sql` : DDL for tables and sample data
- `pom.xml` (optional) : Example Maven file (not fully configured)

## Setup (MySQL example)
1. Install MySQL and create a database, e.g. `swift_courier_db`.
2. Run `sql/schema.sql` to create tables and sample data:
   ```
   mysql -u root -p swift_courier_db < sql/schema.sql
   ```
3. Download MySQL JDBC driver (Connector/J) and add it to your classpath.
4. Update DB connection settings in `src/config/DBConnection.java`.
5. Compile:
   ```
   javac -d out -sourcepath src $(find src -name "*.java")
   ```
6. Run:
   ```
   java -cp out:PATH_TO_MYSQL_CONNECTOR_JAR com.swiftcourier.SwiftCourierApplication
   ```

## Notes
- This is a simple educational backend focusing on core JDBC usage and modular structure.
- For production-ready apps, consider frameworks (Spring Boot), password hashing, validation,
  connection pooling (HikariCP), and proper error handling.
