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
    private String titulo;

    @JsonProperty("author_name")
    private String autor;

    @JsonProperty("number_of_pages")
    private Integer numeroDePaginas;

    @JsonProperty("covers")
    private List<Integer> covers;

    public String getCapaUrl() {
        return (covers != null && !covers.isEmpty())
                ? "https://covers.openlibrary.org/b/id/" + covers.get(0) + "-L.jpg"
                : null;
    }

    public String getAutorFormatado(){
        return Objects.requireNonNullElse(autor, " ");
    }
}
