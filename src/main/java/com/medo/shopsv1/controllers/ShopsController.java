package com.medo.shopsv1.controllers;


import com.medo.shopsv1.models.User;
import com.medo.shopsv1.repositories.ShopRepository;
import com.medo.shopsv1.models.Shop;
import com.medo.shopsv1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShopsController {

    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    /**
     *
     * @param shopRepository
     * @param userRepository
     */
    @Autowired
    public ShopsController(ShopRepository shopRepository, UserRepository userRepository) {
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;

    }


    /**
     *
     * @return
     */
    @GetMapping({"/shops"})
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/shops/user/{id}")
    public ResponseEntity<List<Shop>> getPreferredShops(@PathVariable("id") String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new ResponseEntity<>(user.getPreferredShops(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     *
     * @param id
     * @param uId
     */
    @PostMapping(value = "/shops/{id}")
    public void addToPreferredShops(@PathVariable("id") String id, @RequestBody String uId) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(uId);
        if (shopOptional.isPresent() && userOptional.isPresent()) {
            Shop shop = shopOptional.get();
            User user = userOptional.get();
            user.getPreferredShops().add(shop);
            userRepository.save(user);
        }
    }

    /**
     *
     * @param shopId
     * @param userId
     */
    @DeleteMapping(value = "/shop/{shopId}/user/{userId}")
    public void removeFromPreferredList(@PathVariable("shopId") String shopId, @PathVariable("userId") String userId) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        Optional<User> userOptional = userRepository.findById(userId);
        if (shopOptional.isPresent() && userOptional.isPresent()) {
            User user = userOptional.get();
            for (Iterator iterator = user.getPreferredShops().iterator(); iterator.hasNext(); ) {
                Shop shop = (Shop) iterator.next();
                if (shop.get_id().equals(shopOptional.get().get_id())) {
                    iterator.remove();
                }
            }
            userRepository.save(user);
        }
    }
}
