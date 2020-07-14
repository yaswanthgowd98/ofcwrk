package com.example.demo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DescriptionRepository;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.Repository.PhysicianRepository;
import com.example.demo.Repository.PlanRepository;
import com.example.demo.Repository.StateRepository;
import com.example.demo.model.Department;
import com.example.demo.model.Description;
import com.example.demo.model.Patient;
import com.example.demo.model.Physician;
import com.example.demo.model.Plan;
import com.example.demo.model.Search;
import com.example.demo.model.State;
@Component
public class RegisterPatientService {
	@Autowired
	PatientRepository pr;
	@Autowired
   DescriptionRepository dr;
	@Autowired
	PhysicianRepository phr;
	
	@Autowired
	StateRepository sr;
	@Autowired
	PlanRepository plr;
	
	@Autowired
	DepartmentRepository depr;
	
	
	
	
	//find physicians based on search object
public HashMap<Integer, Object> findPhysicians(Search search)
	
	{
	
	HashMap<Integer, Object> map=new HashMap<>();
        Integer stateid=search.getStateid();
        Integer planid=search.getPlanid();
        Integer departmentid=search.getDepartmentid();
		Optional<State> state=sr.findById(stateid);
		Optional<Department> department=depr.findById(departmentid);
		Optional<Plan> plan=plr.findById(planid);
		
		if(state.isPresent()&&department.isPresent()&&plan.isPresent())
		{
        Optional<List<Physician>> check = phr.findByStateidPlanidandDepartmentid(departmentid,planid, stateid);
        
		      if(check.isPresent())
		      {
		    	  
		    	  map.put(1, "Physicians found");
		    	
		    	  List<Physician> physicians=check.get();
		    	  map.put(2,physicians);
		    	  
		      }
		      else
		      {
		    	  map.put(1, "Physicians not found");
		    	  
		      }
		      
		}
		
		else
		{
			map.put(1, "search fail");
			String messages[]=new String[3];
			Integer i=0;
			if(department.isEmpty())
			{
				
				messages[i]="department id doesn't exist";
				i++;
				
			}
			if(plan.isEmpty())
			{
				messages[i]="plan id doesn't exist";
				i++;
			}
			if(state.isEmpty())
			{
				messages[i]="state id doesn't exist";
				i++;
			}
			
			//inputting number messages
			map.put(2,i);
			map.put(3, messages);
			
		}
		
		 System.out.println("ejbjdjbdb");
		return map;
		}
	
	
	
	
	
	//find  single patient
	
	public HashMap<Integer, Object> findPatient(Integer id,String firstName,String lastName)
	
	{
		System.out.println("----------hahhah");
		Optional<Patient> pat =Optional.empty();
		
	HashMap<Integer, Object> map=new HashMap<Integer, Object>();
		if(id!=null||(firstName!=null&&lastName!=null))
		{
		 System.out.println("nqme");
		if((id)!=null)
		{
			pat=pr.findById(id);
		    if( pat.isPresent())
		      {
			map.put(1,pat);
		       }
		    else
		       {
			map.put(1,pat);
			map.put(2,"patient id doesn't exist");
		        }
		}
		else
		{
			if((firstName!=null&&lastName!=null)&&firstName!=""&&lastName!="")
			{ 
				System.out.println("in");
				pat = pr.findByfirstandlastName(firstName, lastName);
			if(pat.isPresent())
			{
				
				map.put(1,pat);
			}
			 else
		       {
			map.put(1,pat);
			map.put(2,"patient doesn't exist");
		        }
			}
			else
			{
				map.put(1,pat);
				map.put(2,"Enter both First and lastName");
			}
				
			}
		}
		else
		{
			map.put(1,pat);
			map.put(2,"Enter either Id or First and lastName");
		}
		System.out.println("out");
		return map;
		
		
		}
		
	
	
	
	
	
	//register patient

	public Map<Integer,String> RegisterPatient(Patient patient)
	{
		Map<Integer,String> messages=new HashMap<>();
		
		String FirstName=patient.getFirstName();
		String LastName=patient.getLastName();
		 Optional<Set<Patient>> check = pr.findByFirstandLastName(FirstName, LastName);
		
		if(check.isEmpty())
		{
			
		if( pr.save(patient)!=null)
		{
			messages.put(1, "Success");
		 messages.put(2, "patient details saved successfully");
		 messages.put(3, "patient id is "+patient.getId());
		}
		}
		else
		{
			
			messages.put(1,"failed");
			messages.put(4,"Patient already exists with these details");
		}
		return messages;
	
	}
	
	
	public Map<Integer,String> saveDescription(Description description) 
	{
		
		Integer i=1;
		Patient patient = null;
		Physician physician=null;
		Map<Integer,String> messages=new HashMap<>();
		//step 1 common

		 patient=description.getPatient();
		
		 Optional<Physician> optional2=phr.findById(description.getPhysician().getId());
		
		 
		 
		if(patient!=null)
		{   
			 
			 if(optional2.isPresent())
			 {
				 physician=optional2.get();
			 }
		}
		
		
		if(patient!=null)
		{
			messages.put(1,"patientexists");
			if(physician!=null)
			   {
				messages.put(2,"Physicianexists");
			description.setPatient(patient);
			description.setPhysician(physician);
			     if((description=dr.save(description))!=null)
			        {
			         
			        messages.put(3,"success");
			        //sending description id back
			        messages.put(4, description.getId()+"");
			        }
			     else
			     {
			    	 messages.put(3,"failed");
				        messages.put(4, "Save failed");
			     }
			
		         }
	        else {
			   messages.put(2,"Physician doesn't exists");
		        
		          }
			
	       }
		else
		{
			messages.put(1,"patient doesn't exists");
			
		}
	
		return messages;
		
}
	
	
	


	public Map<Integer, String> RegisterPhysician(Physician physician) {
		
Map<Integer,String> messages=new HashMap<>();
		
		String FirstName=physician.getFirstName();
		String LastName=physician.getLastName();
		 Optional<Set<Physician>> check = phr.findByFirstandLastName(FirstName, LastName);
		
		if(check.isEmpty())
		{
			
		if( (physician=phr.save(physician))!=null)
		{
			String physicianId="PR"+"00"+physician.getId();
			
			System.out.println(physicianId);
			
			physician.setPhysicianId(physicianId);
			physician=phr.save(physician);
			
			messages.put(1, "Success");
		 messages.put(2, "physician details saved successfully");
		 messages.put(3, "physician id "+physician.getPhysicianId());
		}
		}
		else
		{
			System.out.println("register unsucessful");
			messages.put(1,"failed");
			messages.put(4,"Physician already registered with these details");
		}
		return messages;
		
		
	}
	
	
	//getting physicians for corresponding selected plan
	public Map<Physician, String> getPhysicians(Patient patient) 
	{
		Plan plan=patient.getPlan();
		
		Set<Physician> physicians=	plan.getPhysicians();
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
	
	
	
	
	
}





/*Set<Description> descriptions=(description.getPatient().getDescriptions());  
Iterator<Description> it=descriptions.iterator();
while(it.hasNext())
{
	System.out.println(it.next().getDesp());
}  */
