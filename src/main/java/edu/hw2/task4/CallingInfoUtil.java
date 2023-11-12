package edu.hw2.task4;

public final class  CallingInfoUtil {
    private CallingInfoUtil() {
    }

    public static CallingInfo getInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        if (stackTrace.length >= 2) {
            String className = stackTrace[1].getClassName();
            String methodName = stackTrace[1].getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return null;
        }
    }

}

