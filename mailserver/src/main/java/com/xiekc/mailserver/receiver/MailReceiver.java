package com.xiekc.mailserver.receiver;

import com.xiekc.vhr.bean.Employee;
import com.xiekc.vhr.bean.Hr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-29 13:01
 **/
@Component
public class MailReceiver {
    public static final Logger LOGGER =  LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;


    @RabbitListener(queues = "xiekc.mail.welcome")
    public void StringHandler(String msg){
        System.out.println(msg);
    }


    @RabbitListener(queues = "xiekc.mail.welcome")
    public void handler(Employee employee) {
        LOGGER.info("接收=>>>"+employee.toString());
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        try {

            helper.setFrom(mailProperties.getUsername());
            helper.setTo(employee.getEmail());
            //邮件主题
            helper.setSubject("入职欢迎邮件");
            // 发送时间
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("name",employee.getName());
            context.setVariable("posName",employee.getPosition().getName());
            context.setVariable("deptName",employee.getDepartment().getName());
            context.setVariable("jobLevelName",employee.getJobLevel().getName());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail,true);
            javaMailSender.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
            LOGGER.error("邮件发送失败");
        }

    }
}
