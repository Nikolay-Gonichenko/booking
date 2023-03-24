package ru.itmo.booking.service;

import ru.itmo.booking.model.dto.OrderDto;

public interface OrderService {

    Long createOrder(OrderDto orderDto);
}
