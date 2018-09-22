package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Customer
 */
/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-16T17:00:26.120Z")

public class Customer   {
  
  private static int Idcust = 0;
  public static List<Customer> custormers = new ArrayList<Customer>();  
    
  @JsonProperty("id_customer")
  private int idCustomer = 0;

  @JsonProperty("firsName")
  private String firsName = null;

  @JsonProperty("lastName")
  private String lastName = null;
  
  @JsonProperty("email")
  private String email = null;
  
  public Customer () {
    this.idCustomer = Idcust++;
  }

  public Customer (String firstname, String lastname, String email) {
    this.idCustomer = Idcust++;
    this.firsName = firstname;
    this.lastName = lastname;
    this.email = email;
  }

  /**
   * Get idCustomer
   * @return idCustomer
  **/
  @ApiModelProperty(value = "")

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  public Customer firsName(String firsName) {
    this.firsName = firsName;
    return this;
  }

  /**
   * Get firsName
   * @return firsName
  **/
  @ApiModelProperty(value = "")


  public String getFirsName() {
    return firsName;
  }

  public void setFirsName(String firsName) {
    this.firsName = firsName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /*
  public boolean createCustomer(String lastname, String firstname, String email)
  {
      boolean isCreated = false; 
      Customer customer = new Customer(firstname, lastname, email);
      return isCreated;
  }
    */
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.idCustomer, customer.idCustomer) &&
        Objects.equals(this.firsName, customer.firsName) &&
        Objects.equals(this.lastName, customer.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCustomer, firsName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    idCustomer: ").append(toIndentedString(idCustomer)).append("\n");
    sb.append("    firsName: ").append(toIndentedString(firsName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}