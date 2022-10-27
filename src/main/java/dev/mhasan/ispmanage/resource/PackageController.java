package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Lineman;
import dev.mhasan.ispmanage.entity.ServicePackage;
import dev.mhasan.ispmanage.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PackageController {
    @PostMapping("/package")
    public ResponseEntity<Object> addAnArea(ServicePackage servicePackage){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/package")
    public ResponseEntity<Object> getAllArea(){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/package/{id}")
    public ResponseEntity<Object> getAreaById(@PathVariable String id){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
}
