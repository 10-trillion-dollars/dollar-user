package org.example.dollaruser.address.repository;


import java.util.List;
import org.example.dollaruser.address.entity.Address;
import org.example.dollaruser.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUser(User user);
}
