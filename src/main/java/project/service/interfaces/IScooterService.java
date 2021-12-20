package project.service.interfaces;

import project.models.Scooter;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IScooterService {
    @Transactional
    void deleteById(Long id) throws ServiceException;

    Scooter create(Scooter computerStuff)throws ServiceException, project.exception.ServiceException;

    boolean existsByName(String name) throws ServiceException, project.exception.ServiceException;

    List<Scooter> getAll()throws ServiceException, project.exception.ServiceException;
    @Transactional
    void deleteByName(String name)throws ServiceException, project.exception.ServiceException;

    Scooter getById(Long id)throws ServiceException, project.exception.ServiceException;

    Scooter getByName(String name)throws ServiceException, project.exception.ServiceException;

    @Transactional
    void updateScooterById(
            Long id,
            String name,
            String description,
            int cost)throws ServiceException, project.exception.ServiceException;
}
