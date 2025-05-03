package org.globallogic.admin.controller;

import org.globallogic.admin.entity.Admin;
import org.globallogic.admin.entity.AdminTb;
import org.globallogic.admin.entity.Diagnostic;
import org.globallogic.admin.entity.Test;
import org.globallogic.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired 
	RestTemplate restTemplate;

	public AdminController(AdminService adminService, RestTemplate restTemplate) {
		super();
		this.adminService = adminService;
		this.restTemplate = restTemplate;
	}
	
	@PostMapping("/saves")
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		Test test = this .restTemplate.postForObject("http://localhost:8111/test/save", admin.getTest(), Test.class);
		Diagnostic diagnostic = this.restTemplate.postForObject("http://localhost:6777/diagnostic/save", admin.getCenter(), Diagnostic.class);
		AdminTb adminTb = new AdminTb();
	
		adminTb.setAdminName(admin.getAdminName());
		adminTb.setAdminPassword(admin.getAdminPassword());
		adminTb.setTestId(test.getTestId());
		adminTb.setCenterId(diagnostic.getCenterId());
		adminTb = adminService.saveAdmin(adminTb);
		return new Admin(adminTb.getAdminId(), adminTb.getAdminName(), adminTb.getAdminPassword(), test, diagnostic);
		
	}
	
	/*@GetMapping("/show/{id}")
	public  Admin getAdmin(@PathVariable("id") Long id)
	{
		AdminTb admintb = adminService.getAdminById(id);
		ScheduleRequestResponse scheduleRequestResponse=this.restTemplate.getForObject("http://localhost:8111/schedule/get/"+scheduledFlight.getScheduleId(),ScheduleRequestResponse.class);
    	Flight flight=this.restTemplate.getForObject("http://localhost:8222/Flight/get/"+scheduledFlight.getFlightId(),Flight.class);    	
    	ScheduledFlightRequestResponse scheduledFlightRequestResponseTemp=new ScheduledFlightRequestResponse(scheduledFlight.getScheduledFlightId(),flight,scheduledFlight.getAvailableSeats(),scheduleRequestResponse);

    	return scheduledFlightRequestResponseTemp;
	}*/
    
	
	@PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable("id") Long Id,@RequestBody Admin admin) {
    	AdminTb adminTemp=new AdminTb();
    	Test test = new Test();
    	Diagnostic center = new Diagnostic();
    	restTemplate.put("http://localhost:8111/test/update" + adminTemp.getTestId(), admin.getTest(), Test.class);
    	test = restTemplate.getForObject("http://localhost:8111/test/get"+ adminTemp.getTestId(), Test.class);
		restTemplate.put("http://localhost:6777/diagnostic/update" + adminTemp.getCenterId(), admin.getCenter(), Diagnostic.class);
		center = restTemplate.getForObject("http://localhost:6777/diagnostic/get"+ adminTemp.getCenterId(), Diagnostic.class);
    	adminTemp.setAdminId(Id);
		adminTemp.setAdminName(admin.getAdminName());
		adminTemp.setAdminPassword(admin.getAdminPassword());
		adminTemp.setTestId(test.getTestId());
		adminTemp.setCenterId(center.getCenterId());
		

		adminTemp=adminService.updateAdmin(adminTemp);
		
		return new Admin(adminTemp.getAdminId(), adminTemp.getAdminName(), adminTemp.getAdminPassword(), test, center);
    	
    }
}
