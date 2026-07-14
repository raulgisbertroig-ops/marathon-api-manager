package com.marathon.api.repository;

import com.marathon.api.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository <Runner, Long> {
}

