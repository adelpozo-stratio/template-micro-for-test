package com.stratio.financial.test.infrastructure.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.stratio.financial.test.domain.Pet;
import com.stratio.financial.test.infrastructure.rest.spring.dto.PetDto;

@Mapper(componentModel = "spring")
public interface PetMapper {

  PetDto toDto(Pet source);

  Pet toDomain(PetDto source);

}
