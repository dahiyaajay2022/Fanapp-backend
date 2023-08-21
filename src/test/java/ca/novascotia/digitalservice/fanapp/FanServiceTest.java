package ca.novascotia.digitalservice.fanapp;

import ca.novascotia.digitalservice.fanapp.mappers.FanMapper;
import ca.novascotia.digitalservice.fanapp.modal.core.Direction;
import ca.novascotia.digitalservice.fanapp.modal.dto.Fan;
import ca.novascotia.digitalservice.fanapp.modal.entity.FanEntity;
import ca.novascotia.digitalservice.fanapp.repository.FanRepository;
import ca.novascotia.digitalservice.fanapp.services.FanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class FanServiceTest {

    @Mock
    private FanRepository fanRepository;

    @Mock
    private FanMapper fanMapper;

    @InjectMocks
    private FanService fanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPullSpeedCord_HappyPath() {
        FanEntity mockFanEntity = new FanEntity();
        mockFanEntity.setSpeed(0);

        Fan mockFanDTO = new Fan();
        mockFanDTO.setSpeed(1);

        when(fanRepository.findFirstByOrderByIdAsc()).thenReturn(java.util.Optional.of(mockFanEntity));
        when(fanMapper.fanEntityToFan(any(FanEntity.class))).thenReturn(mockFanDTO);

        Fan result = fanService.pullSpeedCord();

        assertThat(result.getSpeed()).isEqualTo(1);
    }

    @Test
    void testPullDirectionCord_HappyPath() {
        FanEntity mockFanEntity = new FanEntity();
        mockFanEntity.setDirection(Direction.CLOCKWISE);

        Fan mockFanDTO = new Fan();
        mockFanDTO.setDirection(Direction.COUNTERCLOCKWISE);

        when(fanRepository.findFirstByOrderByIdAsc()).thenReturn(java.util.Optional.of(mockFanEntity));
        when(fanMapper.fanEntityToFan(any(FanEntity.class))).thenReturn(mockFanDTO);

        Fan result = fanService.pullDirectionCord();

        assertThat(result.getDirection()).isEqualTo(Direction.COUNTERCLOCKWISE);
    }

    // Add more tests for other methods, and failure scenarios as well
}

