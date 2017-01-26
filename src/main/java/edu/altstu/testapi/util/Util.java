package edu.altstu.testapi.util;

/**
 *
 * @author gea
 */
public class Util {
    public static boolean isStringEmpty(String str) {
        return str.isEmpty() || str.trim().isEmpty();
    }
    
    public static String getKey() {
        return "D7FD21E5F0C49A925E78DEA682AE4338";
    }
    
    public static Long convert32BitIdTo64Bit(Long accountId) {
        /*
        function convert_steamid_64bit_to_32bit($id)
{
  $result = substr($id, 3) - 61197960265728;
  return (string) $result;
}
        function convert_steamid_32bit_to_64bit($id)
{
  $result = '765'.($id + 61197960265728);
  return (string) $result;
}

        */
        accountId += 76561197960265728L;
        return accountId;
        
    }
}
