package dev.mhasan.ispmanage.mapper;

import dev.mhasan.ispmanage.dto.CustomerDTO;
import dev.mhasan.ispmanage.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerDtoAndEntityMapper {
    Customer customerDtoToCustomerEntity(CustomerDTO customerDTO);
    CustomerDTO customerEntityToCustomerDto(Customer customer);
}
