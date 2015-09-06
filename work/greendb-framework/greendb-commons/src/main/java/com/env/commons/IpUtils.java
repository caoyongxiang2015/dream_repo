/**
 * 
 */
package com.env.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IP工具
 * 
 */
public class IpUtils {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IpUtils.class);
    /**
     * 主机名
     */
    private static String hostName = "";
    /**
     * IP
     */
    private static String ip = "";
    /**
     * MAC地址
     */
    private static String macAddress = "";
    /**
     * 网络地址列表
     */
    private static InetAddress[] inetAddresses = null;

    /**
     * @return the hostName
     */
    public static final String getHostName() {
        if (StringUtils.isEmpty(hostName)) {
            synchronized (IpUtils.class) {
                if (StringUtils.isEmpty(hostName)) {
                    bindingIp();
                }
            }
        }
        return hostName;
    }

    /**
     * @return the ip
     */
    public static final String getIp() {
        if (StringUtils.isEmpty(ip)) {
            synchronized (IpUtils.class) {
                if (StringUtils.isEmpty(ip)) {
                    bindingIp();
                }
            }
        }
        return ip;
    }

    /**
     * @return the macAddress
     */
    public static final String getMacAddress() {
        if (StringUtils.isEmpty(macAddress)) {
            synchronized (IpUtils.class) {
                if (StringUtils.isEmpty(macAddress)) {
                    bindingIp();
                }
            }
        }
        return macAddress;
    }

    /**
     * @return the inetAddresses
     */
    public static final InetAddress[] getInetAddresses() {
        if (ArrayUtils.isEmpty(inetAddresses)) {
            synchronized (IpUtils.class) {
                if (ArrayUtils.isEmpty(inetAddresses)) {
                    bindingIp();
                }
            }
        }
        return inetAddresses;
    }

    /**
     * 绑定IP
     */
    private static final void bindingIp() {
        ProcessBuilder processBuilder = null;
        Process process = null;
        try {
            processBuilder = new ProcessBuilder("ifconfig");
            process = processBuilder.start();
        } catch (IOException ex) {
            processBuilder = new ProcessBuilder("ipconfig");
            try {
                process = processBuilder.start();
            } catch (IOException e) {
                return;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String line = null;
        try {
            line = br.readLine();
            while (!line.contains("192.168")) {
                line = br.readLine();
            }
        } catch (IOException ex) {
            return;
        }
        int beginIndex = line.indexOf("192.168");
        int endIndex = line.indexOf(' ', beginIndex);
        if (-1 == endIndex) {
            endIndex = line.length();
        }
        line = line.substring(beginIndex, endIndex);
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(line);
            hostName = inetAddress.getHostName();
            ip = inetAddress.getHostAddress();
            inetAddresses = InetAddress.getAllByName(hostName);
            bindingMacAddress(inetAddress);
        } catch (Exception ex) {
            LOGGER.error("获取本地IP失败", ex);
        }
    }

    /**
     * 绑定MAC地址
     * 
     * @throws SocketException
     */
    private static void bindingMacAddress(InetAddress inetAddress)
            throws Exception {
        NetworkInterface ni = NetworkInterface.getByInetAddress(inetAddress);
        byte[] macs = ni.getHardwareAddress();
        StringBuffer macBuffer = new StringBuffer(32);
        String mac = "";
        for (int i = 0; i < macs.length; i++) {
            mac = Integer.toHexString(macs[i] & 0xFF);
            if (1 == mac.length()) {
                mac = '0' + mac;
            }
            macBuffer.append(mac + "-");
        }
        macBuffer.deleteCharAt(macBuffer.length() - 1);
        macAddress = macBuffer.toString();
    }

    /**
     * 获取完整IP
     * 
     * @return 完整IP<br>
     *         hostName/ip/macAddress
     */
    public static final String fullIp() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getHostName());
        buffer.append("/");
        buffer.append(getIp());
        buffer.append("/");
        buffer.append(getMacAddress());
        return buffer.toString();
    }

    /**
     * 获取简易完整IP
     * 
     * @return 简易完整IP<br>
     *         hostName/ip
     */
    public static final String sampleFullIp() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getHostName());
        buffer.append("/");
        buffer.append(getIp());
        return buffer.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(IpUtils.getHostName());
            System.out.println(IpUtils.getInetAddresses());
            System.out.println(IpUtils.getIp());
            System.out.println(IpUtils.getMacAddress());
        } catch (Exception e) {
        }
    }
}
