package com.example.bilota.repo;

import com.example.bilota.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Userr,Integer> {

    @Query(value = "select id, name from userr", nativeQuery = true)
    List<Userr> findUser();

//    @Transactional
    @Modifying
    @Query(value = "update userr set name = :name where id in :id",nativeQuery = true)
    int updateUser(@Param("name") String name,@Param("id") List<Integer> id);

    //.save(Obj) for saving and updating
    //.getAllUsers()
    //.findById(int id)/getUser(int id)
    //delete(obj)
}
