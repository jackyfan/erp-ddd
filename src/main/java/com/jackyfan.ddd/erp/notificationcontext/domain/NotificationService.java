package com.ddd.rsa.notificationcontext.domain;

import com.ddd.rsa.notificationcontext.southbound.adapter.client.CustomerClient;
import com.ddd.rsa.notificationcontext.southbound.message.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private CustomerClient customerClient;
    //@Autowired
    //private SmsClient smsClient;
    public void notify(Notification notification) {
        //CustomerResponse customerResponse = customerClient.customerOf(notification.to().id());
        //notification.filledWith(customerResponse.to());
        //smsClient.send(notification.to().phoneNumber(), notification.content());
    }
}
