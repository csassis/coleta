package com.assis.coleta.coletor;

public class ColetoresStatic {

    private static java.util.List<com.assis.coleta.coletor.Coletor> coletores =
            new java.util.ArrayList<com.assis.coleta.coletor.Coletor>();

    public static com.assis.coleta.coletor.Coletor getOrAddColetor(String nomeColetor) {
        for (com.assis.coleta.coletor.Coletor coletor : coletores) {
            if (coletor.getNome().equals(nomeColetor))
                return coletor;
        }
        com.assis.coleta.coletor.Coletor coletor = new com.assis.coleta.coletor.Coletor();
        coletor.setNome(nomeColetor);
        coletores.add(coletor);
        return coletor;
    }

    public static boolean agendamentoJaEstaComAlgumColetor(Integer agendamentoId) {
        for (com.assis.coleta.coletor.Coletor coletor : com.assis.coleta.coletor.ColetoresStatic.getColetores()) {
            for (com.assis.coleta.agendamento.Agendamento pendente : coletor.getPendentes()) {
                if(pendente.getId() == agendamentoId){
                    return true;
                }
            }
        }
        return false;
    }

    public static Iterable<Coletor> getColetores() {
        return coletores;
    }
}
