package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Area;
import dev.mhasan.ispmanage.response.ResponseHandler;
import dev.mhasan.ispmanage.service.IAreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/area")
@RequiredArgsConstructor
@Slf4j
public class AreaController {
    private final IAreaService areaService;
    @PostMapping
    public ResponseEntity<Object> addAnArea(@RequestBody Area area){
        if (areaService.addAnArea(area)!=null){
            log.debug("Area Added Successfully with id: {}!", area.getId());
            return ResponseHandler.generateResponse("Successfully added an Area!", HttpStatus.CREATED, area);
        }
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.BAD_REQUEST, null);
    }
    @GetMapping
    public ResponseEntity<Object> getAllArea(){
        List<Area> areas = areaService.getAllArea();
        if (!areas.isEmpty()){
            return ResponseHandler.generateResponse("ALL AREAS!", HttpStatus.OK, areas);
        }
        return ResponseHandler.generateResponse("No Area Found!", HttpStatus.NOT_FOUND, null);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getAreaById(@PathVariable Long id){
        Area area = areaService.getAreaById(id);
        if (area!=null){
            return ResponseHandler.generateResponse("Area By Id "+id, HttpStatus.CREATED, area);
        }
        return ResponseHandler.generateResponse("Area not found with Id: "+ id, HttpStatus.NOT_FOUND, null);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateAreaById(@PathVariable Long id, @RequestBody Area area){
        Area area1 = areaService.updateAreaById(id, area);
        if (area1!=null){
            log.debug("Area Updated Successfully with id: {}!", area1.getId());
            return ResponseHandler.generateResponse("Area Updated Successfully!", HttpStatus.OK, area1);
        }
        return ResponseHandler.generateResponse("Failed to update Area with id: "+ id, HttpStatus.BAD_REQUEST, null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteAreaById(@PathVariable Long id){
        if (areaService.deleteAreaById(id)){
            log.debug("Area Deleted Successfully with id: {}!", id);
            return ResponseHandler.generateResponse("Area Deleted Successfully!", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Failed to delete Area with id: "+ id, HttpStatus.BAD_REQUEST, null);
    }
}
