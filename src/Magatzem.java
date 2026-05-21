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

        // AFTER SELL DATE
        if (a.diesPerVendre < 0) {

            if (isCheese) {
                increaseQuality(a);
            }

            else if (isTickets) {
                a.qualitat = 0;
            }

            else if (!isLegendary) {
                decreaseQuality(a);
            }
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