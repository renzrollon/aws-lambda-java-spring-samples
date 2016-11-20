package com.renz.examples.aws.lambda.datasource;

import org.owasp.passfault.SecureString;

/**
 * Created by renz on 10/12/16.
 */
public class DataSource {
    private String driverClassName;
    private String url;
    private String username;
    private SecureString password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password.codePoints()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public void setPassword(String password) {
        this.password = new SecureString(password.toCharArray());
    }
}
