package com.Yassine.dev.api.termine.controller;


import com.Yassine.dev.api.termine.dto.TermineCreateRequest;
import com.Yassine.dev.api.termine.dto.TermineResponse;
import com.Yassine.dev.api.termine.dto.TermineService;
import com.Yassine.dev.api.termine.dto.TermineUpdateRequest;
import com.Yassine.dev.api.termine.enums.Status;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/termine")
public class TermineController {

    private final TermineService service;

    public TermineController(TermineService service) {
        this.service = service;
    }

    @PostMapping
    public TermineResponse create(@Valid @RequestBody TermineCreateRequest request) {
        System.out.println("========== CONTROLLER DEBUG ==========");
        System.out.println("Region: " + request.getRegion());
        System.out.println("ExactLocation: " + request.getExactLocation());
        System.out.println("Name: " + request.getName());
        System.out.println("HallOrLocation: " + request.getHallOrLocation());
        System.out.println("Occasion: " + request.getOccasion());
        System.out.println("PackageName: " + request.getPackageName());
        System.out.println("BookingType: " + request.getBookingType());
        System.out.println("Duration: " + request.getDuration());
        System.out.println("Description: " + request.getDescription());
        System.out.println("Status: " + request.getStatus());
        System.out.println("StartDate: " + request.getStartDate());
        System.out.println("EndDate: " + request.getEndDate());
        System.out.println("=====================================");

        return service.create(request);
    }

    @GetMapping
    public List<TermineResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TermineResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public TermineResponse update(@PathVariable UUID id,
                                  @RequestBody TermineUpdateRequest request) {
        return service.update(id, request);
    }

    @PatchMapping("/{id}/status")
    public TermineResponse updateStatus(@PathVariable UUID id,
                                        @RequestParam Status status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
