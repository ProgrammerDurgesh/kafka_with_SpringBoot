package durgeshkafka.common;
/**
 * @author durgesh
 */
public class Constant {

    public static class OTP {
        public static final String OTP_SENT = "OTP sent successfully";
        public static final String OTP_EXPIRE = "Otp is expired";
        public static final String OTP_INVALID = "Otp is Invalid";
        public static final String OTP_MATCHED = "Otp is matched";
        public static final String VERIFY_OTP = "Please Verify OTP";
        public static final String GENERATE_OTP = "Please Generate OTP";
    }
    public static class AUTH {

        public static final String USER_LOGIN="User Login Successfully ";
        public static final String USER_LOGIN_FAILED="User Login failed ";
        public static final String PASSWORD_INCORRECT = "password Incorrect";

    }
    public static class User {
        public static final String EMAIL_EXISTS = "Email already exists, Please try with another email";
        public static final String EMAIL_NOT_EXISTS = "Email not exists, Please try with another email";
        public static final String USER_LOGIN="User Login Successfully ";
        public static final String USER_LOGIN_FAILED="User Login failed ";
        public static final String PASSWORD_MISMATCH = "Password and confirm password does not match";
        public static final String PASSWORD_UPDATED = "Password Updated Successfully";
        public static final String VALID_TOKEN = "Token is valid";
        public static final String ALL_TOKEN_EXPIRED = "All Token Expired Successfully";
        public static final String USER_CREATED = "User Created Successfully";
        public static final String USER_FOUND = "User found successfully";
        public static final String USER_NOT_FOUND = "User Not Found";
        public static final String USER_UPDATE = "User update successfully";
        public static final String EMAIL_SENT = "Email sent successfully";

    }

}
