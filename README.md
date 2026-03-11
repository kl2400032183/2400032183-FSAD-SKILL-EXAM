# 2400032183-FSAD-SKILL-EXAM

## Hibernate HQL Project

A Maven-based Hibernate project implementing Hibernate Query Language (HQL) operations on a Service entity.

### Project Structure

```
src/main/java/com/klef/fsad/exam/
├── Service.java          - Entity class with properties: ID, Name, Date, Status, Description, Cost
└── ClientDemo.java       - Demo class implementing HQL insert and update operations

src/main/resources/
└── hibernate.cfg.xml     - Hibernate configuration file
```

### Features

1. **Insert Records**: Inserts Service records using persistent objects
2. **Update Operations**: Updates Name and Status fields using HQL with named parameters
3. **Query Operations**: Retrieves and displays all services

### Database Configuration

- Database: `fsadexam`
- Driver: MySQL 8.0
- Hibernate Dialect: MySQL8Dialect

### Building and Running

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
```

### HQL Operations

- **Insert**: Uses Hibernate session.save() to persist Service objects
- **Update Name**: `UPDATE Service SET name = :name WHERE id = :id`
- **Update Status**: `UPDATE Service SET status = :status WHERE id = :id`
- **Select**: `FROM Service` to retrieve all records
