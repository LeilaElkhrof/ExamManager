package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Responsabilite;
import com.fstg.gestion.exams.model.service.facade.ResponsabiliteService;

@RestController
@RequestMapping("exam-api/responsabilites")
@CrossOrigin(origins= {"http://localhost:4200" })
public class ResponsabiliteRest  {

	@Autowired
	ResponsabiliteService respoService;

	@GetMapping("/find-by-libelle/{libelle}")
	public Responsabilite findByLibelle(@PathVariable String libelle) {
		return respoService.findByLibelle(libelle);
	}

	@DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return respoService.deleteByLibelle(libelle);
	}

	@PostMapping("/save")
	public int save(@RequestBody Responsabilite respo) {
		return respoService.save(respo);
	}

	@GetMapping("/find-all")
	public List<Responsabilite> findAll() {
		return respoService.findAll();
	}

	@PutMapping("/{id}/{libelle}")
	public Responsabilite update(@PathVariable Long id,@PathVariable String libelle) {
		return respoService.update(id,libelle);
	}
}
