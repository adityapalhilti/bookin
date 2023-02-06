package com.bookin.bookin.controller;


import com.bookin.bookin.kafka.Producer;
import com.bookin.bookin.requestmodels.JwtRegister;
import com.bookin.bookin.requestmodels.JwtRequest;
import com.bookin.bookin.requestmodels.JwtResponse;
import com.bookin.bookin.service.CustomUserDetailService;
import com.bookin.bookin.service.UserServiceImpl;
import com.bookin.bookin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private Producer producer;

    @GetMapping("/welcome")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @RequestMapping("/welcom")
    public String welcome()
    {
        //producer.sendMessage("topic","qwertuiop");
        return "This is private page";
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> registerUser(@RequestBody JwtRegister jwtRegister) throws Exception {
        return  ResponseEntity.ok(userServiceImpl.registerUser(jwtRegister));

    }

    @PostMapping("/generateToken")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getPassword()));

        UserDetails userDetails= customUserDetailService.loadUserByUsername(jwtRequest.getUserName());

        String jwtToken =jwtUtil.generateToken(userDetails);

        JwtResponse jwtResponse = new JwtResponse(jwtToken);
        return new ResponseEntity<JwtResponse>(jwtResponse , HttpStatus.OK);
    }
}
