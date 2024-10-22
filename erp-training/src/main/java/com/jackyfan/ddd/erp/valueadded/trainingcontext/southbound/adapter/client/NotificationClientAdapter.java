package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.adapter.client;

import com.jackyfan.ddd.core.stereotype.Adapter;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification.Notification;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.client.NotificationClient;
import org.springframework.stereotype.Component;

@Adapter(PortType.Client)
@Component
public class NotificationClientAdapter implements NotificationClient {
    @Override
    public void send(Notification notification) {
        System.out.println("send the notification:" + notification.toString());
    }
}
