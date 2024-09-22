package com.ntg.data.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @PostMapping
    Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @GetMapping("/{deviceId}")
    Device getDeviceById(Long id) {
        return deviceService.findDeviceById(id);
    }

    @GetMapping("")
    List<Device> getAllDevices() {
        return deviceService.getAll();
    }

    @DeleteMapping("/{id}")
    void deleteDeviceById(@PathVariable Long id) {
        deviceService.deleteDeviceById(id);
    }
}
