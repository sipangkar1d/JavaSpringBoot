package com.enigma.procurement.service.impl;

import com.enigma.procurement.entity.Admin;
import com.enigma.procurement.repository.AdminRepository;
import com.enigma.procurement.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin request) {
        return adminRepository.save(request);
    }

    @Override
    public Admin update(Admin request) {
        findById(request.getId());
        return adminRepository.save(request);
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin Not Found"));
    }
}
