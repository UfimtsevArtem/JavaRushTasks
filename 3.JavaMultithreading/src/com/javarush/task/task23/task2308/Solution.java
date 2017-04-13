package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {


    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("User is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("User is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }
    public static final class Constants extends Exception {
        public final static String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public final static String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public final static String USER_IS_BANNED = "User is banned.";
        public final static String ACCESS_IS_DENIED = "Access is denied.";
    }
    public static void main(String[] args) {

    }
}
