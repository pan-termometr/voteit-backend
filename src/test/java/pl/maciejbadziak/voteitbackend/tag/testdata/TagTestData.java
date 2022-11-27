package pl.maciejbadziak.voteitbackend.tag.testdata;

import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.domain.Tagname;

public class TagTestData {

    public static Tag newsTag() {
        return Tag.builder()
                .tagname(Tagname.of("news"))
                .build();
    }

    public static Tag travelTag() {
        return Tag.builder()
                .tagname(Tagname.of("travel"))
                .build();
    }
}
