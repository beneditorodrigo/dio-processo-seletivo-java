package candidatura;

import entities.Candidato;
import services.CandidatoService;

import java.util.ArrayList;
import java.util.List;

public class ProcessoSeletivo {

    private static List<Candidato> candidatos;

    public static void main(String[] args) {
        CandidatoService candidatoService = new CandidatoService();
        candidatos = new ArrayList<>(candidatoService.criarListaCandidatos());

        List<Candidato> candidatosSelecionados = candidatoService.selecionaCandidato(candidatos);
        candidatosSelecionados
                .stream()
                .map(e -> e.getNome())
                .forEach(System.out::println);

        List<Candidato> candidatosSelecionadosContatados = candidatoService.ligarCandidatos(candidatosSelecionados);
        for (Candidato candidato : candidatosSelecionadosContatados) {
            System.out.println("Nome: " + candidato.getNome() + " - Nº Ligações: " + candidato.getTentativasLigacoes());
        }
    }
}
