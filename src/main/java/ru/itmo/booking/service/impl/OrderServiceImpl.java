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

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Order> orders = orderRepository.findAll()
                .stream().filter(order -> order.getRoom().getId().equals(orderDto.getRoomId()))
                .filter(order -> {
                    Date date = order.getTimeStart();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);

                    Date dateFromDto = orderDto.getTimeStart();
                    Calendar calendarFromDto = Calendar.getInstance();
                    calendarFromDto.setTime(dateFromDto);

                    if (calendar.get(Calendar.YEAR) != calendarFromDto.get(Calendar.YEAR))
                        return false;
                    if (calendar.get(Calendar.MONTH) != calendarFromDto.get(Calendar.MONTH))
                        return false;
                    if (calendar.get(Calendar.DAY_OF_MONTH) != calendarFromDto.get(Calendar.DAY_OF_MONTH))
                        return false;
                    return true;
                })
                .filter(order -> {
                    Date dateStart = order.getTimeStart();
                    Date dateFinish = order.getTimeFinish();

                    if (orderDto.getTimeStart().before(dateFinish) && orderDto.getTimeStart().after(dateStart))
                        return true;
                    if (orderDto.getTimeFinish().before(dateFinish) && orderDto.getTimeFinish().after(dateStart))
                        return true;
                    return false;
                })
                .collect(Collectors.toList());

        if (orders.size() == 0) {
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
