package examples.members;

import com.intuit.karate.junit5.Karate;

class MembersRunner {
    
    @Karate.Test
    Karate testMembers() {
        return Karate.run("members").relativeTo(getClass());
    }    

}
