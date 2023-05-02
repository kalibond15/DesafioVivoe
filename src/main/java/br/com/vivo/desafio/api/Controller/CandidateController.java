package br.com.vivo.desafio.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.vivo.desafio.api.Service.CandidateService;
import br.com.vivo.desafio.api.dto.CandidateDTO;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
@Validated
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/evaluate")
    @ResponseBody
    public ResponseEntity<?> evaluateCandidate(@RequestBody @Valid CandidateDTO candidateDTO) throws MessagingException {
        System.out.println(candidateDTO);
        candidateService.saveCandidate(candidateDTO);
        candidateService.evaluate(candidateDTO);
        return ResponseEntity.ok("Desenvolvedor avaliado com sucesso.");
    }
}
