package net.javaguides.todo.repository;

import net.javaguides.todo.entity.Appointment;
import net.javaguides.todo.entity.Product;
import net.javaguides.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository< Appointment , Long> {

    @Query("SELECT p FROM Appointment p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.appointment_u_name LIKE CONCAT('%', :query, '%')")
    List<Appointment> searchAppointments(String query);




}





