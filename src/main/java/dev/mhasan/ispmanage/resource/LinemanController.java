package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Area;
import dev.mhasan.ispmanage.entity.Lineman;
import dev.mhasan.ispmanage.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class LinemanController {
    @PostMapping("/lineman")
    public ResponseEntity<Object> addAnArea(Lineman lineman){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/lineman")
    public ResponseEntity<Object> getAllArea(){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/lineman/{id}")
    public ResponseEntity<Object> getAreaById(@PathVariable String id){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
}
