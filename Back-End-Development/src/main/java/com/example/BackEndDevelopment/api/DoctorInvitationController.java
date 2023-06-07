package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.service.DoctorInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorInvitationController {

    @Autowired
    private DoctorInvitationService doctorInvitationService;

    //@PreAuthorize("hasRole(User)")
    @GetMapping({"/addToInvitationList/{id}"})
    public Doctor_Invitation addToInvitationList(@PathVariable(name = "id") Long doctorId){
        return doctorInvitationService.addToInvitationList(doctorId);
    }

}
