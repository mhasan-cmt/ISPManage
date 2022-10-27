package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.Area;
import dev.mhasan.ispmanage.repository.AreaRepository;
import dev.mhasan.ispmanage.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {
    @Autowired
    private AreaRepository areaRepository;
    @Override
    public Area getAreaById(Long id) {
        return areaRepository.findById(id).isPresent()?areaRepository.findById(id).get():null;
    }

    @Override
    public List<Area> getAllArea() {
        return areaRepository.findAll();
    }

    @Override
    public Area addAnArea(Area area) {
        return areaRepository.save(area);
    }
}
