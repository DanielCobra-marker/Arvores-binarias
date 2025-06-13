class ArvoreAVL {
    No raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    No inserir(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerdo = inserir(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserir(no.direito, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && valor < no.esquerdo.valor) {
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor > no.direito.valor) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento > 1 && valor > no.esquerdo.valor) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor < no.direito.valor) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));
        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));
        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));

        return y;
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerdo) - altura(no.direito);
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    public void percursoEmOrdem(No raiz2) {
        throw new UnsupportedOperationException("Unimplemented method 'percursoEmordem'");
    }
}
