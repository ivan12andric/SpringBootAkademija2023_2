package hr.kingict.springbootakademija2023_2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DashboardServiceAspect {

    Logger logger = LoggerFactory.getLogger(DashboardServiceAspect.class);

    @Before(value = "execution(* hr.kingict.springbootakademija2023_2.service.DashboardService.getDashboard(..))")
    private void beforeDashboardServiceGetDeshboard(JoinPoint joinPoint){

        logger.info(joinPoint.getTarget().getClass().getSimpleName(), "beforeDashboardServiceGetDeshboard : {0}"  );

    }
}
