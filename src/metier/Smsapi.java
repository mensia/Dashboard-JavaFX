/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.twilio.Twilio;

/**
 *
 * @author 21627
 */
    public class Smsapi {
     public static final String ACCOUNT_SID = "ACc683905b554c55b48b087537a9318c6f";
    public static final String AUTH_TOKEN = "245803f0ebf5e9ea2672503292a90e4c";

    /**
     * @param num     
     * @param msg     
     */
    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(num),new PhoneNumber("12293035820"), msg).create();

        System.out.println(message.getSid());
//
    }
    
}