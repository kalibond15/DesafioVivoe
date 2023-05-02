package br.com.vivo.desafio.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CandidateDTO {
    @NotBlank(message = "Nome não pode estar em branco.")
    private String name;
    @NotBlank(message = "Email não pode estar em branco.")
    @Email(message = "Email inválido.")
    private String email;
    @NotNull(message = "Nível de conhecimento em Java não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em Java deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em Java deve estar entre 0 e 10.")
    private int javaKnowledge;
    @NotNull(message = "Nível de conhecimento em C# não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em C# deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em C# deve estar entre 0 e 10.")
    private int csharpKnowledge;
    @NotNull(message = "Nível de conhecimento em Golang não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em Golang deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em Golang deve estar entre 0 e 10.")
    private int goLangKnowledge;
    @NotNull(message = "Nível de conhecimento em JavaScript não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em JavaScript deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em JavaScript deve estar entre 0 e 10.")
    private int javaScriptKnowledge;
    @NotNull(message = "Nível de conhecimento em Vue não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em Vue deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em Vue deve estar entre 0 e 10.")
    private int vueKnowledge;
    @NotNull(message = "Nível de conhecimento em PHP não pode estar em branco.")
    @Min(value = 0, message = "Nível de conhecimento em PHP deve estar entre 0 e 10.")
    @Max(value = 10, message = "Nível de conhecimento em PHP deve estar entre 0 e 10.")
    private int phpKnowledge;

}

