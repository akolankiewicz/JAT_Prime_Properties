package Usuario;

public enum NivelUsuario {
    VENDEDOR(1),
    COMPRADOR(2),
    ADMINISTRADOR(3);

    private final int nivel;

    NivelUsuario(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
