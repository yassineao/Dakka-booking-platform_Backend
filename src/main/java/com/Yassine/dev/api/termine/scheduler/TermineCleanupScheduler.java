package com.Yassine.dev.api.termine.scheduler;

import com.Yassine.dev.api.termine.entity.Termine;
import com.Yassine.dev.api.termine.enums.Status;
import com.Yassine.dev.api.termine.repository.TermineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TermineCleanupScheduler {

    private static final Logger log = LoggerFactory.getLogger(TermineCleanupScheduler.class);

    private final TermineRepository repository;

    public TermineCleanupScheduler(TermineRepository repository) {
        this.repository = repository;
    }

    // Runs every day at midnight
    @Scheduled(cron = "0 0 0 * * *")
    public void deleteStaleStorniertTermine() {
        LocalDateTime cutoff = LocalDateTime.now().minusWeeks(2);
        List<Termine> stale = repository.findByStatusAndLastModifiedBefore(Status.STORNIERT, cutoff);
        if (!stale.isEmpty()) {
            repository.deleteAll(stale);
            log.info("Deleted {} stornierte Termine older than 2 weeks.", stale.size());
        }
    }
}
