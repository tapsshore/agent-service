package com.shoshore.agentservice.business.criteria.mapper;

import com.shoshore.agentservice.domain.entities.Job;
import com.shoshore.agentservice.domain.entities.Property;
import com.shoshore.agentservice.domain.entities.User;
import com.shoshore.agentservice.domain.entities.Vehicle;
import com.shoshore.agentservice.utils.enums.JobSector;
import com.shoshore.agentservice.utils.messages.external.JobDto;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.external.VehicleDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DtoMapper {

    public abstract UserDto map(User user);

    public abstract User map(UserDto userDto);

    public abstract List<User> mapUser(List<User> users);


    public abstract JobDto map(ServiceResponse serviceResponse);


    public abstract VehicleDto map(Vehicle vehicle);

    public abstract Vehicle map(VehicleDto vehicleDto);


    public abstract JobDto map(JobSector job);

    public abstract Job map(JobDto jobDto);


    public abstract PropertyDto map(Property property);

    public abstract Property map(PropertyDto propertyDto);

}
