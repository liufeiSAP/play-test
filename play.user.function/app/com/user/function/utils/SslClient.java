package com.user.function.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import play.Logger;

/**
 * The type Ssl client.
 */
public class SslClient {

    private static final Logger.ALogger logger = Logger.of(SslClient.class);
    /**
     * Gets ssl client.
     *
     * @return the ssl client
     */

    public static CloseableHttpClient getSslClient() {
        try {
            CloseableHttpClient httpClient = null;
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] {tm}, null);
            HostnameVerifier verifier = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(ctx, verifier);
            httpClient =
                HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
            return httpClient;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
