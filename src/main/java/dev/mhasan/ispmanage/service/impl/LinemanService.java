package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.Lineman;
import dev.mhasan.ispmanage.repository.LinemanRepository;
import dev.mhasan.ispmanage.service.ILinemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinemanService implements ILinemanService {
    @Autowired
    private LinemanRepository linemanRepository;
    @Override
    public Lineman getLinemanById(Long id) {
        return linemanRepository.findById(id).isPresent()?linemanRepository.findById(id).get():null;
    }

    @Override
    public List<Lineman> getAllLineman() {
        return linemanRepository.findAll();
    }
}
