package org.openjfx;

import java.util.ArrayList;
import java.util.List;

class Unibook {

    private static Unibook instance = null;

    private List<Studente> listastudenti;
    private List<Universita> listauniversita;
    private List<Professore> listaprofessori;
    private List<Esame> listaesami;
    private List<Ricevimento> listaricevimenti;
    private Studente studenteloggato;
    private Professore professoreloggato;

    /*
    --------------SINGLETON INSTANCE-------------
     */

    private Unibook() {
        listaprofessori = new ArrayList<>();
        listastudenti = new ArrayList<>();
        listauniversita = new ArrayList<>();
        listaesami = new ArrayList<>();
        listaricevimenti = new ArrayList<>();

        //SIMULAZIONE ESAMI E RICEVIMENTI CREATI AD-HOC
        listeExample(); //---> Vengono inseriti nelle liste esami e ricevimenti degli item casuali

    }

    public static Unibook getInstance() {
        if (instance == null) {
            instance = new Unibook();
        }
        return instance;
    }

    /*
    --------------GETTER AND SETTER-------------
     */

    public Studente getStudenteloggato() {
        return studenteloggato;
    }

    public void setStudenteloggato(Studente studenteloggato) {
        this.studenteloggato = studenteloggato;
    }

    public Professore getProfessoreloggato() {
        return professoreloggato;
    }

    public void setProfessoreloggato(Professore professoreloggato) {
        this.professoreloggato = professoreloggato;
    }

    public List<Studente> getListastudenti() {
        return listastudenti;
    }

    public void setListastudenti(List<Studente> listastudenti) {
        this.listastudenti = listastudenti;
    }

    public List<Universita> getListauniversita() {
        return listauniversita;
    }

    public void setListauniversita(List<Universita> listauniversita) {
        this.listauniversita = listauniversita;
    }

    public List<Professore> getListaprofessori() {
        return listaprofessori;
    }

    public void setListaprofessori(List<Professore> listaprofessori) {
        this.listaprofessori = listaprofessori;
    }

    public List<Esame> getListaesami() {
        return listaesami;
    }

    public void setListaesami(List<Esame> listaesami) {
        this.listaesami = listaesami;
    }

    public List<Ricevimento> getListaricevimenti() {
        return listaricevimenti;
    }

    public void setListaricevimenti(List<Ricevimento> listaricevimenti) {
        this.listaricevimenti = listaricevimenti;
    }

    /*
    --------------VERIFICA PROFESSORE NELLA PIATTAFORMA UNIBOOK-------------
     */

    private Professore verificaProfessoreUnibook(Professore professore){
        //VERIFICA PRESENZA DEL PROFESORE NELLA PIATTAFORMA UNIBOOK
        for(Professore p : listaprofessori){
            if(p.getMatricola().equals(professore.getMatricola())){
                return p;
            }
        }
        return null;
    }


    /*
    --------------VERIFICA STUDENTE NELLA PIATTAFORMA UNIBOOK----------------
     */

    private Studente verificaStudenteUnibook(Studente studente){
        for(Studente s : listastudenti){
            if(s.getMatricola().equals(studente.getMatricola())){
                return s;
            }
        }
        return null;
    }

    /*
    --------------VERIFICA PRESENZA PROFESSORE NELLE UNIVERSITA'-------------
     */

    private Boolean verificaProfessore(Professore professore, String cfuni){
        //ricerca dell'università di appartenenza del professore
        for(Universita u : listauniversita){
            if(u.getCodicefiscale().equals(cfuni)){
                //ricerca professore nell' elenco delle università
                for(Professore p : u.getListaprofessori()){
                    if(professore.getMatricola().equals(p.getMatricola())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    --------------VERIFICA PRESENZA STUDENTE NELLE UNIVERSITA'-------------
     */

    private Boolean verificaStudente(Studente studente, String cfuni, CorsoStudio corsoStudio){
        for(Universita u : listauniversita){
            if(u.getCodicefiscale().equals(cfuni)){
                //ricerca professore nell' elenco degli studenti dei rispettivi corsi di studio
                for(CorsoStudio cs : u.getListacorsodistudi()){
                    if(corsoStudio.getId().equals(cs.getId())){
                        for(Studente s : cs.getListastudenti()){
                            if(s.getMatricola().equals(studente.getMatricola())){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /*
    --------------REGISTRA STUDENTE NELLA PIATTAFORMA UNIBOOK-------------
     */

    public Boolean registraStudente(Studente studente, String cfuni, CorsoStudio cs, String password){
        studente.setPassword(password);
        if(verificaStudenteUnibook(studente) == null){
            System.out.println("Lo studente " + studente.getNome() + " con matricola '"
                    + studente.getMatricola()
                    + "' non è registrato alla piattaforma");
            if(verificaStudente(studente, cfuni, cs) == true) {
                listastudenti.add(studente);
                System.out.println("Registrazione"
                        + studente.toString() + " effettuata con successo");
                return true;
            }else{
                System.out.println("Registrazione di "
                        + studente.toString()
                        + " annullata perchè non è presente nell'università dichiarata");
                return false;
            }
        }
        return false;
    }

    /*
   --------------REGISTRA STUDENTE NELLA PIATTAFORMA UNIBOOK-------------
    */

    public Boolean registraProfessore(Professore professore, String cfuni, String password){
        professore.setPassword(password);
        if(verificaProfessoreUnibook(professore) == null){
            System.out.println("Il professore "+ professore.getNome()+" con matricola '" + professore.getMatricola()
                    + "' non è registrato alla piattaforma");
            if(verificaProfessore(professore, cfuni) == true) {
                listaprofessori.add(professore);
                System.out.println("Registrazione"
                        + professore.toString() + " effettuata con successo");
                return true;
            }else{
                System.out.println("Registrazione di "
                        + professore.toString() + " annullata");
                return false;
            }
        }
        return false;
    }

    public void inserisciMateria(Materia materia, CorsoStudio corsoStudio){

        for(Materia materiaregistrata: corsoStudio.getListamaterie()){
            if(materia.getNome().equals(materiaregistrata.getNome())){
                System.out.println("La materia è valida ed esiste per quel corso di studi");
                professoreloggato.inserisciMateria(materia);
            }
        }

    }

    /*
   --------------RIMOZIONE PROFESSORE DALLA LISTA -------------
    */

    public void rimuoviProfessore(Professore professore){
        listaprofessori.remove(professore);
    }
    public void rimuoviStudente(Studente studente){
        listastudenti.remove(studente);
    }

    /*
   --------------LOGIN------------
    */

    public Boolean loginStudente(Studente studente){
        Studente studenteregistrato = verificaStudenteUnibook(studente);
        if(studenteregistrato != null) {
            if (studente.getPassword().equals(studenteregistrato.getPassword())) {
                studenteloggato = studente;
                System.out.println("Studente " + studenteloggato.toString()+ " loggato correttamente");
                return true;
            }
        }else{
            System.out.println("Studente non esistente o password non corretta");
        }
        return false;
    }

    public Boolean loginProfessore(Professore professore){
        Professore professoreregistrato = verificaProfessoreUnibook(professore);
        if(professoreregistrato != null) {
            if (professore.getPassword().equals(professoreregistrato.getPassword())) {
                professoreloggato = professore;
                System.out.println("Professore " + professoreloggato.toString()+ " loggato correttamente");
                return true;
            }
        }else{
            System.out.println("Professore non esistente o password non corretta");
        }
        return false;
    }


    /*
   --------------GESTIONE ESAMI PROFESSORE------------
    */

    public void creaEsame(Esame esame){
        Esame esamefirmato = firmaEsame(esame);
        if(esame != null) listaesami.add(esamefirmato);
        /*for(Esame esamicreati : listaesami){
            System.out.println(esamicreati.toString());
        }*/
    }


    public void modificaEsame(Esame esame, Esame esamemodificato){
        for(Esame esamecreato : listaesami) {
            if (esame.getId() == esamecreato.getId()) {
                int index = listaesami.indexOf(esamecreato);
                listaesami.set(index, esamemodificato);
            }
        }
    }


    public void rimuoviEsame(Esame esame){
        if(esame.getIdprofessore() == professoreloggato.getMatricola()) {
            for(Esame esamecreato : listaesami){
                if(esamecreato.getId() == esame.getId()){
                    listaesami.remove(esamecreato);
                    return;
                }
            }
        }else{
            System.out.println("Non puoi rimuovere l'esame perchè non ti appartiene");
        }
    }

    private Esame firmaEsame(Esame esame) {
        /*
        Verifica che un ricevimento, nella lista dei ricevimenti creati, non abbia
        la stessa data dell' esame appena creato
         */

        if(listaricevimenti.size() == 0){
            esame.setIdprofessore(professoreloggato.getMatricola());
            return esame;
        }else{
            for (Ricevimento ricevimento : listaricevimenti) {
                if (esame.getData().equals(ricevimento.getData())) {
                    System.out.println("il sistema presenta un ricevimento con le stesse date dell'esame");
                    return null;
                }
            }
            esame.setIdprofessore(professoreloggato.getMatricola());
            return esame;
        }


    }


    /*
   --------------GESTIONE RICEVIMENTI PROFESSORE------------
    */

    public void creaRicevimento(Ricevimento ricevimento){
        Ricevimento ricevimentofirmato = firmaRicevimento(ricevimento);
        if(ricevimentofirmato != null) listaricevimenti.add(ricevimentofirmato);
        for(Ricevimento rcreati : listaricevimenti){
            System.out.println(rcreati.toString());
        }
    }

    public void rimuoviRicevimento(Ricevimento ricevimento){
        if(ricevimento.getIdprofessore() == professoreloggato.getMatricola()) {
            for(Ricevimento ricevimentocreato : listaricevimenti){
                if(ricevimentocreato.getId() == ricevimento.getId()){
                    listaricevimenti.remove(ricevimentocreato);
                    return;
                }
            }

        }else{
            System.out.println("Non puoi rimuovere il ricevimento perchè non ti appartiene");
        }
    }

    public void modificaRicevimento(Ricevimento ricevimento, Ricevimento ricevimentomodificato){
        for(Ricevimento ricevimentocreato : listaricevimenti) {
            if (ricevimento.getId() == ricevimentocreato.getId()) {
                int index = listaricevimenti.indexOf(ricevimentocreato);
                listaricevimenti.set(index, ricevimentomodificato);
            }
        }
    }

    private Ricevimento firmaRicevimento(Ricevimento ricevimento) {
        /*
        Verifica che un ricevimento, nella lista dei ricevimenti creati, non abbia
        la stessa data dell' esame appena creato
         */

        if(listaesami.size() == 0){
            ricevimento.setIdprofessore(professoreloggato.getMatricola());
            return ricevimento;
        }else {
            for (Esame esame : listaesami) {
                if (ricevimento.getData().equals(esame.getData())) {
                    System.out.println("il sistema presenta un esame con le stesse date del ricevimneto");
                    return null;
                }
            }
            ricevimento.setIdprofessore(professoreloggato.getMatricola());
            return ricevimento;
        }

    }


    /*
   --------------GESTIONE PRENOTAZIONI------------
    */

    public void prenotazioneEsame(Long esameid){
        for (Esame esame: listaesami){
            if(esame.getId() == esameid){
                esame.addStudente(studenteloggato);
                System.out.println("lo studente " + studenteloggato.toString() + "si è prenotato correttamente");
            }
        }
    }

    public void prenotazioneRicevimento(Long ricevimentoid){
        for (Ricevimento ricevimento : listaricevimenti){
            if(ricevimento.getId() == ricevimentoid){
                ricevimento.addStudente(studenteloggato);
                System.out.println("lo studente " + studenteloggato.toString() + "si è prenotato correttamente");
            }
        }
    }

    public void rimuoviPrenotazioneEsame(Long esameid){
        for(Esame esamecreato : listaesami){
            if(esamecreato.getId() == esameid){
                for(Studente studenteprenotato : esamecreato.getListaStudentiprenotati()) {
                    if(studenteprenotato.getMatricola() == studenteloggato.getMatricola()) {
                        esamecreato.getListaStudentiprenotati().remove(studenteprenotato);
                        return;
                    }
                }
            }
        }
    }

    public void rimuoviPrenotazioneRicevimento(Long ricevimentoid){
        for(Ricevimento ricevimentocreato : listaricevimenti){
            if(ricevimentocreato.getId() == ricevimentoid){
                for(Studente studenteprenotato : ricevimentocreato.getlistaStudentiprenotati()) {
                    if(studenteprenotato.getMatricola() == studenteloggato.getMatricola()) {
                        ricevimentocreato.getlistaStudentiprenotati().remove(studenteprenotato);
                        return;
                    }
                }
            }
        }
    }

    public void addUniversità(Universita universita){
        listauniversita.add(universita);
    }

    /*
    ---------------LISTA ESAMI E RICEVIMENTI------------
    Questo metodo serve a creare degli esami e ricevimenti di esempio, in quanto non è stato
    implementato un sistema di gestione dei dati persistenti.
     */
    private void listeExample(){
        Esame e1 = new Esame("aulaT5", 10, "10/02/22", "13:30", "15:30","orale");
        Esame e2 = new Esame("aulaT4", 16, "19/02/22", "12:30", "15:30","scritto");
        Ricevimento r1 = new Ricevimento("aula1", 10, "10/02/22", "13:30", "15:30");
        Ricevimento r2 = new Ricevimento("aula2", 20, "11/02/22", "16:30", "19:30");

        listaesami.add(e1);
        listaesami.add(e2);
        listaricevimenti.add(r1);
        listaricevimenti.add(r2);
    }

}
