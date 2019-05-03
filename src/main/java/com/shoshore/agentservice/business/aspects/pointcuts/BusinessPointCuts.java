package com.shoshore.agentservice.business.aspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BusinessPointCuts {

    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.UserService.create(..))")
    public void handleUserCreation(){

    }

    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.UserService.edit(..))")
    public void handleUserEdit(){

    }


    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.JobService.create(..))")
    public void handleJobCreation(){

    }

    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.JobService.edit(..))")
    public void handleJobEdit(){

    }


    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.PropertyService.create(..))")
    public void handlePropertyCreation(){

    }

    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.PropertyService.edit(..))")
    public void handlePropertyEdit(){

    }


    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.VehicleService.create(..))")
    public void handleVehicleCreation(){

    }

    @Pointcut("execution(* com.shoshore.agentservice.business." +
            "services.logic.api.VehicleService.edit(..))")
    public void handleVehicleEdit(){

    }

}
