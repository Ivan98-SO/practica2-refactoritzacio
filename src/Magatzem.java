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

        boolean isCheese = a.esFormatge();
        boolean isTickets = a.esEntrades();
        boolean isLegendary = a.esLegendari();

        // BEFORE SELL DATE
        if (!isCheese && !isTickets) {

            if (!isLegendary && a.qualitat > 0) {
                a.qualitat--;
            }

        } else {

            if (a.qualitat < 50) {
                a.qualitat++;

                if (isTickets) {

                    if (a.diesPerVendre < 11 && a.qualitat < 50) {
                        a.qualitat++;
                    }

                    if (a.diesPerVendre < 6 && a.qualitat < 50) {
                        a.qualitat++;
                    }
                }
            }
        }

        // DECREASE SELL-IN
        if (!isLegendary) {
            a.diesPerVendre--;
        }

        // AFTER SELL DATE
        if (a.diesPerVendre >= 0) {
            return;
        }

        if (isLegendary) {
            return;
        }

        if (isCheese) {
            if (a.qualitat < 50) a.qualitat++;
            return;
        }

        if (isTickets) {
            a.qualitat = 0;
            return;
        }

        if (a.qualitat > 0) {
            a.qualitat--;
        }
    }
}