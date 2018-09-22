package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Room
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-16T17:00:26.120Z")

public class Room   {
    
  public static List<Room> rooms = new ArrayList<Room>(); 
  private static int idroom = 0;
  
  @JsonProperty("id_room")
  private int idRoom;

  @JsonProperty("no_bedroom")
  private Integer noBedroom;
  
  @JsonProperty("price")
  private float price;
  
  @JsonProperty("city")
  private String city;

  @JsonProperty("surface")
  private Float surface;

  @JsonProperty("floor")
  private int floor;

  @JsonProperty("status")
  private boolean status;

  @JsonProperty("description")
  private String description = null;

  public Room (int no_bedroom, float surface, int floor, boolean stt, String city, float price, String desc) {
    this.idRoom = idroom++;
    this.surface = surface;
    this.city = city;
    this.price = price;
    this.noBedroom = no_bedroom;
    this.floor = floor;
    this.status = stt;
    this.description = desc;
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

  public Room Search_noBedroom(int noBedroom) {
    this.noBedroom = noBedroom;
    return this;
  }

  /**
   * Get noBedroom
   * @return noBedroom
  **/
  @ApiModelProperty(value = "")


  public int getNoBedroom() {
    return noBedroom;
  }

  public void setNoBedroom(int noBedroom) {
    this.noBedroom = noBedroom;
  }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

  
  /**
   * Get surface
   * @return surface
  **/
  @ApiModelProperty(value = "")


  public Float getSurface() {
    return surface;
  }

  public void setSurface(Float surface) {
    this.surface = surface;
  }

  @ApiModelProperty(value = "")


  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")

  @Valid

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }


  @ApiModelProperty(value = "description of the room, including:view, smoking or not,...")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.idRoom, room.idRoom) &&
        Objects.equals(this.noBedroom, room.noBedroom) &&
        Objects.equals(this.surface, room.surface) &&
        Objects.equals(this.floor, room.floor) &&
        Objects.equals(this.status, room.status) &&
        Objects.equals(this.description, room.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRoom, noBedroom, surface, floor, status, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");
    
    sb.append("    idRoom: ").append(toIndentedString(idRoom)).append("\n");
    sb.append("    noBedroom: ").append(toIndentedString(noBedroom)).append("\n");
    sb.append("    surface: ").append(toIndentedString(surface)).append("\n");
    sb.append("    floor: ").append(toIndentedString(floor)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

