package org.halx.listMyStuffs.repository;

import org.halx.listMyStuffs.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Long> {

}
