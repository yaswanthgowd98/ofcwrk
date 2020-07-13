package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.BillRepository;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DescriptionRepository;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.Repository.PhysicianRepository;
import com.example.demo.Repository.PlanRepository;
import com.example.demo.Repository.StateRepository;
import com.example.demo.model.Bill;
import com.example.demo.model.Department;
import com.example.demo.model.Description;
import com.example.demo.model.Patient;
import com.example.demo.model.Physician;
import com.example.demo.model.Plan;
import com.example.demo.model.Search;
import com.example.demo.model.State;
import com.example.demo.model.Todo;
import com.example.demo.service.RegisterPatientService;
import com.example.demo.service.TodoRepository;

@Controller
public class TodoController {
	
	@Autowired
	TodoRepository repository;
	@Autowired
	RegisterPatientService rps;
	@Autowired
	PhysicianRepository phr;
	@Autowired
	StateRepository sr;
	@Autowired
	PlanRepository plr;
	@Autowired
	PatientRepository pr;
	@Autowired
	DepartmentRepository dr;
	@Autowired
	DescriptionRepository descr;
	
	@Autowired
	BillRepository br;
	
	
	
/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	*/
      
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", repository.findByUser(name));
		//model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model),
				"Default Desc", new Date(), false));
		return "todo";
	}
	
	
	//showing search physician page home
	@RequestMapping(value = "/search-physician", method = RequestMethod.GET)
	public String showSearchPhysicianPage(ModelMap model) {
	
		
	Search search=new Search() ;
	
		model.addAttribute("search", search);
		return "physiciansearch";
	}
	
	
	
	
		//showing Physicians in search physician page
		@RequestMapping(value = "/searchphysicians", method = RequestMethod.POST)
		public String showPhysicians(ModelMap model,@Valid Search search, BindingResult result) {
		   
			String viewname="";
			Search newsearch=new Search(); 
if (result.hasErrors()) {
				
	viewname= "physiciansearch";
			}

else {
	HashMap<Integer, Object> map=rps.findPhysicians(search);
	
	if(map.get(1).equals("Physicians found"))
	{ 
		model.addAttribute("search", newsearch);
		
		List<Physician> physicians=(List<Physician>) map.get(2);
		
		 
		model.addAttribute("physicians", physicians);
		
		model.addAttribute("message", physicians.size()+" records found");
		viewname= "physiciansearch";
	}
	else if(map.get(1).equals("Physicians not found"))
	{
		model.addAttribute("search", newsearch);
		
		model.addAttribute("message","No physician record found");
		
		viewname= "physiciansearch";
	}
	
	else
	{
		Integer i=(Integer) map.get(2);
		String messages[]=(String[]) map.get(3);
		Integer k=0;
		for(k=0;k<i;k++)
		{
			model.addAttribute("message"+(k+1), messages[k]);	
		
		}
		viewname= "physiciansearch";
	}
	
	
}
return viewname;
		}			
		
		
		
		
		
		//showing Physician register  page
				@RequestMapping(value = "/register-physician", method = RequestMethod.GET)
				public String showRegisterPhysicianPage(ModelMap model) {
			
					
				Physician physician=new Physician() ;
					
				
					System.out.println("-------------");
					
				
					model.addAttribute("physician", physician);
					return "registerphysician";
				}
		
		
		
		
	
		//registering physician
		@RequestMapping(value = "/registerphysician", method = RequestMethod.POST)
		public String RegisterPhysician(ModelMap model,@Valid Physician physician, BindingResult result) {
	        // Description description=patient.getDescription();
			// model.put("states",buildState());
			model.addAttribute("physician", physician);
			if (result.hasErrors()) {
				
				return "registerphysician";
			}

			else
			{
				
				System.out.println("===================================");
				//System.out.println(patient.getDescription().getId());
				Map<Integer,String> messages=rps.RegisterPhysician(physician);
			  if(messages.get(1).equals("Success"))
			  {
				  model.addAttribute("successmsg",messages.get(2));
				  model.addAttribute("Displayid",messages.get(3));
			return "sucessdisplay";
			  }
			  else
			  {
				  String msg=messages.get(4);
				  model.addAttribute("messages", msg);
				  return "registerphysician";
			  }
			}
		}
	
		
	//showing patient register page
	@RequestMapping(value = "/register-patient", method = RequestMethod.GET)
	public String showRegisterPatientPage(ModelMap model) {
	//  Description description=new Description(0, "no description added");
	//	rps.saveorupdateDescription(description);
	//	description= dr.saveAndFlush(description);
		//model.put("states",buildState());
		System.out.println("desp saved===============");
		Patient patient=new Patient();
		//patient.setDescription(description);
	
		System.out.println("-------------");
		System.out.println(patient.getId());
	//	System.out.println(patient.getDescription().getId());
		System.out.println("-------------");
		System.out.println("-------------");
		model.addAttribute("patient", patient);
		return "registerpatient";
	}
	
	//registering patient
	@RequestMapping(value = "/registerpatient", method = RequestMethod.POST)
	public String RegisterPatient(ModelMap model,@Valid Patient patient, BindingResult result) {
        // Description description=patient.getDescription();
		// model.put("states",buildState());
		model.addAttribute("patient", patient);
		if (result.hasErrors()) {
			
			return "registerpatient";
		}

		else
		{
			
			System.out.println("===================================");
			//System.out.println(patient.getDescription().getId());
			Map<Integer,String> messages=rps.RegisterPatient(patient);
		  if(messages.get(1).equals("Success"))
		  {
		return "redirect:/";
		  }
		  else
		  {
			  String msg=messages.get(4);
			  model.addAttribute("messages", msg);
			  return "registerpatient";
		  }
		}
	}
	
	
	
	
	//patient search and diagnosis home common
	@RequestMapping(value = "/diagnosis", method = RequestMethod.GET)
	public String showDiagnosisHome(ModelMap model) {
		
		List<Patient> patients=new ArrayList<>();	
		model.addAttribute("patients", patients);
		
		return "prediagnosis";
	
	}
	
	@RequestMapping(value = "/findPatientToAddDiagnosis", method = RequestMethod.POST)
public String showPatientExists(ModelMap model,@RequestParam Integer id,@RequestParam String  firstName,@RequestParam String lastName) {
	
 

		Patient patient=new Patient();
		
		System.out.println("-----------------1");
		HashMap<Integer, Object> map=rps.findPatient(id, firstName, lastName);
		System.out.println("-----------------2");
		
		Optional<Patient> pat=(Optional<Patient>) map.get(1);
		System.out.println("-----------------3");
		if(pat.isPresent())
		{
			patient=pat.get();
			List<Patient> patients=new ArrayList<>();
			patients.add(patient);
			
			//step 2 diagnosis
			//adding diagnosis details corresponding to that patient
			Set<Description> descriptions=new HashSet<>();
		descriptions=patient.getDescriptions();
	
			
			
			model.addAttribute("patients", patients);
			model.addAttribute("descriptions", descriptions);
			//model.addAttribute("message", "Patient  "+patient.getFirstName()+" "+patient.getLastName()+"exists");
			return "prediagnosis";
			
		}
		else
		{
			String message=(String)map.get(2);
			model.addAttribute("message", message);
			return "prediagnosis";
		}
		
	}
	
	
	
	
	
	//showing Diagnosis page
		@RequestMapping(value = "/patient-diagnosis", method = RequestMethod.GET)
		public String showDiagnosisDetailsPage(ModelMap model,@RequestParam Integer id) {

			
			
			Patient patient=pr.findById(id).get();
			Description description=new Description();
			
			
			
			description.setPatient(patient);
		 //getting physicians based on plan selected
			model.addAttribute("physicians",rps.getPhysicians(patient));
		    
			model.addAttribute("description", description);
			return "diagnosis";
		}
		
		/*
		 * //registering patient
		 * 
		 * @RequestMapping(value = "/patientDiagnosisDetails", method =
		 * RequestMethod.POST) public String RegisterDiagnosisDetails(ModelMap
		 * model,@Valid Description description, BindingResult result) {
		 * 
		 * model.addAttribute("description",description); String view=""; if
		 * (result.hasErrors()) {
		 * 
		 * //getting physicians based on plan selected
		 * model.addAttribute("physicians",rps.getPhysicians(description.getPatient()));
		 * 
		 * view="diagnosis"; }
		 * 
		 * else {
		 * 
		 * 
		 * 
		 * Map<Integer,String> messages=rps.saveDescription(description);
		 * 
		 * 
		 * if(messages.get(1).equals("patientexists")) {
		 * 
		 * if(messages.get(2).equals("Physicianexists")) {
		 * 
		 * if(messages.get(3).equals("success")) { model.put("successmsg",
		 * "Details Saved Successfully!!"); model.put("Displayid",messages.get(4));
		 * view= "sucessdisplay"; } else {
		 * 
		 * model.put("failedmsg", messages.get(3)); view= "sucessdisplay"; }
		 * 
		 * } else { model.put("msg", "Physician id doesn't exists"); view= "diagnosis";
		 * }
		 * 
		 * } else { model.put("msg", "patient id doesn't exists"); view= "diagnosis"; }
		 * 
		 * 
		 * } return view; }
		 */
		
		
		//registering patient
		@RequestMapping(value = "/patientDiagnosisDetails", method = RequestMethod.POST)
		public String RegisterDiagnosisDetails(ModelMap model,@Valid Description description, BindingResult result)  {
	        
			model.addAttribute("description",description);
			String view="";
			if (result.hasErrors()) {
			     
				//getting physicians based on plan selected
				model.addAttribute("physicians",rps.getPhysicians(description.getPatient()));
			
				view="diagnosis";
			}

			else
			{
				
				
				
				Map<Integer,String> messages=rps.saveDescription(description);
				
			
			if(messages.get(1).equals("patientexists"))
			{   
				
				if(messages.get(2).equals("Physicianexists"))
				{
					
					if(messages.get(3).equals("success"))
					{
					//	model.put("successmsg", "Details Saved Successfully!!");
					//	model.put("Displayid",messages.get(4));
						// view= "sucessdisplay";
						System.out.println("success");
						view=  "redirect:/add-bill?id="+messages.get(4);
					}
					else
					{
						
						model.put("failedmsg", messages.get(3));
						view= "sucessdisplay";
					}
					
				}
				else
				{
					model.put("msg", "Physician id doesn't exists");
					view= "diagnosis";
				}
				
			}
			else
			{
				model.put("msg", "patient id doesn't exists");
				view= "diagnosis";
			}
			
			
		}   
			return view;
		}
		
	
		
		//billing page display
		@RequestMapping(value = "/add-bill", method = RequestMethod.GET)
		public String billingPageDisplay(ModelMap model,@RequestParam Integer id) {
           
			Description description=descr.findById(id).get();
			Bill bill=new Bill();
			bill.setDescription(description);
			bill.setAmount(description.getPhysician().getPlan().getCost());
			model.addAttribute("description", description);
			model.addAttribute("bill", bill);
			
			return "billing";
		}
	
		
		//billing
		@RequestMapping(value = "/billingDetails", method = RequestMethod.POST)
		public String addBillingTodiagnosis(ModelMap model,@Valid Bill bill,BindingResult result) {
			Description description=bill.getDescription();
			if(result.hasErrors())
           {
        	   
        	   bill.setDescription(description);
   			model.addAttribute("description", description);
   			model.addAttribute("bill", bill);
   			
   			return "billing";
           }
			
           else
           {
        	   bill.setPaymentStatus("Paid");
        	   Bill billed=br.saveAndFlush(bill);
        	   
        	   
        	   model.put("successmsg", "Diagnosis details Saved Successfully!!");
				model.put("Displayid","Diagnosis id "+description.getId());
        	   return "sucessdisplay";
           }
			
			
		}
	
		
		
		
		
		
		
		

		
		//delete todo
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		//if(id==1)
			//throw new RuntimeException("Something went wrong");
		repository.deleteById(id);
		//service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = repository.findById(id).get();
		//Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Validated Todo todo,
			BindingResult result) {
        
		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUser(getLoggedInUserName(model));

		repository.save(todo);
		//service.updateTodo(todo);

		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
         
		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUser(getLoggedInUserName(model));
		repository.save(todo);
		
		/*service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(),
				false);*/
		return "redirect:/list-todos";
	}
	
	
	//auto populating feature methods
	
	
	//all states id
	@ModelAttribute("statesids")
    public Map<Integer, String> buildStatesids() 
   
    {
	List<State> states=	sr.findAll();
		Map<Integer,String> pairs = new HashMap<>();
		Iterator<State> it=states.iterator();
		
		while(it.hasNext())
		{ 
			State state=it.next();
			System.out.println(state.getStatename());
			pairs.put(state.getId(),state.getStatename());
			
		}
        
        
        return pairs;
    } 
	  
	
	
	
//states
	@ModelAttribute("states")
    public Map<State, String> buildState() 
   
    {
	List<State> states=	sr.findAll();
		Map<State,String> pairs = new HashMap<>();
		Iterator<State> it=states.iterator();
		int i=1;
		while(it.hasNext())
		{ 
			State state=it.next();
			System.out.println(state.getStatename());
			pairs.put(state,state.getStatename());
			i++;
		}
        
        
        return pairs;
    } 
	
	//plan
	@ModelAttribute("plans")
    public Map<Plan, String> buildPlans() 
   
    {
	List<Plan> plans=	plr.findAll();
		Map<Plan,String> pairs = new HashMap<>();
		Iterator<Plan> it=plans.iterator();
		
		while(it.hasNext())
		{ 
			Plan plan=it.next();
			System.out.println(plan.getPlanName());
			pairs.put(plan,plan.getPlanName());
			
		}
        
        
        return pairs;
    } 
	
	//all plans id
	@ModelAttribute("plansids")
    public Map<Integer, String> buildPlansids() 
   
    {
	List<Plan> plans=	plr.findAll();
		Map<Integer,String> pairs = new HashMap<>();
		Iterator<Plan> it=plans.iterator();
		
		while(it.hasNext())
		{ 
			Plan plan=it.next();
			System.out.println(plan.getPlanName());
			pairs.put(plan.getId(),plan.getPlanName());
			
		}
        
        
        return pairs;
    } 
	
	
	
	
	
	
	
	
	
	
	
	
	//physicians
		//@ModelAttribute("physicians")
	    public Map<Physician, String> buildPhysicians() 
	   
	    {
		List<Physician> physicians=	phr.findAll();
			Map<Physician,String> pairs = new HashMap<>();
			Iterator<Physician> it=physicians.iterator();
			
			while(it.hasNext())
			{ 
				Physician physician=it.next();
				System.out.println();
				pairs.put(physician,physician.getFirstName()+" "+physician.getLastName());
			
			}
	        
	        
	        return pairs;
	    } 

		
		//departments
		
				@ModelAttribute("departments")
			    public Map<Department, String> buildDepartments() 
			   
			    {
				List<Department> departments=	dr.findAll();
					Map<Department,String> pairs = new HashMap<>();
					Iterator<Department> it=departments.iterator();
					
					while(it.hasNext())
					{ 
						Department department=it.next();
						System.out.println();
						pairs.put(department,department.getDepartmentName());
						
					}
			        
			        
			        return pairs;
			    } 
				
				
				//all department id
				@ModelAttribute("departmentsids")
			    public Map<Integer, String> buildDepartmentsids() 
			   
			    {
				List<Department> departments=	dr.findAll();
					Map<Integer,String> pairs = new HashMap<>();
					Iterator<Department> it=departments.iterator();
					
					while(it.hasNext())
					{ 
						Department department=it.next();
						System.out.println(department.getDepartmentName());
						pairs.put(department.getId(),department.getDepartmentName());
						
					}
			        
			        
			        return pairs;
			    } 
	
}
