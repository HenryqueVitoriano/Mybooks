package com.app.MyBooks.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class LibraryResponse {

    @JsonProperty("docs")
    private List<LibraryResponse> docs;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private List<String> author;

    @JsonProperty("number_of_pages")
    private Integer numberOfPages;

    @JsonProperty("covers")
    private List<Integer> covers;

    public String getCoverUrl() {
        return (covers != null && !covers.isEmpty())
                ? "https://covers.openlibrary.org/b/id/" + covers.get(0) + "-L.jpg"
                : null;
    }

    public String getAuthorName(){

        if (author != null && !author.isEmpty()) {
            return author.get(0);
        }

        if (docs != null && !docs.isEmpty()) {
            return docs.get(0).getAuthorName();
        }
        return null;
    }
}