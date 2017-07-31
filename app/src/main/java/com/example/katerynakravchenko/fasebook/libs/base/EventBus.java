package com.example.katerynakravchenko.fasebook.libs.base;

/**
 * Created by katerynakravchenko on 17.07.17.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}