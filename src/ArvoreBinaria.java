class No {
    int valor;
    No esquerdo, direito;

    No(int valor) {
        this.valor = valor;
    }
}

public class ArvoreBinaria {
    private No raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no == null) return new No(valor);
        if (valor < no.valor)
            no.esquerdo = inserir(no.esquerdo, valor);
        else
            no.direito = inserir(no.direito, valor);
        return no;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerdo) + contarNos(no.direito);
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);

        System.out.println("Número de nós na árvore: " + arvore.contarNos());
        
        System.out.print("Pré-ordem: ");
        arvore.preOrdem();

        System.out.println(); 

        System.out.print("Em ordem: ");
        arvore.emOrdem();

        System.out.println(); 

        System.out.print("Pós-ordem: ");
        arvore.posOrdem();
    }
}
