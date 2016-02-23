package com.linkedin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @author kodehelp
 *
 */
public class Test {

    public static void main(String[] args) {
        String SFTPHOST = "172.18.138.170";
        int SFTPPORT = 22;
        String SFTPUSER = "sftpuser";
        String SFTPPASS = "CiscoCisco1!";
        String SFTPWORKINGDIR = "/pub/software/BRIDGE/VTS/";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            System.out.println("The time is " + new Date().toString());
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            byte[] buffer = new byte[1024];
            // BufferedInputStream bis = new BufferedInputStream(
            // channelSftp.get("mcu5300_4.5(1.34).kupgrade", new
            // SystemOutProgressMonitor()));
            // BufferedInputStream bis = new
            // BufferedInputStream(channelSftp.get("mcu5300_4.5(1.34).kupgrade"));

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("Cisco_ts_VirtualMachine_4.2(4.18).tgz"));
            File newFile = new File("/tmp/xyz");
            OutputStream os = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
            // System.out.println("Getting: " + theLine);
            while ((readCount = bis.read(buffer)) > 0) {
                // System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }
            bis.close();
            bos.close();
            System.out.println("The time is " + new Date().toString());
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
