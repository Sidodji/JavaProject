package project.service;

import project.exception.RepositoryException;
import project.exception.ServiceException;
import project.models.RentForm;
import project.repository.UserRentFormRepository;
import project.service.interfaces.IUserRentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserRentFormService implements IUserRentFormService {
    @Autowired
    private UserRentFormRepository userRentFormRepository;
    @Override
    public void deleteById(Long id) {
        userRentFormRepository.deleteById(id);
    }

    @Override
    public void deleteByUserIdAndDeviceId(Long user_id, Long deviceStuff_id) throws ServiceException {
        try {
            userRentFormRepository.deleteByUserIdAndDeviceId(user_id, deviceStuff_id);
        } catch (RepositoryException e) {

            throw new ServiceException(e);
        }
    }

    @Override
    public RentForm create(RentForm userRentForm){
        return userRentFormRepository.save(userRentForm);
    }

    @Override
    public boolean existsByDeviceId(Long deviceStuff_id) throws ServiceException {
        try {
            return userRentFormRepository.existsByDeviceId(deviceStuff_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public RentForm getById(Long id)throws ServiceException {
        return userRentFormRepository.getById(id);
    }

    @Override
    public List<RentForm> getAllByUserId(Long user_id)throws ServiceException {
        try {
            return userRentFormRepository.getAllByUserId(user_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public List<RentForm> getAllByRent(boolean rent)throws ServiceException {
        try {
            return userRentFormRepository.getAllByRent(rent);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public List<RentForm> getAllByDeviceExpirationDateLessThan(Date deviceStuff_expirationDate) throws ServiceException{
        try {
            return userRentFormRepository.getAllByDeviceExpirationDateLessThan(deviceStuff_expirationDate);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public void setUserRentFormById(Long id, boolean rent) throws ServiceException{
        try {
            userRentFormRepository.setUserRentFormById(id, rent);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }
}
