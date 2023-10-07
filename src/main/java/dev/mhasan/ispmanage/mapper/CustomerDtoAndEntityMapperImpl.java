package dev.mhasan.ispmanage.mapper;

import dev.mhasan.ispmanage.dto.CustomerDTO;
import dev.mhasan.ispmanage.entity.Area;
import dev.mhasan.ispmanage.entity.Customer;
import dev.mhasan.ispmanage.entity.Lineman;
import dev.mhasan.ispmanage.entity.ServicePackage;
import dev.mhasan.ispmanage.service.IAreaService;
import dev.mhasan.ispmanage.service.ICustomerService;
import dev.mhasan.ispmanage.service.ILinemanService;
import dev.mhasan.ispmanage.service.IPackageService;
import dev.mhasan.ispmanage.service.impl.AreaService;
import dev.mhasan.ispmanage.service.impl.CustomerService;
import dev.mhasan.ispmanage.service.impl.LinemanService;
import dev.mhasan.ispmanage.service.impl.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class CustomerDtoAndEntityMapperImpl implements CustomerDtoAndEntityMapper {
    private final CustomerService customerService;
    private final PackageService packageService;
    private final LinemanService linemanService;

    private AreaService areaService;

    @Override
    public Customer customerDtoToCustomerEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        Customer customer = new Customer();
        if (customerDTO.getId() != null) {
            customer = customerService.getCustomerById(customerDTO.getId());
        }
        customer.setName(customerDTO.getName());
        customer.setMobile(customerDTO.getMobile());
        customer.setConnectionId(customerDTO.getConnectionId());
        customer.setConnectionPass(customerDTO.getConnectionPass());
        customer.setJoinDate(customerDTO.getJoinDate());
        customer.setEmail(customerDTO.getEmail());
        customer.setRole(customerDTO.getRole());
        ServicePackage servicePackage = packageService.getServicePackageById(customerDTO.getServicePackageId());
        Lineman lineman = linemanService.getLinemanById(customerDTO.getLinemanId());
        Area area = areaService.getAreaById(customerDTO.getAreaId());
        customer.setServicePackage(servicePackage);
        customer.setLineman(lineman);
        customer.setArea(area);

        return customer;
    }

    @Override
    public CustomerDTO customerEntityToCustomerDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setMobile(customer.getMobile());
        customerDTO.setServicePackageId(customer.getServicePackage().getId());
        customerDTO.setAreaId(customer.getArea().getId());
        customerDTO.setLinemanId(customer.getLineman().getId());
        customerDTO.setConnectionId(customer.getConnectionId());
        customerDTO.setConnectionPass(customer.getConnectionPass());
        customerDTO.setJoinDate(customer.getJoinDate());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setRole(customer.getRole());
        return customerDTO;
    }
}
