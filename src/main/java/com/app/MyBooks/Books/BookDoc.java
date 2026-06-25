package com.app.MyBooks.Books;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BookDoc {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("author_name")
    private List<String> autor;

    @JsonProperty("number_of_pages_median")
    private Integer numeroDePaginas;

    @JsonProperty("cover_i")
    private Integer capaId;

    public String getAutorFormatado() {
        return autor != null && !autor.isEmpty() ? autor.get(0) : null;
    }

    public String getCapaUrl() {
        return capaId != null
                ? "https://covers.openlibrary.org/b/id/" + capaId + "-L.jpg"
                : null;
    }
}