package pl.maciejbadziak.voteitbackend.tag.testdata;

import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources.TagResource;

public class TagResourceTestData {

    public static TagResource newsTagResource() {
        return TagResource.builder()
                .tagname("news")
                .build();
    }

    public static TagResource travelTagResource() {
        return TagResource.builder()
                .tagname("travel")
                .build();
    }
}
