package ca.novascotia.digitalservice.fanapp.modal.entity;

import ca.novascotia.digitalservice.fanapp.modal.core.Direction;
import ca.novascotia.digitalservice.fanapp.modal.core.FanStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import java.util.Objects;

@Entity
@Table(name = "fan")
@Getter
@Setter
@ToString
public class FanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int speed=0;

    @Enumerated(EnumType.STRING)
    private Direction direction= Direction.CLOCKWISE;

    @Enumerated(EnumType.STRING)
    private FanStatus status= FanStatus.OFF;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FanEntity fanEntity = (FanEntity) o;
        return id != null && Objects.equals(id, fanEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
