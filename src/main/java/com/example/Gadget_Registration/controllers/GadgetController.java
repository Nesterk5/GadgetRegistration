package com.example.Gadget_Registration.controllers;

import com.example.Gadget_Registration.gadget.Gadgets;
import com.example.Gadget_Registration.services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gadgets")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    public List<Gadgets> getAllGadgets(){
        return gadgetService.getAllGadgets();
    }

    @GetMapping("/{id}")
    public Gadgets getGadgetById(@PathVariable int id) {
        return gadgetService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> addGadget(@PathVariable int userId, @RequestBody Gadgets gadget) {
        Gadgets savedGadget = gadgetService.saveGadget(gadget, userId);
        if (savedGadget == null) {
            return ResponseEntity.badRequest().body("Gadget already exists with this productId or deviceId");
        }
        return ResponseEntity.ok("Gadget registered successfully");
    }

//    @PostMapping("/upload")
//    public void uploadGadgets(@RequestParam("file") MultipartFile file) {
//        gadgetService.saveGadgetsFromCsv(file);
//    }

}
