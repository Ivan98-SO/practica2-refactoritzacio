class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            updateArticle(articles[i]);
        }
    }

    private void updateArticle(Article a) {

        boolean isCheese = a.nom.equals("Formatge Gidurat");
        boolean isTickets = a.nom.equals("Entrades per al Concert del Trobador");
        boolean isLegendary = a.nom.equals("Martell de Thor (Llegendari)");

        // =========================
        // 1. BEFORE SELL DATE
        // =========================
        if (!isCheese && !isTickets) {

            if (!isLegendary) {
                decreaseQuality(a);
            }

        } else {

            increaseQuality(a);

            if (isTickets) {

                if (a.diesPerVendre < 11) {
                    increaseQuality(a);
                }

                if (a.diesPerVendre < 6) {
                    increaseQuality(a);
                }
            }
        }

        // =========================
        // 2. SELL-IN DECREASE
        // =========================
        if (!isLegendary) {
            a.diesPerVendre--;
        }

        // =========================
        // 3. AFTER SELL DATE (REFORZADO Y LIMPIO)
        // =========================
        if (a.diesPerVendre >= 0) {
            return;
        }

        if (isLegendary) {
            return;
        }

        if (isCheese) {
            increaseQuality(a);
            return;
        }

        if (isTickets) {
            a.qualitat = 0;
            return;
        }

        // normal item after expiry
        decreaseQuality(a);
    }
    private void updateNormal(Article a) {
        if (a.qualitat > 0) {
            a.qualitat--;
        }
    }
    private void increaseQuality(Article a) {
        if (a.qualitat < 50) {
            a.qualitat++;
        }
    }

    private void decreaseQuality(Article a) {
        if (a.qualitat > 0) {
            a.qualitat--;
        }
    }
}