package project.service.interfaces;

import project.models.RentForm;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface IUserRentFormService {
    @Transactional
    void deleteById(Long id)throws ServiceException;
    @Transactional
    void deleteByUserIdAndDeviceId(Long user_id, Long deviceStuff_id) throws ServiceException, project.exception.ServiceException;

    RentForm create(RentForm userRentForm)throws ServiceException, project.exception.ServiceException;
    boolean existsByDeviceId(Long deviceStuff_id) throws ServiceException, project.exception.ServiceException;
    RentForm getById(Long id)throws ServiceException, project.exception.ServiceException;

    List<RentForm> getAllByUserId(Long user_id)throws ServiceException, project.exception.ServiceException;
    List<RentForm> getAllByRent(boolean rent)throws ServiceException, project.exception.ServiceException;

    List<RentForm> getAllByDeviceExpirationDateLessThan(Date deviceStuff_expirationDate)throws ServiceException, project.exception.ServiceException;
    @Transactional
    void setUserRentFormById(Long id, boolean rent)throws ServiceException, project.exception.ServiceException;
}
