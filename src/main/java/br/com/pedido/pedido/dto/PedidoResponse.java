package br.com.pedido.pedido.dto;

public class PedidoResponse {
    public class PedidoResponse {

        private Long id;

        private String nomeCliente;

        private String rua;

        private String bairro;

        private String cidade;

        private String estado;

        private double valorPedido;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public double getValorPedido() {
            return valorPedido;
        }

        public void setValorPedido(double valorPedido) {
            this.valorPedido = valorPedido;
        }

        public PedidoResponse() {
        }

        public PedidoResponse(Long id, String nomeCliente, String rua, String bairro, String cidade, String estado, double valorPedido) {
            this.id = id;
            this.nomeCliente = nomeCliente;
            this.rua = rua;
            this.bairro = bairro;
            this.cidade = cidade;
            this.estado = estado;
            this.valorPedido = valorPedido;
        }
    }
}
