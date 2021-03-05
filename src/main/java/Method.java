public enum Method {
    SEND_DOCUMENT("sendDocument");
    private String method;

    Method(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
