package com.example.removebg.service;

import com.example.removebg.entity.OrderEntity;
import com.example.removebg.repository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService{

    private RazorpayServiceImpl razorpayService;
    private OrderRepository orderRepository;

    private static final Map<String, PlanDetails> PLAN_DETAILS_MAP = Map.of(
            "Basic", new PlanDetails("Basic", 100, 499.00),
            "Premium", new PlanDetails("Basic", 250, 899.00),
            "Ultimate", new PlanDetails("Basic", 100, 1499.00)
    );

    private record PlanDetails(String name, int credits, double amount){

    }

    public Order createOrder(String planId, String clerkId) throws RazorpayException{
        PlanDetails details = PLAN_DETAILS_MAP.get(planId);
        if(details==null){
            throw new IllegalArgumentException("Invalid planId: "+planId);
        }
        try{
            Order razorpayOrder = razorpayService.createOrder(details.amount(), "INR");

            OrderEntity newOrder = OrderEntity.builder()
                    .clerkId(clerkId)
                    .plan(details.name())
                    .credits(details.credits())
                    .amount(details.amount())
                    .orderId(razorpayOrder.get("id"))
                    .build();
            orderRepository.save(newOrder);
            return razorpayOrder;
        } catch(RazorpayException e){
            throw new RazorpayException("Error while creating the order", e);
        }

    }
}
