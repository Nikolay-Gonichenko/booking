package ru.itmo.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.booking.model.Order;
import ru.itmo.booking.model.Room;
import ru.itmo.booking.model.User;
import ru.itmo.booking.model.dto.OrderDto;
import ru.itmo.booking.repository.OrderRepository;
import ru.itmo.booking.repository.RoomRepository;
import ru.itmo.booking.repository.UserRepository;
import ru.itmo.booking.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    //todo прописать все findById
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long createOrder(OrderDto orderDto) {
        User user = userRepository.getById(orderDto.getUserId());
        Room room = roomRepository.getById(orderDto.getRoomId());
        if (orderRepository.findBetweenDate(orderDto.getTimeStart(), orderDto.getTimeFinish(), room.getId())) {
            Order order = new Order();
            order.setRoom(room);
            order.setUser(user);
            order.setTimeStart(orderDto.getTimeStart());
            order.setTimeFinish(orderDto.getTimeFinish());
            orderRepository.save(order);
            return order.getId();
        }

        return null;
    }
}
