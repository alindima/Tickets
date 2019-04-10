package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;
import java.time.LocalDateTime;

public class OperaEvent extends Event {
    public OperaEvent(Location location, String name, LocalDateTime dateTime) {
        super(location, name, dateTime);
    }
}
