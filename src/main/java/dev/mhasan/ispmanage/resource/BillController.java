package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Bill;
import dev.mhasan.ispmanage.entity.Lineman;
import dev.mhasan.ispmanage.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class BillController {
    @PostMapping("/bill")
    public ResponseEntity<Object> addAnArea(Bill bill){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/bill")
    public ResponseEntity<Object> getAllArea(){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
    @GetMapping("/bill/{id}")
    public ResponseEntity<Object> getAreaById(@PathVariable String id){
        return ResponseHandler.generateResponse("Failed to add an Area!", HttpStatus.MULTI_STATUS, null);
    }
}
