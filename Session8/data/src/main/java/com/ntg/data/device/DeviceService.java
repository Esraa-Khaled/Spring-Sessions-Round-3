package com.ntg.data.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Cacheable(value = "device",key = "{#root.methodName, #p0}")
    public Device findDeviceById(Long id) {
//        Optional<Device> device = deviceRepository.findById(id);
//        if (device.isPresent()) {
//            return device.get();
//        }
        return deviceRepository.findById(id).orElseThrow();
    }

    @Cacheable(value = "device", key = "{#root.methodName}")
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }


    public void deleteDeviceById(Long id) {
        deviceRepository.deleteById(id);
    }
}
