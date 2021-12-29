package com.musalasoft.dispatchservice.service.jobs;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.musalasoft.dispatchservice.entity.Drone;
import com.musalasoft.dispatchservice.entity.EventLog;
import com.musalasoft.dispatchservice.model.enums.DroneState;
import com.musalasoft.dispatchservice.respository.DroneRepository;
import com.musalasoft.dispatchservice.respository.EventLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DroneHealthEngine {

    private final EventLogRepository eventLogRepository;
    private final DroneRepository droneRepository;

    @Autowired
    public DroneHealthEngine(EventLogRepository eventLogRepository, DroneRepository droneRepository) {
        this.eventLogRepository = eventLogRepository;
        this.droneRepository = droneRepository;
    }

    static final Logger LOGGER = Logger.getLogger(DroneHealthEngine.class.getName());

    @Scheduled(fixedDelayString = "${schedule.interval}")
    public void process() throws InterruptedException {
        String message = "Process Successful";
        Boolean status = true;
        EventLog eventLog = new EventLog();

        LOGGER.info("drone engine running at " +
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        try {
            List<Drone> drones = droneRepository.findAll();
            List<Drone> modifiedDrones = new ArrayList<Drone>();

            drones.forEach(it -> {
                if (it.getBatteryCapacity() < 25) {
                    it.setState(DroneState.INACTIVE);
                    modifiedDrones.add(it);
                }
            });

            droneRepository.saveAll(modifiedDrones);

        } catch (Exception ex) {
            message = ex.getMessage();
            status = false;
        } finally {
            eventLog.setRemarks(message);
            eventLog.setStatus(status);
            eventLogRepository.save(eventLog);
        }

        Thread.sleep(4000);
    }
}
