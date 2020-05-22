package com.stratio.financial.test.infrastructure.rest.spring.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stratio.financial.test.application.service.PetService;
import com.stratio.financial.test.infrastructure.rest.spring.spec.PetApi;
import com.stratio.financial.test.infrastructure.rest.spring.dto.PetDto;
import com.stratio.financial.test.infrastructure.rest.spring.mapper.PetMapper;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = {"pet"})
public class PetApiResource implements PetApi {

  private final PetService petService;

  private final PetMapper petMapper;

  @Override
  public ResponseEntity<List<PetDto>> findPetsByStatus(@RequestParam List<String> status) {

    List<PetDto> petsByStatus = petService
        .findAllByStatus(status).stream()
        .map(petMapper::toDto)
        .collect(Collectors.toList());

    return new ResponseEntity<>(petsByStatus, HttpStatus.OK);
  }

}
