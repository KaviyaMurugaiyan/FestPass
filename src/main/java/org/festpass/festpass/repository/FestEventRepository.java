package org.festpass.festpass.repository;

import org.festpass.festpass.entity.FestEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestEventRepository extends JpaRepository<FestEvent, Long> {
}