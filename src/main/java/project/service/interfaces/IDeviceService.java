package project.service.interfaces;

import project.models.Device;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IDeviceService {
    @Transactional
    void deleteById(Long id) throws ServiceException;

    Device create(Device computerStuff)throws ServiceException, project.exception.ServiceException;

    boolean existsByName(String name) throws ServiceException, project.exception.ServiceException;

    List<Device> getAll()throws ServiceException, project.exception.ServiceException;
    @Transactional
    void deleteByName(String name)throws ServiceException, project.exception.ServiceException;

    Device getById(Long id)throws ServiceException, project.exception.ServiceException;

    Device getByName(String name)throws ServiceException, project.exception.ServiceException;

    @Transactional
    void updateDeviceById(
            Long id,
            String name,
            String description,
            int cost)throws ServiceException, project.exception.ServiceException;
}
