package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reservation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-16T17:00:26.120Z")

public class Reservation   {
    
  public static List<Reservation> reservation = new ArrayList<Reservation>();
  private int idRes = 0;
  
  @JsonProperty("id_reservation")
  private Integer idReservation;

  @JsonProperty("id_room")
  private int idRoom;
 
  @JsonProperty("from_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") 
  private Date fromDate ;

  @JsonProperty("lenght_of_stay")
  private int lenghtOfStay;

  @JsonProperty("id_customer")
  private int idCustomer;

  public Reservation () {
    this.idReservation = idRes++;
  }
  
  public Reservation(int idRoom, int idCustomer, Date fromDate, int lenghtOfStay) {
        this.idReservation = idRes++;
        this.idRoom = idRoom;
        this.idCustomer = idCustomer;
        this.fromDate = fromDate;
        this.lenghtOfStay = lenghtOfStay;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
  
  
  /**
   * Get idRoom
   * @return idRoom
  **/
  @ApiModelProperty(value = "")
  
  public int getIdRoom() {
    return idRoom;
  }

  public void setIdRoom(int idRoom) {
    this.idRoom = idRoom;
  }

  /**
   * Get fromDate
   * @return fromDate
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * value >= minimum / not exclude boundary
   * minimum: 1
   * @return lenghtOfStay
  **/
  @ApiModelProperty(value = "value >= minimum / not exclude boundary")

@Min(1)
  public int getLenghtOfStay() {
    return lenghtOfStay;
  }

  public void setLenghtOfStay(int lenghtOfStay) {
    this.lenghtOfStay = lenghtOfStay;
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.idRoom, reservation.idRoom) &&
        Objects.equals(this.fromDate, reservation.fromDate) &&
        Objects.equals(this.lenghtOfStay, reservation.lenghtOfStay) &&
        Objects.equals(this.idCustomer, reservation.idCustomer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRoom, fromDate, lenghtOfStay, idCustomer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    
    sb.append("    idRoom: ").append(toIndentedString(idRoom)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    lenghtOfStay: ").append(toIndentedString(lenghtOfStay)).append("\n");
    sb.append("    idCustomer: ").append(toIndentedString(idCustomer)).append("\n");
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

