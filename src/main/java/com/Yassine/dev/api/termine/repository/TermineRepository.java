package com.Yassine.dev.api.termine.repository;

import com.Yassine.dev.api.termine.entity.Termine;
import com.Yassine.dev.api.termine.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TermineRepository extends JpaRepository<Termine, UUID> {
    List<Termine> findByName(Status status);

    @Query("SELECT t FROM Termine t WHERE t.status = :status AND t.updatedAt IS NOT NULL AND t.updatedAt < :cutoff")
    List<Termine> findByStatusAndLastModifiedBefore(@Param("status") Status status,
                                                    @Param("cutoff") LocalDateTime cutoff);
}
