<<<<<<< HEAD
package co.edu.unbosque.util;

import java.util.Properties;
import java.util.Random;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/*
 * Clase que permite generar códigos de verificación
 * y enviarlos por correo electrónico mediante SMTP.
 */
public class EmailService {

    private static final String EMISOR = "bossstinder@gmail.com";
    private static final String CONTRASENA = "wnxf soxh htpo hqzc";
    private static final String ASUNTO = "Código de verificación - Bostinder";

    /*
     * Genera un código aleatorio de 6 dígitos.
     * 
     * @return cadena que contiene el código generado
     */
    public static String generarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000);
        return String.valueOf(codigo);
    }

    /*
     * Envía un correo electrónico con un código de verificación al destinatario.
     * 
     * @param destinatario correo al que se enviará el código
     * @param codigo código de verificación que se desea enviar
     */
    public static void enviarCodigo(String destinatario, String codigo) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMISOR, CONTRASENA);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(EMISOR));
        mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(ASUNTO);
        mensaje.setText("Tu código de verificación es: " + codigo);

        Transport.send(mensaje);
    }
}
=======
package co.edu.unbosque.util;

import java.util.Properties;
import java.util.Random;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/*
 * Clase que permite generar códigos de verificación
 * y enviarlos por correo electrónico mediante SMTP.
 */
public class EmailService {

    private static final String EMISOR = "bossstinder@gmail.com";
    private static final String CONTRASENA = "wnxf soxh htpo hqzc";
    private static final String ASUNTO = "Código de verificación - Bostinder";

    /*
     * Genera un código aleatorio de 6 dígitos.
     * 
     * @return cadena que contiene el código generado
     */
    public static String generarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000);
        return String.valueOf(codigo);
    }

    /*
     * Envía un correo electrónico con un código de verificación al destinatario.
     * 
     * @param destinatario correo al que se enviará el código
     * @param codigo código de verificación que se desea enviar
     */
    public static void enviarCodigo(String destinatario, String codigo) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMISOR, CONTRASENA);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(EMISOR));
        mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(ASUNTO);
        mensaje.setText("Tu código de verificación es: " + codigo);

        Transport.send(mensaje);
    }
}
>>>>>>> branch 'master' of https://github.com/0hsamm/Proyecto-final
