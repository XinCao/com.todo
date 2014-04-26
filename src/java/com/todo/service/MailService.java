package com.todo.service;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author caoxin
 */
public class MailService {

//    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    /**
     * 发送普通邮件
     *
     * @param host
     * @param port
     * @param username
     * @param pwd
     * @param to
     * @param from
     * @param subject
     * @param content
     * @throws Exception
     */
    public static void sendTextMail(String host, String port, String username, String pwd, String to, String from, String subject, String content) {

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设定 Mail Server  
        senderImpl.setHost(host);

        // SMTP验证时，需要用户名和密码  
        senderImpl.setUsername(username);
        senderImpl.setPassword(pwd);

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        // props.setProperty("mail.smtp.port", "25");  

        senderImpl.setJavaMailProperties(props);
        // 建立邮件讯息  
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // 设定收件人、寄件人、主题与内文  
        mailMessage.setTo(to);
        mailMessage.setFrom(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        // 传送邮件  
        senderImpl.send(mailMessage);
//        log.info("邮件传送OK..");
        System.out.println("邮件传送OK..");
    }

    /**
     * 发送普通邮件
     *
     * @param host
     * @param port
     * @param username
     * @param pwd
     * @param to
     * @param from
     * @param subject
     * @param content
     * @throws MessagingException
     * @throws Exception
     */
    private static void sendHtmlMail(String host, String username, String pwd,
            String to, String from, String subject, String content)
            throws MessagingException {
        sendHtmlMail(host, null, username, pwd, to, from, subject, content);
    }

    /**
     * 发送普通邮件
     *
     * @param host
     * @param port
     * @param username
     * @param pwd
     * @param to
     * @param from
     * @param subject
     * @param content
     * @throws MessagingException
     * @throws Exception
     */
    public static void sendHtmlMail(String host, String port, String username,
            String pwd, String to, String from, String subject, String content)
            throws MessagingException {

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(host);
        senderImpl.setUsername(username);
        senderImpl.setPassword(pwd);

        //设置权限  
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        senderImpl.setJavaMailProperties(props);

        // 建立邮件讯息  
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

        // 设定收件人、寄件人、主题与内文  
        messageHelper.setTo(to);
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        // 传送邮件  
        senderImpl.send(mailMessage);

        System.out.println("Html邮件传送OK...");
    }

    public static void main(String[] args) throws Exception {
        String host = "SMTP.qq.com";

        String username = "510655387@qq.com";
        String pwd = "caoxinlijing";

        String to = username;
        String from = "510655387@qq.com";
        String subject = "Test";
        String content = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body><h1><a href='http://sunfish.iteye.com'>郁闷!</a></h1></body></html>";
//      sendTextMail(host, null, username, pwd, to, from, subject, content);  
        sendHtmlMail(host, username, pwd, to, from, subject, content);

    }
}
