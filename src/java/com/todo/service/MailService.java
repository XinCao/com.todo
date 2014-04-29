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

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

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
     */
    public static void sendTextMail(String host, String port, String username, String pwd, String to, String from, String subject, String content) {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(host); // 设定 Mail Server  
        senderImpl.setUsername(username); // SMTP验证时，需要用户名和密码
        senderImpl.setPassword(pwd);
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        // props.setProperty("mail.smtp.port", "25");  
        senderImpl.setJavaMailProperties(props);
        SimpleMailMessage mailMessage = new SimpleMailMessage(); // 建立邮件讯息  
        mailMessage.setTo(to); // 设定收件人、寄件人、主题与内文
        mailMessage.setFrom(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        senderImpl.send(mailMessage); // 传送邮件
        logger.info("邮件传送OK..");
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
    private static void sendHtmlMail(String host, String username, String pwd, String to, String from, String subject, String content) throws MessagingException {
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
     */
    public static void sendHtmlMail(String host, String port, String username, String pwd, String to, String from, String subject, String content) throws MessagingException {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(host);
        senderImpl.setUsername(username);
        senderImpl.setPassword(pwd);
        Properties props = new Properties(); // 设置权限
        props.setProperty("mail.smtp.auth", "true");
        senderImpl.setJavaMailProperties(props);
        MimeMessage mailMessage = senderImpl.createMimeMessage(); // 建立邮件讯息
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
        messageHelper.setTo(to); // 设定收件人、寄件人、主题与内文
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        senderImpl.send(mailMessage); // 传送邮件
        logger.info("Html邮件传送OK...");
    }

    public static void sendActivitedLink(String domain, String url, String toEmail) {
        String host = "SMTP.126.com";
        String username = "jingxin191314@126.com";
        String pwd = "jingxin1314";
        String from = "jingxin191314@126.com";
        String subject = "欢迎使用Todo";
        String content = 
                "<html>"
                +   "<head>"
                +       "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">"
                +   "</head>"
                +   "<body>"
                +       "<h1>"
                +           "<a href='http://"+ domain + url +"'><strong>点击激活Todo</strong></a>"
                +       "</h1>"
                +   "</body>"
                + "</html>";
        try {
            sendHtmlMail(host, username, pwd, toEmail, from, subject, content);
        } catch (MessagingException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        String host = "SMTP.126.com";
        String username = "jingxin191314@126.com";
        String pwd = "jingxin1314";
        String to = username;
        String from = "jingxin191314@126.com";
        String subject = "Test";
        String content = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body><h1><a href='http://sunfish.iteye.com'><strong>点击激活Todo</strong></a></h1></body></html>";
//      sendTextMail(host, null, username, pwd, to, from, subject, content);  
        sendHtmlMail(host, username, pwd, to, from, subject, content);

    }
}