package com.wmm.utils;

public class MaskUtil {

    public static String maskPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return phone;
        }
        if (phone.length() == 11) {
            return phone.substring(0, 3) + "****" + phone.substring(7);
        }
        return phone.charAt(0) + "****" + phone.substring(phone.length() - 2);
    }

    public static String maskIdCard(String idCard) {
        if (idCard == null || idCard.isEmpty()) {
            return idCard;
        }
        if (idCard.length() >= 8) {
            return idCard.substring(0, 4) + "**********" + idCard.substring(idCard.length() - 4);
        }
        return "****";
    }
}