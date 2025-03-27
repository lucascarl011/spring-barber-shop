package com.spring_barber_shop.mapper;


import com.spring_barber_shop.controller.request.SaveClientRequest;
import com.spring_barber_shop.controller.request.UpdateClientRequest;
import com.spring_barber_shop.controller.response.ClientDetailResponse;
import com.spring_barber_shop.controller.response.ListClientResponse;
import com.spring_barber_shop.controller.response.SaveClientResponse;
import com.spring_barber_shop.controller.response.UpdateClientResponse;
import com.spring_barber_shop.entity.ClientEntity;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
