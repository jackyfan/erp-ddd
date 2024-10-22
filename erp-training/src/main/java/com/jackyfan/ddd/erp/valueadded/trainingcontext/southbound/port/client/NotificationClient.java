package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.client;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification.Notification;

@Port(PortType.Client)
public interface NotificationClient {
    void send(Notification notification);
}

