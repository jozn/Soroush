package org.jivesoftware.smack.util.dns;

import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

public class HostAddress {
    private Exception exception;
    private final String fqdn;
    private final int port;

    public HostAddress(String str) {
        this(str, 5222);
    }

    public HostAddress(String str, int i) {
        Objects.requireNonNull(str, "FQDN is null");
        if (i < 0 || i > InBandBytestreamManager.MAXIMUM_BLOCK_SIZE) {
            throw new IllegalArgumentException("Port must be a 16-bit unsiged integer (i.e. between 0-65535. Port was: " + i);
        }
        if (str.charAt(str.length() - 1) == '.') {
            this.fqdn = str.substring(0, str.length() - 1);
        } else {
            this.fqdn = str;
        }
        this.port = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAddress)) {
            return false;
        }
        HostAddress hostAddress = (HostAddress) obj;
        return !this.fqdn.equals(hostAddress.fqdn) ? false : this.port == hostAddress.port;
    }

    public String getErrorMessage() {
        return this.exception == null ? "No error logged" : "'" + toString() + "' failed because " + this.exception.toString();
    }

    public Exception getException() {
        return this.exception;
    }

    public String getFQDN() {
        return this.fqdn;
    }

    public int getPort() {
        return this.port;
    }

    public int hashCode() {
        return ((this.fqdn.hashCode() + 37) * 37) + this.port;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String toString() {
        return this.fqdn + ":" + this.port;
    }
}
