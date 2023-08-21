package ca.novascotia.digitalservice.fanapp.mappers;

import ca.novascotia.digitalservice.fanapp.modal.dto.Fan;
import ca.novascotia.digitalservice.fanapp.modal.entity.FanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FanMapper {
    Fan fanEntityToFan(FanEntity fanEntity);

    FanEntity fanToFanEntity(Fan fanDTO);
}
