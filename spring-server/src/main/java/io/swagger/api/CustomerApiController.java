package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-30T19:31:00.221Z")

@Controller
public class CustomerApiController implements CustomerApi {

    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

//    public ResponseEntity<Customer> createCustomer(@ApiParam(value = "first name",
//            required=true) @PathVariable("firstname") String firstname, 
//            @ApiParam(value = "last name",required=true) @PathVariable("lastname") String lastname,
//            @ApiParam(value = "email",required=true) @PathVariable("email") String email) 
//    {        
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            // Call function to insert new record into DB
//            Customer cus = new Customer(firstname,lastname,email);
//            Customer.custormers.add(cus);
//            return new ResponseEntity<Customer>(cus, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
//    }
    
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            System.out.println(customer.getIdCustomer()+customer.getFirsName()+customer.getLastName()+customer.getEmail());
            
            Customer.custormers.add(customer);
            return new ResponseEntity<Customer>(HttpStatus.OK);
        }

        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<Customer> readCustomer(@ApiParam(value = "description",
            required=true) @PathVariable("customer_ID") int customerID)
    {
        String accept = request.getHeader("Accept");
        HttpStatus status; 
        if (accept != null && accept.contains("application/json")) {
            Customer cus = null;
            //Call function to read a record from DB
            for (Customer customer : Customer.custormers) {
                if (customer.getIdCustomer() == customerID){
                    cus = customer;
                    break;
                }
            }
            if (cus !=null)
                status = HttpStatus.OK;
            else
                status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<Customer>(cus, status);
        }

        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
    }

}
