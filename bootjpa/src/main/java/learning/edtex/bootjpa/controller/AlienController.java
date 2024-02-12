package learning.edtex.bootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import learning.edtex.bootjpa.dao.AlienRepo;
import learning.edtex.bootjpa.model.Alien;

//@Controller
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo  repo;
	
	//@RequestMapping("/")
	@GetMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
//	@RequestMapping("/addAlien")
	@GetMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
//	@RequestMapping("/getAlien")
	@GetMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showDetails.jsp");
		
		Alien alien = repo.findById(aid).orElse(new Alien());//if not present new null obj
		
		mv.addObject(alien);
		
		//checking our added methods on console itself
		
		/*System.out.println(repo.findByLang("java"));
		System.out.println(repo.findByAidGreaterThan(123));
		System.out.println(repo.findByLangSorted("java"));
		
		will work when there is already data in table*/
		
		return mv;
	}
	
/*	just testing. mistakes to be fixed
	@RequestMapping("/updateAlien")
	public String updateAlien(@RequestParam int aid,@RequestParam("aname") String newName)
	{
		String status = "updated";
		Alien alien = repo.findById(aid).orElse(new Alien());//if not present new null obj
		
		if(alien.getAname()==null)
			return "No such ID found";
		
		//Alien updatedAlien =  new Alien();
		
		//repo.delete(alien);
		
		//updatedAlien.setAid(aid);
		//updatedAlien.setAname(newName);
		
		//repo.save(updatedAlien);
		
		alien.setAname(newName);
		
		repo.save(alien);
		return "Updated";
		
	}
	*/
/* Using CrudRepo
 * No json objs
 * 
	//REST URL localhost:8080/aliens
	//using REST - we dont use any jsps we just return the data
	//data we are returning a string
	
	//when returning a string it(dispatcherServelet) expects a viewname
	//so using @ResponseBody we are informing that we are not returning a viewname
	//we are returning data print as it is
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens()
	{
		return repo.findAll().toString();
		//findAll returns an iterable so convert to string
	}
	
	//REST URL localhost:8080/alien/102
	
	@RequestMapping("/alien/{aid}") //{aid} wildcard -- dynamic
	@ResponseBody
	public String getAlienById(@PathVariable("aid") int aid)
	//@pathVariable from /alien/{aid} to int aid
	{
		return repo.findById(aid).toString();
	}
	
	*/
	
	//Now using JpaRepository
//	@RequestMapping("/aliens")
//	@RequestMapping(path="/aliens",produces= {"application/xml") to restrict to only xml
	@GetMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		return repo.findAll();
		//findAll() returns a list of json objects
	}
	
//	@RequestMapping("/alien/{aid}")
	@GetMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
	
	
	//post request so that we can add to server
//	@PostMapping("/aliens")
//	public Alien add_Alien(Alien alien)
//	{
//		repo.save(alien);
//		return alien;
//	}

//	@PostMapping("/aliens")
//	public Alien add_Alien(Alien alien)
//	{
//		repo.save(alien);
//		return alien;
//	}
// From postman we can add record as key,value from body->form data
	
	@PostMapping(path="/aliens", consumes= {"application/json"}) // server is getting data so consumes. restriction to accept only json data
	public Alien add_Alien(@RequestBody Alien alien) // when using raw data we should use @ResponseBody
	{
		repo.save(alien);
		return alien;
	}
	
	
	@DeleteMapping("/alien/{aid}")
//	public Alien deleteAlien(@PathVariable("aid") int aid)
	public Optional<Alien> deleteAlien(@PathVariable("aid") int aid)
	{	
//		Alien a = repo.getOne(aid); // depricated
//		Alien deleted = a;
//		repo.delete(a);
//		return deleted; got error
		
		Optional<Alien> a = repo.findById(aid);
		Optional<Alien> deleted = a;
		
		repo.deleteById(aid);
		return deleted;  //This worked
		
	}
	
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}	
}