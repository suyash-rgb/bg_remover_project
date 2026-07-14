package com.example.removebg.service;

import com.example.removebg.dto.UserDTO;
import com.example.removebg.entity.OrderEntity;
import com.example.removebg.repository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToLongFunction;

@Service
public class RazorpayServiceImpl implements IRazorpayService
{

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    private OrderRepository orderRepository;

    private UserServiceImpl userService;

    public Order createOrder(Double amount, String currency) throws RazorpayException{
        try{
            RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount*100);
            orderRequest.put("currency", currency);
            orderRequest.put("receipt", "order_rcptid_"+System.currentTimeMillis());
            orderRequest.put("payment_capture", 1);

            return razorpayClient.orders.create(orderRequest);

        } catch(RazorpayException e){
            e.printStackTrace();
            throw new RazorpayException("Razorpay error: "+e.getMessage());
        }
    }

    public Map<String, Object> verifyPayment(String razorpayOrderId) throws RazorpayException{
        Map<String, Object> returnValue = new HashMap<>();
        try{
            RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
            Order orderInfo = razorpayClient.orders.fetch(razorpayOrderId);
            if(orderInfo.get("status").toString().equalsIgnoreCase("paid")){
                OrderEntity existingOrder = orderRepository.findByOrderId(razorpayOrderId)
                        .orElseThrow(()-> new RuntimeException("Order not found: " +razorpayOrderId));

                if(existingOrder.getPayment()){
                    returnValue.put("Success", false);
                    returnValue.put("Message", "Payment failed");
                    return returnValue;
                }

                UserDTO userDTO = userService.getUserByClerkId(existingOrder.getClerkId());
                userDTO.setCredits(userDTO.getCredits()- existingOrder.getCredits());

                userService.saveUser(userDTO);
                existingOrder.setPayment(true);
                orderRepository.save(existingOrder);
                returnValue.put("Success", true);
                returnValue.put("message", "Credits Added");
            }
        } catch(RazorpayException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while verifying the payment");
        }
        return returnValue;
    }
}
