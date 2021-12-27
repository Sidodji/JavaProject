package project.service;

import project.exception.RepositoryException;
import project.exception.ServiceException;
import project.models.Device;
import project.repository.DeviceRepository;
import project.service.interfaces.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService implements IDeviceService{
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public Device create(Device Device)throws ServiceException {
        return deviceRepository.save(Device);
    }

    @Override
    public boolean existsByName(String name) throws ServiceException {
        try {
            return deviceRepository.existsByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Device> getAll()throws ServiceException {
        return deviceRepository.findAll();
    }

    @Override
    public void deleteByName(String name)throws ServiceException {
        try {
            deviceRepository.deleteByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public Device getById(Long id)throws ServiceException {
        try {
            return deviceRepository.getById(id);
        } catch (Exception e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public Device getByName(String name)throws ServiceException {
        try {
            return deviceRepository.getByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }

    @Override
    public void updateDeviceById(Long id, String name, String description, int cost ) throws ServiceException{
        try {
            deviceRepository.updateDeviceById(id, name, description, cost);
        } catch (RepositoryException e) {
            throw new ServiceException(e);

        }
    }
}
