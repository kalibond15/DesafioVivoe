package br.com.vivo.desafio.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.desafio.api.Model.Candidate;
import br.com.vivo.desafio.api.Repository.CandidateRepository;
import br.com.vivo.desafio.api.dto.CandidateDTO;
import jakarta.mail.MessagingException;

@Service
public class CandidateService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CandidateRepository candidateRepository;

    public void evaluate(CandidateDTO candidateDTO) throws MessagingException {
        System.out.println(candidateDTO);
        Boolean backendApproved = candidateDTO.getJavaKnowledge() >= 7 && candidateDTO.getJavaKnowledge() <= 10
                && candidateDTO.getCsharpKnowledge() >= 7 && candidateDTO.getCsharpKnowledge() <= 10
                && candidateDTO.getGoLangKnowledge() >= 7 && candidateDTO.getGoLangKnowledge() <= 10;
        System.out.println(backendApproved);

        Boolean frontendApproved = candidateDTO.getJavaScriptKnowledge() >= 7
                && candidateDTO.getJavaScriptKnowledge() <= 10 && candidateDTO.getVueKnowledge() >= 7
                && candidateDTO.getVueKnowledge() <= 10 && candidateDTO.getPhpKnowledge() >= 7
                && candidateDTO.getPhpKnowledge() <= 10;

        System.out.println(frontendApproved);

        if (backendApproved && frontendApproved) {
            emailService.enviarEmail(candidateDTO.getEmail(), "Retorno",
                    "Você foi classificado para desenvolvedor Backend e Frontend, entraremos em contato.");
        } else if (backendApproved) {
            emailService.enviarEmail(candidateDTO.getEmail(), "Retorno",
                    "Você foi classificado para desenvolvedor Backend, entraremos em contato.");
        } else if (frontendApproved) {
            emailService.enviarEmail(candidateDTO.getEmail(), "Retorno",
                    "Você foi classificado para desenvolvedor Frontend, entraremos em contato.");
        } else {
            emailService.enviarEmail(candidateDTO.getEmail(), "Retorno",
                    "Agradecemos pelo seu interesse em nossa vaga e pelo tempo que dedicou ao processo seletivo. No entanto, após avaliarmos cuidadosamente sua candidatura, decidimos que, infelizmente, " +
                            "não poderemos continuar com você no processo seletivo para esta posição.");
        }
    }

    public Candidate saveCandidate(CandidateDTO candidateDto) {
        Candidate candidate = candidateRepository.findByEmail(candidateDto.getEmail());
        if (candidate != null) {
            candidate.setName(candidateDto.getName());
            candidate.setEmail(candidateDto.getEmail());
            candidate.setJavaKnowledge(candidateDto.getJavaKnowledge());
            candidate.setCSharpKnowledge(candidateDto.getCsharpKnowledge());
            candidate.setGoLangKnowledge(candidateDto.getGoLangKnowledge());
            candidate.setJavaScriptKnowledge(candidateDto.getJavaScriptKnowledge());
            candidate.setVueKnowledge(candidateDto.getVueKnowledge());
            candidate.setPhpKnowledge(candidateDto.getPhpKnowledge());
        } else {
            candidate = new Candidate();
            candidate.setName(candidateDto.getName());
            candidate.setEmail(candidateDto.getEmail());
            candidate.setJavaKnowledge(candidateDto.getJavaKnowledge());
            candidate.setCSharpKnowledge(candidateDto.getCsharpKnowledge());
            candidate.setGoLangKnowledge(candidateDto.getGoLangKnowledge());
            candidate.setJavaScriptKnowledge(candidateDto.getJavaScriptKnowledge());
            candidate.setVueKnowledge(candidateDto.getVueKnowledge());
            candidate.setPhpKnowledge(candidateDto.getPhpKnowledge());
        }
        return candidateRepository.save(candidate);
    }

}
