package com.wetech.demo.web3j.controller;

import com.wetech.demo.web3j.service.ERC20TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/erc20")
@RequiredArgsConstructor
public class ERC20TestController {

    private final ERC20TestService erc20Service;

    /** 部署合约 */
    @PostMapping("/deploy")
    public CompletableFuture<ResponseEntity<Map<String, String>>> deployContract() {
        return erc20Service.deployContract()
                .thenApply(address -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("contractAddress", address);
                    return ResponseEntity.ok(response);
                });
    }

    /** 加载合约 */
    @PostMapping("/load")
    public ResponseEntity<Map<String, String>> loadContract(@RequestParam String address) {
        erc20Service.loadContract(address);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Contract loaded successfully");
        response.put("contractAddress", address);
        return ResponseEntity.ok(response);
    }

    /** mint 代币 */
    @PostMapping("/mint")
    public CompletableFuture<ResponseEntity<Map<String, String>>> mint(
            @RequestParam String to,
            @RequestParam String amount) {
        return erc20Service.mint(to, new BigInteger(amount))
                .thenApply(this::toResponse);
    }

    /** 转账 */
    @PostMapping("/transfer")
    public CompletableFuture<ResponseEntity<Map<String, String>>> transfer(
            @RequestParam String to,
            @RequestParam String amount) {
        return erc20Service.transfer(to, new BigInteger(amount))
                .thenApply(this::toResponse);
    }

    /** 查询余额 */
    @GetMapping("/balanceOf")
    public CompletableFuture<ResponseEntity<Map<String, String>>> balanceOf(@RequestParam String address) {
        return erc20Service.balanceOf(address)
                .thenApply(balance -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("address", address);
                    response.put("balance", balance.toString());
                    response.put("contractAddress", erc20Service.getContractAddress());
                    return ResponseEntity.ok(response);
                });
    }

    /** 授权 */
    @PostMapping("/approve")
    public CompletableFuture<ResponseEntity<Map<String, String>>> approve(
            @RequestParam String spender,
            @RequestParam String amount) {
        return erc20Service.approve(spender, new BigInteger(amount))
                .thenApply(this::toResponse);
    }

    /** 从授权账户转移代币 */
    @PostMapping("/transferFrom")
    public CompletableFuture<ResponseEntity<Map<String, String>>> transferFrom(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String amount) {
        return erc20Service.transferFrom(from, to, new BigInteger(amount))
                .thenApply(this::toResponse);
    }

    /** 获取当前合约地址 */
    @GetMapping("/address")
    public ResponseEntity<Map<String, String>> getContractAddress() {
        Map<String, String> response = new HashMap<>();
        String address = erc20Service.getContractAddress();
        if (address != null) {
            response.put("contractAddress", address);
        } else {
            response.put("message", "No contract loaded");
        }
        return ResponseEntity.ok(response);
    }

    /** 通用交易回执格式化 */
    private ResponseEntity<Map<String, String>> toResponse(TransactionReceipt receipt) {
        Map<String, String> response = new HashMap<>();
        response.put("transactionHash", receipt.getTransactionHash());
        response.put("blockNumber", receipt.getBlockNumber().toString());
        response.put("gasUsed", receipt.getGasUsed().toString());
        response.put("status", receipt.getStatus());
        response.put("contractAddress", erc20Service.getContractAddress());
        return ResponseEntity.ok(response);
    }
}
