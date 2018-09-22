package io.swagger.api;

import io.swagger.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Reservation;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-30T19:31:00.221Z")

@Controller
public class RoomsApiController implements RoomsApi {

    private static final Logger log = LoggerFactory.getLogger(RoomsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RoomsApiController(ObjectMapper objectMapper, HttpServletRequest request) 
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Room>> getRooms() {
        String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) 
        {
            List<Room> result = new ArrayList<>();
            for (Room ro : Room.rooms)
            {
               if (ro.getStatus() == false)
               {
                   result.add(ro);
               }
            }
            return new ResponseEntity<List<Room>>(result, HttpStatus.OK); 
        }
        return new ResponseEntity<List<Room>>(HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<Void> cancelARoom(@RequestBody Integer idReservation)
    {
        String accept = request.getHeader("Accept");
        HttpStatus status = HttpStatus.NOT_FOUND; 

        Reservation reserv = null;
        for (Reservation res : Reservation.reservation) {
            if (res.getIdReservation()== idReservation.intValue()){
                reserv = res;
                break;
            }
        }

        if (reserv != null)
        {         
            // delete reservation in the list res
            Reservation.reservation.remove(reserv);
            status = HttpStatus.OK;
                    
            // update room status 
            for (Room ro : Room.rooms) {
                if (ro.getIdRoom()==reserv.getIdRoom()){
                    ro.setStatus(false); 
                    break;
                }
            }
        }
        
        return new ResponseEntity<Void>(status);     
    }

   
    public ResponseEntity<Reservation> reserveARoom(@RequestBody Reservation reservation)
    {
        String accept = request.getHeader("Accept");
        HttpStatus status = HttpStatus.NOT_FOUND; 
        System.out.println(reservation.getFromDate().toString());
        
        for (Room ro : Room.rooms) {
            if (ro.getIdRoom()==reservation.getIdRoom())
            {
                if (ro.getStatus() == false)
                {
                    ro.setStatus(true);
                    Reservation.reservation.add(reservation);
                    status = HttpStatus.OK;
                    break;
                } else
                    status = HttpStatus.CONFLICT;
            }
        }
   
        return new ResponseEntity<Reservation>(reservation,status);
            
    }
    
    public ResponseEntity<Reservation> modifyARoom(@RequestBody Reservation reservation)
    {
        String accept = request.getHeader("Accept");
        HttpStatus status = HttpStatus.NOT_FOUND; 
        System.out.println(reservation.getFromDate().toString());
        
        for (Reservation res : Reservation.reservation) {
            if (res.getIdReservation()==reservation.getIdReservation()){
                // update room status 
                for (Room ro : Room.rooms) {
                    if (ro.getIdRoom()==res.getIdRoom())
                        ro.setStatus(false); 
                    else if (ro.getIdRoom()==reservation.getIdRoom()){
                        ro.setStatus(true);
                    }
            }
                res = reservation;
                status = HttpStatus.OK;
                break;
            }
        }
   
        return new ResponseEntity<Reservation>(reservation,status);
            
    }

    public ResponseEntity<List<Room>> search(@ApiParam(value = "filter by name of city") @Valid @RequestParam(value = "city_name", required = false) String cityName,@ApiParam(value = "filter by number of bedroom") @Valid @RequestParam(value = "nm_bedroom", required = false) Integer nmBedroom,@ApiParam(value = "filter by price prefered") @Valid @RequestParam(value = "price", required = false) Float price) {
        String accept = request.getHeader("Accept"); 
        List<Room> result_ro = new ArrayList<Room>();
        
        if (accept != null && accept.contains("application/json")) 
        {
            System.out.println(cityName + "-" + nmBedroom + "-" + price);
            
            for (Room ro : Room.rooms) {
                if ((cityName == null || cityName.equals("")) && nmBedroom != null && price != null)
                {
                    System.out.println("1");
                    if (ro.getNoBedroom() <= nmBedroom && ro.getPrice() <= price)
                        result_ro.add(ro);
                }

                if ((cityName == null || cityName.equals("")) && nmBedroom == null && price != null)
                {
                    System.out.println("2");
                    if (ro.getPrice() <= price)
                        result_ro.add(ro);
                }

                if ((cityName != null && !cityName.equals("")) && nmBedroom == null && price == null)
                {
                    System.out.println("3");
                    System.out.println(cityName + "-" + nmBedroom + "-" + price);
                    System.out.println("2" + ro.getCity() + "-" + ro.getNoBedroom() + "-" + ro.getPrice());
                    if (ro.getCity().equalsIgnoreCase(cityName) )
                        result_ro.add(ro);
                }

                if ((cityName != null && !cityName.equals("")) && nmBedroom != null && price == null)
                {
                    System.out.println("4");
                    if (ro.getCity().equalsIgnoreCase(cityName) && ro.getNoBedroom() <= nmBedroom)
                        result_ro.add(ro);
                }

                if ((cityName != null && !cityName.equals("")) && nmBedroom != null && price != null)
                {
                    System.out.println("5");                    
                    System.out.println(cityName + "-" + nmBedroom + "-" + price);
                    System.out.println("2" + ro.getCity() + "-" + ro.getNoBedroom() + "-" + ro.getPrice());
                    if (ro.getCity().equalsIgnoreCase(cityName) && ro.getNoBedroom() <= nmBedroom && ro.getPrice() <= price)
                    {
                        result_ro.add(ro);
                    }
                }

                if ((cityName != null && !cityName.equals("")) && nmBedroom == null && price != null)
                {
                    System.out.println("6");
                    if (ro.getCity().equalsIgnoreCase(cityName) && ro.getPrice() <= price)
                        result_ro.add(ro); 
                    System.out.println("equal?"+ro.getCity().equalsIgnoreCase(cityName));
                } 
            } 
            if ((cityName == null || cityName.equals("")) && nmBedroom == null && price == null)
            {
                System.out.println("7");
                result_ro.addAll(Room.rooms);
            }
            return new ResponseEntity<List<Room>>(result_ro,HttpStatus.OK);
        }
        else 
            return new ResponseEntity<List<Room>>(HttpStatus.BAD_REQUEST);
    }
}
