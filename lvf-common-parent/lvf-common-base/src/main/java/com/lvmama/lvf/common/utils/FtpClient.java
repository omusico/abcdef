package com.lvmama.lvf.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 * FTP下载工具
 * @author XuJunhui
 *
 */
public class FtpClient {
	
	private String ip;
	private int port = 21;
	private String username;
	private String password;
	private boolean isConnnected = false;
	private String encoding = "utf8";
	
	private FTPClient client;
	private String SEPARATOR = java.io.File.separator;
	
	protected static Logger logger = Logger.getLogger(FtpClient.class);
	
	public static FtpClient newInstance(String ip, int port, String username, String password) throws SocketException, IOException{
		FtpClient instance = new FtpClient(ip, port, username, password);
		instance.connect();
		return instance;
	}
	
	private FtpClient() {
		
	}

	private FtpClient(String ip, int port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	
	private void connect() throws SocketException, IOException{
		if(!isConnnected || client == null || !client.isConnected()){
			client = new FTPClient();
			client.connect(ip,port);
			client.login(username, password);
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.setControlEncoding(encoding);
			if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
				String msg = client.getReplyString();
				client.disconnect();
				throw new SocketException(msg);
			}      
			this.isConnnected = true;
		}
    }
	
	public void close(){
        if (client!=null && client.isConnected()) {
            try {
            	client.logout();
            	client.disconnect();
            	this.isConnnected = false;
            } catch (IOException e) {
            	logger.error("close ftp client fail.", e);
            }
        }
    }
	/**
	 * 从FTP下载单个文件
	 * @param remoteDir 远程目录
	 * @param fileName 文件名
	 * @param localDir 本地存放目录
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean download(String remoteDir,String fileName, String localDir){
		return download(remoteDir, fileName, localDir, fileName);
	}
	
	public boolean download(String remoteDir,String remoteFileName, String localDir, String localFileName){
		try {
			if(client.changeWorkingDirectory(remoteDir)){
				client.enterLocalPassiveMode();
				FTPFile[] files = client.listFiles();
				for(FTPFile f: files){
					if(f.isFile() && remoteFileName.equals(f.getName())){
						doCopy(remoteDir,f, localDir, localFileName);
						return true;
					}
				}
				logger.info("remote file not found.");
			}else{
				logger.info("remote dir not found.");
			}
		} catch (Exception e) {
			logger.error("download:"+ remoteFileName+ " error.", e);
		}
		return false;
	}
	
	
	public void downloadDir(String remoteDir, String localDir){
		try {
			if(client.changeWorkingDirectory(remoteDir)){
				FTPFile[] files = client.listFiles();
				for(FTPFile f: files){
					if(f.isFile()){
						doCopy(remoteDir, f, localDir, f.getName());
					}else if(f.isDirectory()){
						String currentName = f.getName();
						downloadDir(serverSuffix(remoteDir)+currentName , suffix(localDir) + currentName);
					}
				}
			}
		} catch(Exception e) {
			logger.error("downloadDir:" + remoteDir + " error.", e);
		}
	}
	
	private boolean doCopy(String remoteDir, FTPFile remoteFile, String localDir, String localFileName){
		try {
			if(client.changeWorkingDirectory(remoteDir) && remoteFile.getName().indexOf("?") == -1){
				File localDirFile = new File(localDir);
				if(!localDirFile.exists()){
					localDirFile.mkdirs();
				}
				String localFile = suffix(localDir) + localFileName;
				File lf = new File(localFile);
				if(lf!= null && lf.exists()){
					lf.delete();
				}
				OutputStream os = new FileOutputStream(lf);
			    client.retrieveFile(remoteFile.getName(), os);
			    os.flush();
			    os.close();
			    logger.info("copy:"+ remoteFile.getName()+" >> "+ localFile + "success.");
			    return true;
			}
		} catch (Exception e) {
			logger.error("copy file:"+remoteFile.getName() +" error.", e);
		}
		return false;
		
	}

	public boolean upload(String localPath, String remotePath){
		//TODO
		return false;
	}
	
	private String suffix(String path){
		if(path.lastIndexOf(SEPARATOR) != path.length()){
			return path + SEPARATOR;
		}
		return path;
	}
	
	private String serverSuffix(String path){
		if(path.lastIndexOf("/") != path.length()){
			return path + "/";
		}
		return path;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
