package net.javaguides.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.AppointmentDto;
import net.javaguides.todo.entity.Appointment;
import net.javaguides.todo.exception.ResourceNotFoundException;
import net.javaguides.todo.repository.AppointmentRepository;
import net.javaguides.todo.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {



    private AppointmentRepository appointmentRepository;

    private ModelMapper modelMapper;



    @Override
    public List<Appointment> searchAppointments(String query) {
        List<Appointment> appointments = appointmentRepository.searchAppointments(query);
        return appointments;
    }




    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        // convert TodoDto into Todo Jpa entity

         Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);

        // Todo Jpa entity
        Appointment savedAppointment = appointmentRepository.save(appointment);


        // Convert saved Todo Jpa entity object into TodoDto object
        AppointmentDto savedAppointmentDto = modelMapper.map(savedAppointment,AppointmentDto.class);



        return savedAppointmentDto;
    }

    @Override
    public AppointmentDto getAppointment(Long id) {

       Appointment appointment  = appointmentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + id));


        return modelMapper.map(appointment,AppointmentDto.class);
    }



    @Override
    public List<AppointmentDto> getAllAppointments() {

        List<Appointment> appointments = appointmentRepository.findAll();

        return appointments.stream().map((appointment) -> modelMapper.map(appointment, AppointmentDto.class))
                .collect(Collectors.toList());


    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, Long id) {

        Appointment appointment  =  appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + id));

        appointment.setDate_appointment(appointmentDto.getDate_appointment());
        appointment.setName(appointmentDto.getName());
        appointment.setAppointment_u_name(appointmentDto.getAppointment_u_name());

        Appointment updatedAppointment  = appointmentRepository.save(appointment);

        return modelMapper.map(updatedAppointment,AppointmentDto.class);
    }

    @Override
    public void deleteAppointment(Long id) {


            Appointment appointment = appointmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id : " + id));

            appointmentRepository.deleteById(id);


    }




}
