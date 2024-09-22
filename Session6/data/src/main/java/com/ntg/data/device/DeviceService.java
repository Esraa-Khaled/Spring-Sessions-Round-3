package com.ntg.data.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long id) {
//        Optional<Device> device = deviceRepository.findById(id);
//        if (device.isPresent()) {
//            return device.get();
//        }
        return deviceRepository.findById(id).orElseThrow();
    }

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    public void deleteDeviceById(Long id) {
        deviceRepository.deleteById(id);
    }
}
