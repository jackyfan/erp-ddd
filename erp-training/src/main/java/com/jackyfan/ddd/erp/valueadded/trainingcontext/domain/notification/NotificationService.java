package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification;

import com.jackyfan.ddd.core.stereotype.DomainService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Nominator;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Nominee;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Ticket;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate.ValidDate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate.ValidDateException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate.ValidDateType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.client.NotificationClient;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.MailTemplateRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TrainingRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.ValidDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@DomainService
public class NotificationService {
    @Autowired
    private MailTemplateRepository templateRepository;
    @Autowired
    private NotificationClient notificationClient;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private ValidDateRepository validDateRepository;

    public void notifyNominee(Ticket ticket, Nominator nominator, Nominee nominee) {
        MailTemplate mailTemplate = retrieveMailTemplate();
        Training training = retrieveTraining(ticket);
        ValidDate validDate = retrieveValidDate(ticket);

        VariableContext variableContext = buildVariableContext(ticket, nominator, nominee, training, validDate);
        Notification notification = mailTemplate.compose(variableContext);

        notificationClient.send(notification);
    }

    private MailTemplate retrieveMailTemplate() {
        Optional<MailTemplate> optionalMailTemplate = templateRepository.of(TemplateType.Nomination);
        String mailTemplateNotFoundMessage = String.format("mail template by %s was not found.", TemplateType.Nomination);
        return optionalMailTemplate.orElseThrow(() -> new MailTemplateException(mailTemplateNotFoundMessage));
    }

    private Training retrieveTraining(Ticket ticket) {
        Optional<Training> optionalTraining = trainingRepository.of(ticket.trainingId());
        String trainingNotFoundMessage = String.format("training by id {%s} was not found.", ticket.trainingId());
        return optionalTraining.orElseThrow(() -> new TrainingException(trainingNotFoundMessage));
    }

    private ValidDate retrieveValidDate(Ticket ticket) {
        Optional<ValidDate> optionalValidDate = validDateRepository.of(ticket.trainingId(), ValidDateType.PODeadline);
        String validDateNotFoundMessage = String.format("valid date by training id {%s} was not found.", ticket.trainingId());
        return optionalValidDate.orElseThrow(() -> new ValidDateException(validDateNotFoundMessage));
    }

    private VariableContext buildVariableContext(Ticket ticket, Nominator nominator, Nominee nominee, Training training, ValidDate validDate) {
        VariableContext variableContext = new VariableContext();
        variableContext.put("ticket", ticket);
        variableContext.put("training", training);
        variableContext.put("valid_date", validDate);
        variableContext.put("nominator", nominator);
        variableContext.put("nominee", nominee);
        return variableContext;
    }

    public void setMailTemplateRepository(MailTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public void setNotificationClient(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void setTrainingRepository(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void setValidDateRepository(ValidDateRepository validDateRepository) {
        this.validDateRepository = validDateRepository;
    }
}