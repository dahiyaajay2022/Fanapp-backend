package ca.novascotia.digitalservice.fanapp.services;

import ca.novascotia.digitalservice.fanapp.mappers.FanMapper;
import ca.novascotia.digitalservice.fanapp.modal.core.Direction;
import ca.novascotia.digitalservice.fanapp.modal.core.FanStatus;
import ca.novascotia.digitalservice.fanapp.modal.dto.Fan;
import ca.novascotia.digitalservice.fanapp.modal.entity.FanEntity;
import ca.novascotia.digitalservice.fanapp.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FanService {

    private final FanRepository fanRepository;
    private final FanMapper fanMapper;

    @Autowired
    public FanService(FanRepository fanRepository, FanMapper fanMapper) {
        this.fanRepository = fanRepository;
        this.fanMapper = fanMapper;
    }

    public Fan pullSpeedCord() {
        FanEntity fanEntity = fanRepository.findFirstByOrderByIdAsc().orElseGet(FanEntity::new);
        int newSpeed = (fanEntity.getSpeed() + 1) % 4;
        fanEntity.setSpeed(newSpeed);
        // Set status based on speed
        if(newSpeed == 0) {
            fanEntity.setStatus(FanStatus.OFF);
        } else {
            fanEntity.setStatus(FanStatus.ON);
        }
        fanRepository.save(fanEntity);
        return fanMapper.fanEntityToFan(fanEntity);
    }

    public Fan pullDirectionCord() {
        FanEntity fanEntity = fanRepository.findFirstByOrderByIdAsc().orElseGet(FanEntity::new);
        if(fanEntity.getSpeed() == 0) {
            fanEntity.setStatus(FanStatus.OFF);
            fanRepository.save(fanEntity);
            return fanMapper.fanEntityToFan(fanEntity);
        }
        Direction newDirection = fanEntity.getDirection() == Direction.CLOCKWISE ? Direction.COUNTERCLOCKWISE : Direction.CLOCKWISE;
        fanEntity.setDirection(newDirection);
        fanRepository.save(fanEntity);
        return fanMapper.fanEntityToFan(fanEntity);
    }

    public Fan getFanStatus() {
        FanEntity fanEntity = fanRepository.findFirstByOrderByIdAsc().orElseGet(FanEntity::new);
        return fanMapper.fanEntityToFan(fanEntity);
    }

    public List<Fan> getAllFans() {
        List<FanEntity> fanEntities = fanRepository.findAll();
        return fanEntities.stream().map(fanMapper::fanEntityToFan).collect(Collectors.toList());
    }
}


