class Article {
    public String nom;
    public int diesPerVendre;
    public int qualitat;

    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }

    public boolean esFormatge() {
        return nom.equals("Formatge Gidurat");
    }

    public boolean esEntrades() {
        return nom.equals("Entrades per al Concert del Trobador");
    }

    public boolean esLegendari() {
        return nom.equals("Martell de Thor (Llegendari)");
    }
}