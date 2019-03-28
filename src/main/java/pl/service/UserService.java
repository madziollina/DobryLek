package pl.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.entity.User;
import pl.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user){
        boolean hashPass=false;

        if(user.getId()==null){
            //encode password
            hashPass = true;


        } else if(user.getPassword() == null || user.getPassword().trim().length()==0){
            //check if psw not changed
            User oldUserData = userRepository.findOne(user.getId());
            user.setPassword(oldUserData.getPassword());
        } else {
            //password changed
            hashPass = true;
        }

        if(hashPass){
            String hashedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPass);
        }

        userRepository.save(user);
    }

    public User checkLogin(String email, String password) throws Exception {

        User user = userRepository.findOneByEmail(email);
        if(user==null){
            throw new Exception("User not found!");
        }

        if(BCrypt.checkpw(password, user.getPassword())){
            return user;
        } else {
            throw new Exception("Wrong user or password");
        }
    }
}
