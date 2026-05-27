# Vacation Booking Backend Application

This project is a Java Spring Boot backend for a vacation booking application. It uses Spring Data JPA, Spring Data REST, MySQL, and Lombok to manage customers, carts, cart items, vacations, excursions, countries, and divisions.

The main feature is a checkout flow that accepts purchase data from an Angular frontend, persists the customer/cart relationship, generates a UUID-based order tracking number, and returns the confirmation to the client.

## Highlights

- Built RESTful backend services with Java and Spring Boot
- Integrated Spring Data JPA with a MySQL database
- Implemented checkout logic using transactional service methods
- Generated order tracking numbers for completed purchases
- Exposed customer, vacation, excursion, country, and division resources for frontend use
