package company.restfulllog.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import company.restfulllog.privateent.privateent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class stepdefinition 
{
	public Logger log=LogManager.getLogger("rest_Api");
	public RequestSpecification req=null;
	public Response res=null;
	public ObjectMapper map=null;
	public String empid=null;
    /*
     * Author
     * Scenario:I enter the baseuri
     */
	@Given("^I enter the (.*)$")
	public void I_enter_the_baseuri(String path)
	{
		log.info("the method I_enter_the_baseuri starts here");
		try 
		{
			RestAssured.baseURI=path;
		} catch (Exception e) 
		{
		log.error("the method I_enter_the_baseuri has an error");
		}
		log.info("the method I_enter_the_baseuri ends here");
	}
	/*
	 * Author:
	 * Scenario:I assing request specification
	 */
	@And("^I assing resquest specification$")
	public void I_assing_resquest_specification()
	{
		log.info("execution of I_assing_resquest_specification method starts here ");
		try 
		{
			req=RestAssured.given();
		} catch (Exception e) 
		{
			log.error("there is an error in I_assing_resquest_specification method");		
		} 
		log.info("execution of I_assing_resquest_specification method ends here ");
	}
	
	/*
	 * Author:
	 * Scenario:I assing request specification
	 */
	@And("^I enter header$")
	public void I_enter_header()
	{
		log.info("execution of I_enter_header method starts here ");
		try 
		{
			req.header("content-type","application/json");
		} catch (Exception e) 
		{
			log.error("there is an error in I_enter_header method");		
		} 
		log.info("execution of I_enter_header method ends here ");
	}
	
	/*
	 * Author:
	 * Scenario:I assing request specification
	 */
	@And("^I enter enteries$")
	public void I_enter_enteries()
	{
		log.info("execution of I_enter_enteries method starts here ");
		try 
		{
			privateent obj=new privateent();
			
			obj.setEmployeeFirstName("user");
			obj.setEmployeeLastName("1");
			obj.setJobName("system engineer");
			obj.setEmailId("user1@g.com");
			obj.setAge("33");
			obj.setContactNumber("876787656");
			obj.setSalary("50000");
			obj.setDepartmentName("Accounts");
			obj.setCityName("Bengaluru");
			obj.setAddress("Attiguppe,Bengaluru");
			
			ObjectMapper map=new ObjectMapper();
			
			String jsoncon=map.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			req.body(jsoncon);

		} catch (Exception e) 
		{
			log.error("there is an error in I_enter_enteries method");		
		} 
		log.info("execution of I_enter_enteries method ends here ");
	}
	
	
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take response$")
	public void I_take_response()
	{
		log.info("execution of I_take_response method starts here ");
		try 
		{
			res=req.post();
		} catch (Exception e) 
		{
			log.error("there is an error in I_take_response method");		
		} 
		log.info("execution of I_take_response method ends here ");
	}
	
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I print response$")
	public void I_print_response()
	{
		log.info("execution of I print response method starts here ");
		try 
		{
			res.prettyPrint();
		} catch (Exception e) 
		{
			log.error("there is an error in I print response method");		
		} 
		log.info("execution of I print response method ends here ");
	}
	/*
	 * Author
	 * scenario: I take id from table
	 */
	@And("^I take id from table$")
	public void I_take_id_from_table()
	{
		log.info("the method I_take_id_from_table starts here");
		try 
		{
			JsonPath jpath=res.jsonPath();
			empid=jpath.getString("id");
			System.out.println("********************************************");
			System.out.println("id of the current table is :"+empid );
			System.out.println("********************************************");
		} catch (Exception e) {
			log.error("the method I_take_id_from_table has an error");		}
		log.info("the method I_take_id_from_table starts here");
	}
	
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take get geturi$")
	public void I_take_get_geturi()
	{
		log.info("execution of I print response method starts here ");
		try 
		{
			RestAssured.baseURI="http://localhost:8082/sgtest-employee/api/v1/employees/"+empid;
		} catch (Exception e) 
		{
			log.error("there is an error in I print response method");		
		} 
		log.info("execution of I print response method ends here ");
	}
	
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take get response$")
	public void I_take_get_response()
	{
		log.info("execution of I_take_get_response starts here ");
		try 
		{
			res=req.get();
		} catch (Exception e) 
		{
			log.error("there is an error in I_take_get_response method");		
		} 
		log.info("execution of I_take_get_response ends here ");
	}
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take put uri$")
	public void I_take_put_uri()
	{
		log.info("execution of I_take_get_response starts here ");
		try 
		{
			RestAssured.baseURI="http://localhost:8082/sgtest-employee/api/v1/employees/"+empid;
		} catch (Exception e) 
		{
			log.error("there is an error in I_take_get_response method");		
		} 
		log.info("execution of I_take_get_response ends here ");
	}
	/*
	 * Author:
	 * Scenario:I enter put enteries
	 */
	@And("^I enter put enteries$")
	public void I_enter_put_enteries()
	{
		log.info("execution of I_enter_put_enteries method starts here ");
		try 
		{
			privateent obj=new privateent();
			
			obj.setEmployeeFirstName("user");
			obj.setEmployeeLastName("1");
			obj.setJobName("modified engineer");
			obj.setEmailId("user1@g.com");
			obj.setAge("33");
			obj.setContactNumber("876787656");
			obj.setSalary("50000");
			obj.setDepartmentName("Accounts");
			obj.setCityName("Bengaluru");
			obj.setAddress("Attiguppe,modified");
			
			ObjectMapper map=new ObjectMapper();
			
			String jsoncon =map.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			req.body(jsoncon);

		} catch (Exception e) 
		{
			log.error("there is an error in I_enter_enteries method");		
		} 
		log.info("execution of I_enter_enteries method ends here ");
	}
	
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take put response$")
	public void I_take_put_response()
	{
		log.info("execution of I_take_response method starts here ");
		try 
		{
			res=req.put();
		} catch (Exception e) 
		{
			log.error("there is an error in I_take_response method");		
		} 
		log.info("execution of I_take_response method ends here ");
	}
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take delete uri$")
	public void I_take_delete_uri()
	{
		log.info("execution of I print response method starts here ");
		try 
		{
			RestAssured.baseURI="http://localhost:8082/sgtest-employee/api/v1/employees/"+empid;
		} catch (Exception e) 
		{
			log.error("there is an error in I print response method");		
		} 
		log.info("execution of I print response method ends here ");
	}
	/*
	 * Author:
	 * Scenario:I take response
	 */
	@And("^I take delete response$")
	public void I_take_delete_response()
	{
		log.info("execution of I_take_response method starts here ");
		try 
		{
			res=req.delete();
		} catch (Exception e) 
		{
			log.error("there is an error in I_take_response method");		
		} 
		log.info("execution of I_take_response method ends here ");
	}
}
