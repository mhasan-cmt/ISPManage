package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.Area;

import java.util.List;

public interface IAreaService {
    Area getAreaById(Long id);
    List<Area> getAllArea();
    Area addAnArea(Area area);
}
