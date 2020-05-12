package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.model.service.facade.ModuleService;

@RestController
@RequestMapping("exam-api/modules")
public class ModuleRest {

	 @Autowired
	 ModuleService moduleService;

	@GetMapping("/find-by-libelle/{libelle}")
	public Module findByLibelle(@PathVariable String libelle) {
		return moduleService.findByLibelle(libelle);
	}

	@DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return moduleService.deleteByLibelle(libelle);
	}

	@GetMapping("/find-by-filiere/{libelle}")
	public List<Module> findByFiliereLibelle(@PathVariable String libelle) {
		return moduleService.findByFiliereLibelle(libelle);
	}

	@DeleteMapping("delete-by-filiere/{libelle}")
	public int deleteByFiliereLibelle(@PathVariable String libelle) {
		return moduleService.deleteByFiliereLibelle(libelle);
	}

	@GetMapping("/find-all")
	public List<Module> findAll() {
		return moduleService.findAll();
	}

	@PostMapping("/add-module/")
	public int addModule(@RequestBody Module module) {
		return moduleService.addModule(module);
	}
	 
	 
}
