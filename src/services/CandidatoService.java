package services;

import entities.Candidato;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CandidatoService {
    static Candidato criarCandidato(String nomeCandidato) {
        double salarioPretendido = valorSalarialPretendido();
        return new Candidato(nomeCandidato, salarioPretendido);
    }

    public List<Candidato> criarListaCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(criarCandidato("Maria"));
        candidatos.add(criarCandidato("José"));
        candidatos.add(criarCandidato("Francisco"));
        candidatos.add(criarCandidato("Eva"));
        candidatos.add(criarCandidato("Antônio"));
        candidatos.add(criarCandidato("Luzia"));
        candidatos.add(criarCandidato("Bento"));
        candidatos.add(criarCandidato("Josefa"));

        return candidatos;
    }

    public List<Candidato> selecionaCandidato(List<Candidato> candidatos) {
        final double salarioBase = 2000.0;

        return candidatos
                .stream()
                .filter(e -> e.getSalarioPretendido() <= salarioBase)
                .limit(5)
                .toList();
    }

    public List<Candidato> ligarCandidatos(List<Candidato> candidatosSelecionados) {
        List<Candidato> candidatosContatados = new ArrayList<>();

        for (Candidato candidato : candidatosSelecionados) {
            int tentativasLigacao = 0;
            boolean atendeu = false;
            while (tentativasLigacao < 3 && !atendeu) {
                atendeu = ligarCandidato();
                tentativasLigacao++;
                candidato.setTentativasLigacoes(tentativasLigacao);
            }
            if (tentativasLigacao < 3) {
                candidatosContatados.add(candidato);
            }
        }

        return candidatosContatados;
    }

    public static boolean ligarCandidato() {
        Random random = new Random();
        return random.nextBoolean();
    }

    static double valorSalarialPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}