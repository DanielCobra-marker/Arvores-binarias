class NoAvl {
    int valor;
    No esquerdo, direito;
    int altura;

    void No(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
        this.altura = 1; // altura inicial do nó (quando é folha)
    }
}

