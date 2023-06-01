package com.busbooking.service;
import com.busbooking.entities.Booking;
import com.busbooking.entities.User;
import com.busbooking.entities.Bus;
import com.busbooking.payload.BookingDto;
import com.busbooking.repositories.BookingRepository;
import com.busbooking.repositories.UserRepository;
import com.busbooking.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final BusRepository busRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, BusRepository busRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.busRepository = busRepository;
    }

    public Booking makeBooking(BookingDto bookingDto, String email) {
        // Retrieve user and bus based on the provided IDs
        User user = userRepository.findById(bookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Bus bus = busRepository.findById(bookingDto.getBusId())
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        // Create a new booking entity
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBus(bus);
        booking.setDepartureDateTime(bookingDto.getDepartureDateTime());
        booking.setSeatCount(bookingDto.getSeatCount());

        // Save the booking entity in the database
        return bookingRepository.save(booking);
    }
    public Booking getBookingById(Long bookingId, String email) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        return bookingOptional.orElseThrow(() -> new RuntimeException("Booking not found"));
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public Booking updateBooking(Long bookingId, BookingDto bookingDto, String email) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        Booking booking = bookingOptional.orElseThrow(() -> new RuntimeException("Booking not found"));

        // Retrieve user and bus based on the provided IDs
        User user = userRepository.findById(bookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Bus bus = busRepository.findById(bookingDto.getBusId())
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        // Update the booking details
        booking.setUser(user);
        booking.setBus(bus);
        booking.setDepartureDateTime(bookingDto.getDepartureDateTime());
        booking.setSeatCount(bookingDto.getSeatCount());

        // Save the updated booking entity in the database
        return bookingRepository.save(booking);
    }
    public void cancelBooking(Long bookingId, String email) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        Booking booking = bookingOptional.orElseThrow(() -> new RuntimeException("Booking not found"));

        // Perform cancellation logic if required
        // For example, updating the booking status to canceled, releasing the booked seats, etc.

        // Delete the booking from the database
        bookingRepository.delete(booking);
    }


    // Other methods for managing bookings, such as getting bookings by user, cancelling bookings, etc.
}
