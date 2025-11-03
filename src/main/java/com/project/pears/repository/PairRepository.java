package com.project.pears.repository;

import com.project.pears.entity.Pair;
import com.project.pears.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairRepository extends JpaRepository<Pair, Long> {
}
