package org.sun.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sun.binding.ActivateUser;
import org.sun.binding.LoginCredentials;
import org.sun.binding.RecoverPassword;
import org.sun.binding.UserAccount;
import org.sun.service.IUserMgmtService;

import java.util.List;

@RestController
public class UserMgmtOperationsController {

    @Autowired
    private IUserMgmtService userService;

    @PostMapping("/save")
    public ResponseEntity<String>saveUser(@RequestBody UserAccount account){
        //use Service
        try{
            String resultMsg=userService.registerUser(account);
            return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/activate")
    public ResponseEntity<String>activateUser(@RequestBody ActivateUser user){

        try{
            String resultMsg=userService.activateUser(user);
            return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String>performLogin(@RequestBody LoginCredentials credentials){
        try{
            //use Service
            String resultMsg=userService.login(credentials);
            return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@GetMapping("/report")
    public ResponseEntity<?>showUsers(){
       try{
           List<UserAccount> list=userService.listUsers();
           return new ResponseEntity<List<UserAccount>>(list,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?>showUserById(@PathVariable Integer id){
        try{
            UserAccount account=userService.showUserByUserId(id);
            return new ResponseEntity<UserAccount>(account,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{email}/{name}")
    public  ResponseEntity<?>showUserByMailAndName(@PathVariable String email,@PathVariable String name){
        try{
            UserAccount account=userService.showUserByEmailAndName(email, name);
            return new ResponseEntity<UserAccount>(account,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String>updateUserDeatails(@RequestBody UserAccount account){
      try{
            String resultMsg=userService.updateUser(account);
            return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
      }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        try{
            String resultMsg=userService.deleteUserById(id);
            return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/changeStatus/{id}/{status}")
    public ResponseEntity<String>changeStatus(@PathVariable Integer id, @PathVariable String status){
        try{
            String resultMsg=userService.changeUserStatus(id,status);
            return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/recoverPassword")
    public ResponseEntity<String> recoverPassword(@RequestBody RecoverPassword recover){
        try {
            String resultMsg=userService.recoverPassword(recover);
            return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}//class
