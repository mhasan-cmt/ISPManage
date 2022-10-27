package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.Lineman;

import java.util.List;

public interface ILinemanService {
    Lineman getLinemanById(Long id);
    List<Lineman> getAllLineman();
}
