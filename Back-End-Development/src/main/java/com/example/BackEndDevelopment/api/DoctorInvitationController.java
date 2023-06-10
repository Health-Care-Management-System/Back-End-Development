package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.service.DoctorInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")

public class DoctorInvitationController {

    @Autowired
    private DoctorInvitationService doctorInvitationService;

    //@PreAuthorize("hasRole(User)")
    @GetMapping({"/addToInvitationList/{id}"})
    public Doctor_Invitation addToInvitationList(@PathVariable(name = "id") String doctorId){
        return doctorInvitationService.addToInvitationList(doctorId);
    }

    @GetMapping({"/getInvitationDetails"})
    public List<Doctor_Invitation> getInvitationDetails(){
        return doctorInvitationService.getInvitationDetails();
    }

}
