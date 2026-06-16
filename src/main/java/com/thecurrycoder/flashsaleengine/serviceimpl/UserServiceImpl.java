package com.thecurrycoder.flashsaleengine.serviceimpl;

import com.thecurrycoder.flashsaleengine.dto.request.AddressDTO;
import com.thecurrycoder.flashsaleengine.dto.request.RegisterUser;
import com.thecurrycoder.flashsaleengine.model.Address;
import com.thecurrycoder.flashsaleengine.model.Role;
import com.thecurrycoder.flashsaleengine.model.User;
import com.thecurrycoder.flashsaleengine.repository.RoleRepo;
import com.thecurrycoder.flashsaleengine.repository.UserRepo;
import com.thecurrycoder.flashsaleengine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepo userRepo;
    public final RoleRepo roleRepo;

    @Override
    public boolean registerUser(RegisterUser registerUser) {
        //First check if the User is Present then Provide a Exception Saying 409 , 500
        Optional<User> rawuser = userRepo.findByEmail(registerUser.getEmail());
        if(rawuser.isPresent())
        {
            return false;
        }

        User user = new User();

        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPhoneNumber(registerUser.getPhone());

        Role role =  roleRepo.findByRole("ROLE_CUSTOMER");

        if(role==null)
        {
            throw  new RuntimeException("ROLE_CUSTOMER is Not Found ");

        }
        user.setRoles(List.of(role));
        //Set the Address
        AddressDTO addressDTO = registerUser.getAddress();

        Address address = new Address();
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(address.getCity());
        address.setState(addressDTO.getState());
        address.setZip(addressDTO.getZip());
        address.setUser(user);

        user.setAddresses(List.of(address));

        userRepo.save(user);



        return true;
    }
}
