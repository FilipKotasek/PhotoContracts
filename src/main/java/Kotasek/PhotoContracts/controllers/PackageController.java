package Kotasek.PhotoContracts.controllers;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/packages")
    public List<PackageDTO> getAllPackages() {

        return packageService.getAllPackages();
    }

    @GetMapping("/package/{id}")
    public PackageDTO getPackage(@PathVariable Long id) {
        return packageService.getPackage(id);
    }


    @PutMapping("package/{id}")
    public  PackageDTO editPackage(@PathVariable Long id, @RequestBody PackageDTO newData) {

    return packageService.editPackage(id,newData);

    }

    @GetMapping("/packages/{limit}")
    public List<PackageDTO> getFilteredPackages(@PathVariable int limit) {
        return packageService.getFilteredPackages(limit);
    }





}
