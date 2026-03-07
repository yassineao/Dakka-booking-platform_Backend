package com.Yassine.dev.api.termine.mapper;


import com.Yassine.dev.api.termine.dto.TermineCreateRequest;
import com.Yassine.dev.api.termine.dto.TermineResponse;
import com.Yassine.dev.api.termine.dto.TermineUpdateRequest;
import com.Yassine.dev.api.termine.entity.Termine;

public class TermineMapper {
    public static TermineResponse toResponse(Termine termine) {
        TermineResponse r = new TermineResponse();

        r.setId(termine.getId());
        r.setRegion(termine.getRegion());
        r.setExactLocation(termine.getExactLocation());

        r.setName(termine.getName());
        r.setHallOrLocation(termine.getHallOrLocation());

        r.setOccasion(termine.getOccasion());
        r.setPackageName(termine.getPackageName());
        r.setBookingType(termine.getBookingType());
        r.setDuration(termine.getDuration());

        r.setDescription(termine.getDescription());
        r.setStatus(termine.getStatus());

        r.setCreatedAt(termine.getCreatedAt());
        r.setUpdatedAt(termine.getUpdatedAt());

        return r;
    }

    public static Termine toEntity(TermineCreateRequest request) {
        Termine termine = new Termine();

        termine.setRegion(request.getRegion());
        termine.setExactLocation(request.getExactLocation());

        termine.setName(request.getName());
        termine.setHallOrLocation(request.getHallOrLocation());

        termine.setOccasion(request.getOccasion());
        termine.setPackageName(request.getPackageName());
        termine.setBookingType(request.getBookingType());
        termine.setDuration(request.getDuration());

        termine.setDescription(request.getDescription());
        termine.setStatus(request.getStatus());

        return termine;
    }
    public static void updateEntity(TermineUpdateRequest request, Termine termine) {

        if (request.getRegion() != null) {
            termine.setRegion(request.getRegion());
        }

        if (request.getExactLocation() != null) {
            termine.setExactLocation(request.getExactLocation());
        }

        if (request.getName() != null) {
            termine.setName(request.getName());
        }

        if (request.getHallOrLocation() != null) {
            termine.setHallOrLocation(request.getHallOrLocation());
        }

        if (request.getOccasion() != null) {
            termine.setOccasion(request.getOccasion());
        }

        if (request.getPackageName() != null) {
            termine.setPackageName(request.getPackageName());
        }

        if (request.getBookingType() != null) {
            termine.setBookingType(request.getBookingType());
        }

        if (request.getDuration() != null) {
            termine.setDuration(request.getDuration());
        }

        if (request.getDescription() != null) {
            termine.setDescription(request.getDescription());
        }

        if (request.getStatus() != null) {
            termine.setStatus(request.getStatus());
        }
    }
}
