package test.sec;

import java.util.Map;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class RegistryDemoAndJNA {

	public static void main(String...n){
		
	System.out.println(Advapi32Util.registryGetStringValue
            (WinReg.HKEY_CURRENT_USER,
             "Software\\Microsoft\\Internet Explorer\\Main", "Search Page")
    );
    System.out.println(Advapi32Util.registryGetStringValue
            (WinReg.HKEY_LOCAL_MACHINE,
             "Software\\Microsoft\\Windows\\CurrentVersion\\App Paths\\AcroRd32.exe",
             ""));
    System.out.println(Advapi32Util.registryGetStringValue
            (WinReg.HKEY_LOCAL_MACHINE,
             "Software\\Microsoft\\Windows\\CurrentVersion\\App Paths\\AcroRd32.exe",
             "Path"));
    System.out.println(Advapi32Util.registryGetIntValue
            (WinReg.HKEY_CURRENT_USER,
             "Software\\Javasoft\\Java Update\\Policy\\javafx",
            "Frequency"));
    String [] keys = Advapi32Util.registryGetKeys
            (WinReg.HKEY_CURRENT_USER,
             "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings"
             );
    System.out.println("--------key--------");
    for (String key : keys) {
        System.out.println(key);
    }
    System.out.println("-------------------");
    Map <String, Object>values = Advapi32Util.registryGetValues
    (WinReg.HKEY_CURRENT_USER,
     "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings"
     );
    for (String value : values.keySet()) {
        System.out.println(value);
    }

    System.out.println(Advapi32Util.registryKeyExists(WinReg.HKEY_CURRENT_USER, "Software\\RealHowTo"));
    Advapi32Util.registryCreateKey(WinReg.HKEY_LOCAL_MACHINE, "Software\\RealHowTo");
    System.out.println(Advapi32Util.registryKeyExists(WinReg.HKEY_CURRENT_USER, "Software\\RealHowTo"));
//    Advapi32Util.registrySetStringValue
//        (WinReg.HKEY_CURRENT_USER, "Software\\RealHowTo", "url", "http://www.pradeep.org");
//    System.out.println(Advapi32Util.registryValueExists(WinReg.HKEY_CURRENT_USER, "Software\\RealHowTo", "url"));
//    System.out.println(Advapi32Util.registryValueExists(WinReg.HKEY_CURRENT_USER, "Software\\RealHowTo", "foo"));
}
}
