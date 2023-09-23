package net.javaguides.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private  Long id;

    @Column(nullable = false )

     @DateTimeFormat(pattern = "dd-MM-yyyy HH:ss")
    private LocalDateTime date_appointment ;

    private String name;

    private String appointment_u_name;



}
