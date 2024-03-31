package net.javaguides.todo.repository;

import net.javaguides.todo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository< Appointment , Long> {

    @Query("SELECT p FROM Appointment p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.appointment_u_name LIKE CONCAT('%', :query, '%')")
    List<Appointment> searchAppointments(String query);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Appointment a WHERE a.date_appointment = :date_appointment")
    boolean existsByDateAppointment(@Param("date_appointment") LocalDateTime date_appointment);
}







