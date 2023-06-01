package com.busbooking.payload;

import java.time.LocalDateTime;

public class BookingDto {
    private Long userId;
    private Long busId;
    private LocalDateTime departureDateTime;
    private int seatCount;

    // Constructor, getters, and setters

    public BookingDto(Long userId, Long busId, LocalDateTime departureDateTime, int seatCount) {
        this.userId = userId;
        this.busId = busId;
        this.departureDateTime = departureDateTime;
        this.seatCount = seatCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
