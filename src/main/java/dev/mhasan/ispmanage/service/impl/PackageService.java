package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.ServicePackage;
import dev.mhasan.ispmanage.repository.ServicePackageRepository;
import dev.mhasan.ispmanage.service.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService implements IPackageService {
    @Autowired
    private ServicePackageRepository servicePackageRepository;
    @Override
    public ServicePackage getServicePackageById(Long id) {
        return servicePackageRepository.findById(id).isPresent()?servicePackageRepository.findById(id).get():null;
    }

    @Override
    public List<ServicePackage> getAllServicePackage() {
        return servicePackageRepository.findAll();
    }
}
