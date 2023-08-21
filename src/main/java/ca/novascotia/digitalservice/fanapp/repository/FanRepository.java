package ca.novascotia.digitalservice.fanapp.repository;

import ca.novascotia.digitalservice.fanapp.modal.entity.FanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FanRepository extends JpaRepository<FanEntity, Long> {

    Optional<FanEntity> findFirstByOrderByIdAsc();

}
