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

        // 1. Actualización de calidad antes de caducidad
        if (!isCheese && !isTickets) {

            if (a.qualitat > 0 && !isLegendary) {
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

        // 2. Decremento de días
        if (!isLegendary) {
            a.diesPerVendre--;
        }

        // 3. Después de caducidad
        if (a.diesPerVendre < 0) {

            if (!isCheese && !isTickets) {

                if (a.qualitat > 0 && !isLegendary) {
                    a.qualitat--;
                }

            } else if (isCheese) {

                if (a.qualitat < 50) {
                    a.qualitat++;
                }

            } else if (isTickets) {

                a.qualitat = 0;
            }
        }
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