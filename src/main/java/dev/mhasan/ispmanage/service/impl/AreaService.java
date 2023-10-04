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

    @Override
    public Area updateAreaById(Long id, Area area) {
        Area area1 = areaRepository.findById(id).isPresent()?areaRepository.findById(id).get():null;
        if (area1!=null){
            area1.setName(area.getName());
            return areaRepository.save(area1);
        }
        return null;
    }

    @Override
    public boolean deleteAreaById(Long id) {
        Area area = areaRepository.findById(id).isPresent()?areaRepository.findById(id).get():null;
        if (area!=null){
            areaRepository.delete(area);
            return true;
        }
        return false;
    }
}
