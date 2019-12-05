package leetcode;

import java.util.HashSet;
import java.util.Set;

public class P929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for ( String email: emails){
            String parts[] = email.split("@");
            String userName = (parts[0].split("\\+"))[0].replace(".", "");
            uniqueEmails.add(userName+"@"+parts[1]);
        }
        return uniqueEmails.size();
    }
}
