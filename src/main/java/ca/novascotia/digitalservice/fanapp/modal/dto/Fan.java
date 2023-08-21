package ca.novascotia.digitalservice.fanapp.modal.dto;

import ca.novascotia.digitalservice.fanapp.custominterface.ValidSpeed;
import ca.novascotia.digitalservice.fanapp.modal.core.Direction;
import ca.novascotia.digitalservice.fanapp.modal.core.FanStatus;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Fan {

    Long id;
    @ValidSpeed
    private int speed = 0;
    @NotNull
    private Direction direction = Direction.CLOCKWISE;
    @NotNull
    private FanStatus status = FanStatus.OFF;
}
