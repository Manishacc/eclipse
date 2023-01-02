package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.response.Customer;

@Controller
public class PracticeController {

	@Autowired
	private Customer customer;

	@RequestMapping(value = "/getName", method = RequestMethod.GET)
	public String getName() {
		return "Welcome";
	}

	@GetMapping("/getCityName")
	public String cityName() {
		return "Bangalore";
	}

	@PostMapping("/getCityName")
	public String Name() {
		return "Manisha";
	}
	
	@ResponseBody
    @RequestMapping("/hello")
 
    public String helloWorld()
    {
        return "Hello World!";
    }
	
	 
	 
	 @GetMapping("/api/employees/{id}")
	 @ResponseBody
	 public String getEmployeesById(@PathVariable String id) {
	     return "ID: " + id;
	 }
}
