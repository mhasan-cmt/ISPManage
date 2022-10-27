package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Area;
import dev.mhasan.ispmanage.response.ResponseHandler;
import dev.mhasan.ispmanage.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AreaController {

    @Autowired
    private IAreaService areaService;
    @PostMapping("/area")
    public ResponseEntity<Object> addAnArea(@RequestBody Area area){
        if (areaService.addAnArea(area)!=null){
            return ResponseHandler.generateResponse("Successfully added an Area!", HttpStatus.OK, area);
        }
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/area")
    public ResponseEntity<Object> getAllArea(){
        List<Area> areas = areaService.getAllArea();
        if (!areas.isEmpty()){
            return ResponseHandler.generateResponse("ALL AREAS!", HttpStatus.OK, areas);
        }
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/area/single")
    public ResponseEntity<Object> getAreaById(@RequestParam Long id){
        Area area = areaService.getAreaById(id);
        if (area!=null){
            return ResponseHandler.generateResponse("Area By Id "+id, HttpStatus.OK, area);
        }
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
}
