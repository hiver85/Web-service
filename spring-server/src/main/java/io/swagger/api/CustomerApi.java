/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-30T19:31:00.221Z")

@Api(value = "Customer", description = "the Customer API")
public interface CustomerApi {

    @ApiOperation(value = "Create new customer during reservation without register", nickname = "createCustomer", notes = "", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Object.class) })
    @RequestMapping(value = "/Customer", method = RequestMethod.POST)
    //ResponseEntity<Customer> createCustomer(@ApiParam(value = "first name",required=true) @PathVariable("firstname") String firstname, @ApiParam(value = "last name",required=true) @PathVariable("lastname") String lastname, @ApiParam(value = "email",required=true) @PathVariable("email") String email);
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);

    @ApiOperation(value = "Read customer when he login", nickname = "readCustomer", notes = "", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/Customer/{customer_ID}", method = RequestMethod.GET)
    ResponseEntity<Customer> readCustomer(@ApiParam(value = "description",required=true) @PathVariable("customer_ID") int customerID);

}