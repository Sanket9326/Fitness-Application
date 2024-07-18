package com.Project.Fitness.DAO;

import com.Project.Fitness.Model.Log;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<Log, Integer> {

    @Query(value = "SELECT * FROM Log WHERE Username = :username AND Password = :password", nativeQuery = true)
    List<Log> findByUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * FROM Log WHERE Username = :username ", nativeQuery = true)
    List<Log> findByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Log WHERE Username = :username ",nativeQuery = true)
    void deleteUser(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Log SET Password = :newPassword WHERE Username = :username AND Password = :oldPassword ",nativeQuery = true)
    void updatePassword(@Param("username") String username,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);
}
