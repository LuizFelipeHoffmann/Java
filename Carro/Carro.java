class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private double velocidade;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0; 
    }

    public void acelerar(double valor) {
        this.velocidade += valor;
    }

    public void frear(double valor) {
        if (this.velocidade - valor >= 0) {
            this.velocidade -= valor;
        } else {
            this.velocidade = 0;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Velocidade: " + velocidade + " km/h");
    }
}
