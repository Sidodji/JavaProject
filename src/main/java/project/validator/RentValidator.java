package project.validator;

import project.models.RentForm;
import project.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RentForm deviceStuff = (RentForm)o;
        if(deviceStuff.getId()<0){
            errors.rejectValue("id","negative value");
        }
    }
}
