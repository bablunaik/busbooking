package com.busbooking.service;
import com.busbooking.entities.Bus;
import com.busbooking.payload.BusDto;
import com.busbooking.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    private final BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus addBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setType(busDto.getType());
        bus.setCapacity(busDto.getCapacity());

        return busRepository.save(bus);
    }

    public Bus updateBus(Long busId, BusDto busDto) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        bus.setBusNumber(busDto.getBusNumber());
        bus.setType(busDto.getType());
        bus.setCapacity(busDto.getCapacity());

        return busRepository.save(bus);
    }

    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }
    public Bus getBusById(Long busId) {
        Optional<Bus> busOptional = busRepository.findById(busId);
        return busOptional.orElseThrow(() -> new RuntimeException("Bus not found"));
    }
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Other methods for bus listing, searching, etc.
}
