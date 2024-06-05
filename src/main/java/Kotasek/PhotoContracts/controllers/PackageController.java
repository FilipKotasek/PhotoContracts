package Kotasek.PhotoContracts.controllers;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PackageController {


    @Autowired
    PackageService packageService;

    @PostMapping({"/package","/package/"})
    public PackageDTO addPackage(@RequestBody PackageDTO packageDTO) {


        return packageService.addPackage(packageDTO);
    }

    @DeleteMapping("/package/{id}")
    public PackageDTO deletePackage(@PathVariable Long id){

        return packageService.deletePackage(id);

    }




}
