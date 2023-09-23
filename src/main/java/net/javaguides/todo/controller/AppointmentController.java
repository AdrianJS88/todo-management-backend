package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.AppointmentDto;
import net.javaguides.todo.entity.Appointment;
import net.javaguides.todo.repository.AppointmentRepository;
import net.javaguides.todo.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/appointments")
@AllArgsConstructor
public class AppointmentController {

    private AppointmentRepository appointmentRepository;

    private AppointmentService appointmentService;


    @GetMapping("/search")
    public ResponseEntity<List<Appointment>> searchAppointments(@RequestParam("query") String query){
        return ResponseEntity.ok(appointmentService.searchAppointments(query));
    }




    //BUILD ADD appointment REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    @PostMapping
    public ResponseEntity <AppointmentDto> addAppointment (@RequestBody AppointmentDto appointmentDto  ) {

             AppointmentDto savedAppointment = appointmentService.addAppointment(appointmentDto);
             return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }



    //BUILD GET TODO REST API

    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    @GetMapping("{id}")
    public ResponseEntity <AppointmentDto> getAppointment(@PathVariable ("id") Long userId){
       AppointmentDto appointmentDto = appointmentService.getAppointment(userId);
return new ResponseEntity<>(appointmentDto,HttpStatus.OK);
    }





    // Build Get All appointment REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments(){

        List<AppointmentDto> appointments = appointmentService.getAllAppointments();

        return ResponseEntity.ok(appointments);
    }





    // Build Update Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto, @PathVariable("id") Long appointmentId){
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(appointmentDto, appointmentId);
        return ResponseEntity.ok(updatedAppointment);
    }




    // Build Delete Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully!.");
    }

}
