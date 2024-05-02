package org.example.dollaruser.address.repository;


import java.util.List;
import java.util.Set;
import org.example.dollaruser.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByUserId(Long userId);

    @Query("SELECT a FROM Address a WHERE a.id IN (:addressIdSet)")
    List<Address> findAllByAddressIdList(Set<Long> addressIdSet);
}
