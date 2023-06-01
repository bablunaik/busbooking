package com.busbooking.payload;

import lombok.Data;

@Data
public class BusDto {
    private String busNumber;
    private String type;
    private int capacity;

    // Getters and setters
}
