package com.spring_barber_shop.mapper;


import com.spring_barber_shop.controller.request.SaveScheduleRequest;
import com.spring_barber_shop.controller.response.ClientScheduleAppointmentResponse;
import com.spring_barber_shop.controller.response.SaveScheduleResponse;
import com.spring_barber_shop.controller.response.ScheduleAppointmentMonthResponse;
import com.spring_barber_shop.entity.ScheduleEntity;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = SPRING)
public interface IScheduleMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    ScheduleEntity toEntity(final SaveScheduleRequest request);

    @Mapping(target = "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity);

    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(final int year, final int month, final List<ScheduleEntity> entities);

    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<ScheduleEntity> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())")
    ClientScheduleAppointmentResponse toClientMonthResponse(final ScheduleEntity entity);
}

