package br.com.pedido.pedido.controller;

import br.com.pedido.pedido.dto.PedidoRequest;
import br.com.pedido.pedido.dto.PedidoResponse;
import br.com.pedido.pedido.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoController {



    @RestController
    @RequestMapping({"/pedido"})
    public class pedidoController {

        @Autowired
        private br.com.pedido.pedido.dto.PedidoRepository pedidoRepository;

        @CrossOrigin(origins = "*")
        @PostMapping
        public ResponseEntity<Void> criarPedido(@RequestBody PedidoRequest pedido){
            br.com.pedido.pedido.dto.PedidoRequest pedidoModel = new br.com.pedido.pedido.dto.PedidoRequest();

            pedidoModel.setNomeCliente(pedido.getNomeCliente());
            pedidoModel.setRua(pedido.getRua());
            pedidoModel.setBairro(pedido.getBairro());
            pedidoModel.setCidade(pedido.getCidade());
            pedidoModel.setEstado(pedido.getEstado());
            pedidoModel.setValorPedido(pedido.getValorPedido());

            pedidoRepository.save(pedidoModel);

            return ResponseEntity.ok().body(null);

        }

        @CrossOrigin(origins = "*")
        @GetMapping
        public ResponseEntity<List<PedidoResponse>> retornarPedidos(){
            List<Pedido> pedidoList = new ArrayList<>();
            pedidoList = pedidoRepository.findAll();
            List<PedidoResponse> pedidoResponseList = new ArrayList<>();
            for(br.com.pedido.pedido.dto.Pedido pedido : pedidoList){
                pedidoResponseList.add( new PedidoResponse(pedido.getId(), pedido.getNomeCliente(), pedido.getRua(), pedido.getBairro(), pedido.getCidade(), pedido.getEstado(), pedido.getValorPedido()));
            }
            return ResponseEntity.ok().body(pedidoResponseList);

        }

        @PutMapping(path = {"/{id}"})
        public ResponseEntity<Void> atualizarPedido(@RequestBody PedidoRequest pedidoRequest, @PathVariable Long id){
            Optional<Pedido> pedido = pedidoRepository.findById(id).map(record -> {
                record.setNomeCliente(pedidoRequest.getNomeCliente());
                record.setRua(pedidoRequest.getRua());
                record.setBairro(pedidoRequest.getBairro());
                record.setCidade(pedidoRequest.getCidade());
                record.setEstado(pedidoRequest.getEstado());
                record.setValorPedido(pedidoRequest.getValorPedido());
                return pedidoRepository.save(record);
            });
            return ResponseEntity.ok().body(null);
        }
    }
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Void> removerPedido(@PathVariable Long id){
        SimpleJpaRepository pedidoRepository;
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().body(null);
    }
}
}
