package com.musalasoft.dispatchservice.respository;

import com.musalasoft.dispatchservice.entity.EventLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

}
