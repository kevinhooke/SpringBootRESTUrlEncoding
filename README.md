# SpringBootRESTUrlEncoding
Spring Boot REST Controller with support for URL encoded parameters

By default, Spring Boot RestControllers do not support URL Encoded parameters in the URL, as '/' chars
encoded as %2f are still treated as '/'s in the path, resulting in the request failing to match
any of the RequestMappings.

The example controller in this project shows setting the system property 
org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH
and by overriding configurePathMatch() to set a custom UrlPathHelper.
