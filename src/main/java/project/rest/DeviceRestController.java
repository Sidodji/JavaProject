package project.rest;

import project.dto.NameRequest;
import project.dto.DeviceRequestNoIdRent;
import project.dto.DeviceRequestNoRent;
import project.exception.ControllerException;
import project.exception.RepositoryException;
import project.exception.ServiceException;
import project.models.Device;
import project.repository.UserRentFormRepository;
import project.service.DeviceService;
import project.service.UserRentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class DeviceRestController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserRentFormService userRentFormService;
    @Autowired
    private UserRentFormRepository userRentFormRepository;
    @PostMapping("/admin/createDevice")
    public ResponseEntity<?> createDevice(@RequestBody DeviceRequestNoIdRent deviceRequestNoIdRent) throws ControllerException {
        Device stuff = new Device(
                deviceRequestNoIdRent.getName(),
                deviceRequestNoIdRent.getDescription(),
                deviceRequestNoIdRent.getCost(),
                deviceRequestNoIdRent.getExpirationDate()
        );
        try {
            deviceService.create(stuff);
            return new ResponseEntity<>(stuff, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @DeleteMapping("/admin/deleteDeviceByNameA")
    public ResponseEntity<?> deleteDeviceByNameA(@RequestBody NameRequest nameRequest) throws ControllerException {
        try {
            Device man = deviceService.getByName(nameRequest.getName());
            deviceService.deleteByName(nameRequest.getName());
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @PutMapping("/admin/updateDevice")
    public ResponseEntity<?> updateDevice(@RequestBody DeviceRequestNoRent DeviceRequestNoRent)throws ControllerException {
        try {
            Device man = deviceService.getById( DeviceRequestNoRent.getId());
            deviceService.updateDeviceById(
                    DeviceRequestNoRent.getId(),
                    DeviceRequestNoRent.getName(),
                    DeviceRequestNoRent.getDescription(),
                    DeviceRequestNoRent.getCost()
            );
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }
    }
    @DeleteMapping("/user/deleteDeviceByNameU")
    public ResponseEntity<?> deleteDeviceByNameU(@RequestBody NameRequest nameRequest)throws ControllerException {

        try {
            Device man = deviceService.getByName(nameRequest.getName());
            userRentFormRepository.deleteByUserName(nameRequest.getName());
            return new ResponseEntity<>(man, HttpStatus.OK);
        } catch (ServiceException | RepositoryException e ) {
            throw new ControllerException(e);

        }


    }
    @GetMapping("/admin/getAllCompsForAdmin")
    public ResponseEntity<?> getAllCompsForAdmin() throws ControllerException{
        try {
            return new ResponseEntity<>(deviceService.getAll(),HttpStatus.OK);
        } catch (ServiceException e) {

            throw new ControllerException(e);

        }
    }
    @PostMapping("/admin/isDeviceExistByName")
    public ResponseEntity<?> isDeviceExistByName(@RequestBody NameRequest nameRequest) throws ControllerException{
        try {
            if(!deviceService.existsByName(nameRequest.getName())){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.FOUND);
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }

    }
    @GetMapping("/user/userGetDeviceByName/{name}")
    public ResponseEntity<?> userGetDeviceByName(@PathVariable(name = "name")String name)throws ControllerException {
        Device stuff = null;
        try {
            stuff = deviceService.getByName(name);
            return new ResponseEntity<>(stuff,HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    @GetMapping("admin/adminGetDeviceByName/{name}")
    public ResponseEntity<?> adminGetDeviceByName(@PathVariable(name = "name")String name) throws ParseException, ControllerException {
        Device stuff = null;
        try {
            stuff = deviceService.getByName(name);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(stuff.getExpirationDate());
            System.out.println(date);
            stuff.setExpirationDate(simpleDateFormat.parse(date));
            return new ResponseEntity<>(stuff,HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }

    }
    @GetMapping("/user/getAllCompsForUser")
    public ResponseEntity<?> getAllCompsForUser()throws ControllerException {
        try {
            return new ResponseEntity<>(deviceService.getAll(),HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);

        }
    }
}
