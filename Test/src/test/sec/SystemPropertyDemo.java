package test.sec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class SystemPropertyDemo {
	public static void main(String... n) throws Exception {
//		Enumeration<NetworkInterface> nets;
//		try {
//			nets = NetworkInterface.getNetworkInterfaces();
//			for (NetworkInterface netint : Collections.list(nets)) {
//				displayInterfaceInformation(netint);
//			}
//		} catch (SocketException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP Host " + address.getHostAddress());
	    NetworkInterface ni = NetworkInterface.getByInetAddress(address);
	    byte[] mac = ni.getHardwareAddress();
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    for (int i = 0; i < mac.length; i++) {
	      stringBuilder.append(String.format("%02X%s", mac[i], ""));
	      String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : "");
	    }
	    System.out.println("Is ISRG Application Available : "  + isApplicationAvailable());
	    if(!isApplicationAvailable()){
	    	System.out.println(stringBuilder);
	    	System.out.println(getSerialNumber());
	    	System.out.println(stringBuilder+getSerialNumber());
	    }
	    
//	    System.out.println(getApplicationStatus());
	}
	
	public static final String getSerialNumber(){
		String serialNumber = "";
		OutputStream os = null;
		InputStream is = null;
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		try {
			process = runtime.exec("wmic bios get serialnumber");
			
		} catch (IOException rex){throw new RuntimeException(rex);}
		
		os = process.getOutputStream();
		is = process.getInputStream();
		try {
			os.close();
		} catch (IOException rex){throw new RuntimeException(rex);}
		
		Scanner sc = new Scanner(is);
		try {
			while (sc.hasNext()) {
				String next = sc.next();
				if ("SerialNumber".equals(next)) {
					serialNumber = sc.next().trim();
					break;
				}
			}
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		if (serialNumber == null) {
			throw new RuntimeException("Cannot find computer SN");
		}

		
		return serialNumber;
		
	}
	
	public static final boolean isApplicationAvailable(){
		String serialNumber = "";
		OutputStream os = null;
		InputStream is = null;
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		try {
			process = runtime.exec("reg query hklm\\software\\isrg");
			
		} catch (IOException rex){throw new RuntimeException(rex);}
		
		os = process.getOutputStream();
		is = process.getInputStream();
		try {
			os.close();
		} catch (IOException rex){throw new RuntimeException(rex);}
		
		Scanner sc = new Scanner(is);
		try {
			while (sc.hasNext()) {
				String next = sc.next();
				serialNumber+=next;
			}
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		if ("".equals(serialNumber.trim())) {
			return false;
		}

		
		return true;
		
	}


	private static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
		System.out.printf("Display name: %s%n", netint.getDisplayName());
		System.out.printf("Name: %s%n", netint.getName());
		Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
		for (InetAddress inetAddress : Collections.list(inetAddresses)) {
			System.out.printf("InetAddress: %s%n", inetAddress);
		}

		System.out.printf("Parent: %s%n", netint.getParent());
		System.out.printf("Up? %s%n", netint.isUp());
		System.out.printf("Loopback? %s%n", netint.isLoopback());
		System.out.printf("PointToPoint? %s%n", netint.isPointToPoint());
		System.out.printf("Supports multicast? %s%n", netint.isVirtual());
		System.out.printf("Virtual? %s%n", netint.isVirtual());
		System.out.printf("Hardware address: %s%n", Arrays.toString(netint.getHardwareAddress()));
		System.out.printf("MTU: %s%n", netint.getMTU());

		List<InterfaceAddress> interfaceAddresses = netint.getInterfaceAddresses();
		for (InterfaceAddress addr : interfaceAddresses) {
			System.out.printf("InterfaceAddress: %s%n", addr.getAddress());
		}
		System.out.printf("%n");
		Enumeration<NetworkInterface> subInterfaces = netint.getSubInterfaces();
		for (NetworkInterface networkInterface : Collections.list(subInterfaces)) {
			System.out.printf("%nSubInterface%n");
			displayInterfaceInformation(networkInterface);
		}
		System.out.printf("%n");
	}
}
