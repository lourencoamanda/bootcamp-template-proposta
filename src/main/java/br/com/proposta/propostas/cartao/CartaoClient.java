package br.com.proposta.propostas.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cartao", url = "http://localhost:8888")
public interface CartaoClient {

    @GetMapping("/api/cartoes")
    CartaoResponse getCartao(@RequestParam("idProposta") String idProposta);
}
