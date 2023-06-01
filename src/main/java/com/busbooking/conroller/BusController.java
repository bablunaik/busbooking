package com.busbooking.conroller;
import com.busbooking.entities.Bus;
import com.busbooking.payload.BusDto;
import com.busbooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody BusDto busDto) {
        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

    @GetMapping("/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long busId) {
        Bus bus = busService.getBusById(busId);
        return ResponseEntity.ok(bus);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    @PutMapping("/{busId}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long busId, @RequestBody BusDto busDto) {
        Bus updatedBus = busService.updateBus(busId, busDto);
        return ResponseEntity.ok(updatedBus);
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<?> deleteBus(@PathVariable Long busId) {
        busService.deleteBus(busId);
        return ResponseEntity.noContent().build();
    }
}

