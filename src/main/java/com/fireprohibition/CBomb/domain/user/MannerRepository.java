package com.fireprohibition.CBomb.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MannerRepository extends JpaRepository<Manner, Long> {
}
