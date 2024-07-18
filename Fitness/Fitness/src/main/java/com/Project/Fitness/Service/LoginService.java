package com.Project.Fitness.Service;

import com.Project.Fitness.DAO.LogRepo;
import com.Project.Fitness.Model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    LogRepo logRepo;

    public ResponseEntity<String> loginVerify(String username, String password) {
        try {
            List<Log> curr = logRepo.findByUser(username, password);
            if (!curr.isEmpty()) {
                return new ResponseEntity<>("Verified", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid User", HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> registerNewUser(String username, String password) {
        try{
             if(!(logRepo.findByUsername(username).isEmpty())){
                 return new ResponseEntity<>("Username Already Exists", HttpStatus.CONFLICT);
             }
             Log log = new Log();
             log.setUsername(username);
             log.setPassword(password);
             logRepo.save(log);
             return new ResponseEntity<>("New User Added", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteUser(String username) {
        try{
            logRepo.deleteUser(username);
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean verify(String username){
        List<Log> curr = logRepo.findByUsername(username);
        if(curr.isEmpty()){
            return false;
        }
        return true;
    }

    public ResponseEntity<String> updatePassword(String username, String oldPassword, String newPassword) {
        try{
            if (!logRepo.findByUsername(username).isEmpty()){
                logRepo.updatePassword(username,oldPassword,newPassword);
                return new ResponseEntity<>("Password Updated", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Invalid User", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error Updating Password", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> findPassword(String username) {
        try{
            List<Log> curr = logRepo.findByUsername(username);
            return new ResponseEntity<>(curr.get(0).getPassword(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error Recovering Password", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
