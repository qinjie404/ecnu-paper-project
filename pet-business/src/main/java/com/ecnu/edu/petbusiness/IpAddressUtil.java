package com.ecnu.edu.petbusiness;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

import java.io.File;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.URLDecoder;
import java.net.UnknownHostException;

/**
 * util class
 *
 * @author chenxin<chenxin619315 @ gmail.com>
 */
@Slf4j
public class IpAddressUtil {

    private IpAddressUtil() {
    }

    public static IpAddressUtil getNewInstance() {
        return new IpAddressUtil();
    }

    /**
     * check the validate of the specifeld ip address
     *
     * @param ip
     * @return boolean
     */
    public boolean isIpAddress(String ip) {
        String[] p = ip.split("\\.");
        if (p.length != 4) {
            return false;
        }
        for (String pp : p) {
            if (pp.length() > 3) {
                return false;
            }
            int val = Integer.valueOf(pp);
            if (val > 255) {
                return false;
            }
        }
        return true;
    }

    public String getCityInfo(String ip) {
        // 获取文件路径
        String dbPath = this.getClass().getClassLoader().getResource("ip2region.db").getPath();
        try {
            dbPath = URLDecoder.decode(dbPath, "UTF-8");
            File file = new File(dbPath);
            if (file.exists() == false) {
                System.out.println("Error: Invalid ip2region.db file");
            }
            //查询算法
            //1-B-tree
            int algorithm = DbSearcher.BTREE_ALGORITHM;
            //2-Binary
            //DbSearcher.BINARY_ALGORITHM
            //3-Memory
            //DbSearcher.MEMORY_ALGORITYM
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);
            //define the method
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }
            DataBlock dataBlock = null;
            if (isIpAddress(ip) == false) {
                System.out.println("Error: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            String decode = URLDecoder.decode(dataBlock.getRegion(), "UTF-8");
            return decode;
        } catch (Exception e) {
            log.error("获取地址失败", e);
        }
        return null;
    }

    /**
     * 获取当前电脑ip地址
     *
     * @return
     */
    public String hostAddress() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e) {
            log.error("未知主机", e);
            return StringUtils.EMPTY;
        }
    }
}
