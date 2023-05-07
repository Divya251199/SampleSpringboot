package com.example.EcommerceAPI.service;

import com.example.EcommerceAPI.Repository.IAddressRepository;
import com.example.EcommerceAPI.Repository.IOrderRepository;
import com.example.EcommerceAPI.Repository.IProductRepository;
import com.example.EcommerceAPI.Repository.IUserRepository;
import com.example.EcommerceAPI.model.Address;
import com.example.EcommerceAPI.model.Order;
import com.example.EcommerceAPI.model.Product;
import com.example.EcommerceAPI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IProductRepository productRepository;

    public String addOrders(Order order) {
        Users user = order.getUserId();
        Address address = order.getAddressId();
        Product product = order.getProductId();

        Optional<Users> userList =  userRepository.findById(user.getUserId());

        Optional<Address> addressList =  addressRepository.findById(address.getAddressId());

        Optional<Product> productList = productRepository.findById(product.getProductId());

        if ( userList.isEmpty() ) {
            return "Enter the correct userId";
        } else if (addressList.isEmpty()) {
            return "Enter the correct addressId";
        } else if (productList.isEmpty()) {
            return "Enter the correct projectId";
        } else  {
            order.setUserId(userList.get());
            order.setAddressId(addressList.get());
            order.setProductId(productList.get());
            orderRepository.save(order);
            return "Order successfully placed!!!";
        }
    }

    public Order getOrders(Integer orderId) {
        Optional<Order> orders = orderRepository.findById(orderId);
        if (orders.isEmpty()) {
            throw new IllegalStateException("User with orderId: " + orderId + " not found!!" );
        }
        else {
            return orders.get();
        }
    }
}
