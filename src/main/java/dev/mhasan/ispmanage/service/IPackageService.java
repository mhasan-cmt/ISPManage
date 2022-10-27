package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.ServicePackage;

import java.util.List;

public interface IPackageService {
    ServicePackage getServicePackageById(Long id);
    List<ServicePackage> getAllServicePackage();
}
