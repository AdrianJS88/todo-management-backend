package net.javaguides.todo.service;

import net.javaguides.todo.dto.AppointmentDto;
import net.javaguides.todo.entity.Appointment;
import net.javaguides.todo.entity.Product;

import java.util.List;

public interface AppointmentService {

    AppointmentDto addAppointment (AppointmentDto appointmentDto);

    AppointmentDto getAppointment (Long id);



    List<AppointmentDto> getAllAppointments();



    AppointmentDto updateAppointment (AppointmentDto appointmentDto ,Long id);

    void deleteAppointment (Long id);

    List<Appointment> searchAppointments(String query);



}
