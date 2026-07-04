package com.app.MyBooks.OpenLibrary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class LibraryResponse {

    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private String author;

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
        return Objects.requireNonNullElse(author, "Autor não identificado");
    }
}
