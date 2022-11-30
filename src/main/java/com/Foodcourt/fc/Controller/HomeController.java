package com.Foodcourt.fc.Controller;

import com.Foodcourt.fc.Entity.Items;
import com.Foodcourt.fc.dto.BillDTO;
import com.Foodcourt.fc.dto.EmailDTO;
import com.Foodcourt.fc.dto.ItemsDetailsDTO;
import com.Foodcourt.fc.dto.OrderDTO;
import com.Foodcourt.fc.service.*;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin
@RestController
public class HomeController {


    Map<String,Integer> map=new HashMap<>();

    @Autowired
    EmailService emailService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @PostMapping("/save-order")
    public ResponseEntity<Object> saveOrder(@RequestBody OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
        return new ResponseEntity<>("Order saved",HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> getFavorites(@RequestBody ItemsDetailsDTO itemsDetailsDTO)
    {
        return new ResponseEntity<>(itemService.save(itemsDetailsDTO), HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<Object> fetchFavorites(@RequestParam("category") String category)
    {
//        System.out.print(dish_name);
        return new ResponseEntity<Object>(itemService.fetch(category),HttpStatus.OK);
    }

    @GetMapping("/category")
    public List<String> getCategory()
    {
        return itemService.category();
    }

    @GetMapping("/delete")
    public void deleteFavorites(@RequestParam("dishName") String dishName)
    {
        itemService.delete(dishName);
    }

    @GetMapping("/modify")
    public void modifyFavorites(@RequestBody Items items)
    {
        itemService.modify(items);
    }

    @GetMapping("/every")
    public ResponseEntity<Object> everyFavorites()
    {
//        System.out.print(dish_name);
        return new ResponseEntity<Object>(itemService.fetchall(),HttpStatus.OK);
    }
    @PostMapping("/mails")
    public ResponseEntity<Object> mails(@RequestBody EmailDTO emailDTO)
    {
        if(emailService.send(emailDTO))
        {
            return new ResponseEntity<>("Email Sent",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Email not sent",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/bill")
    public ResponseEntity<Object> bill(@RequestBody BillDTO billDTO)
    {
        EmailDTO emailDTO=new EmailDTO();
        emailDTO.setTo(billDTO.getEmail_id());
        Random random=new Random();
        int otp=100000+random.nextInt(900000);
        map.put(billDTO.getEmail_id(), otp);
        emailDTO.setSubject("Order Successfull");
        emailDTO.setBody("Your bill id ="+billDTO.getBill_id()+" Otp= "+otp);
        if(emailService.send(emailDTO))
        {
            return new ResponseEntity<>("Email Sent",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Email not sent",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reqotp")
    public  ResponseEntity<Object> reqotp(@RequestParam (value = "email")String email)
    {
        if(map.containsKey(email))
        {
            return new ResponseEntity<>(map.get(email),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Mail not found",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/orderready")
    public  ResponseEntity<Object> orderready(@RequestParam(value="email")String email)
    {
        EmailDTO emailDTO=new EmailDTO();
        emailDTO.setTo(email);
        emailDTO.setSubject("Order Status");
        emailDTO.setBody("Your order is Ready!!");
        if(emailService.send(emailDTO))
        {
            return new ResponseEntity<>("Email Sent",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Email not sent",HttpStatus.BAD_REQUEST);
        }

    }


}
