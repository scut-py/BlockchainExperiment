package com.wetech.demo.web3j.service;

import com.wetech.demo.web3j.contracts.erc20test.ERC20Test;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ERC20TestService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final ContractGasProvider gasProvider;

    private ERC20Test contract;

    @Getter
    private String contractAddress;

    /**
     * 部署 ERC20 合约
     */
    public CompletableFuture<String> deployContract() {
        log.info("Deploying ERC20Test contract...");
        return ERC20Test.deploy(web3j, credentials, gasProvider)
                .sendAsync()
                .thenApply(contract -> {
                    this.contract = contract;
                    this.contractAddress = contract.getContractAddress();
                    log.info("ERC20Test contract deployed at: {}", contractAddress);
                    return contractAddress;
                });
    }

    /**
     * 加载已部署的 ERC20 合约
     */
    public void loadContract(String address) {
        log.info("Loading ERC20Test contract from address: {}", address);
        this.contract = ERC20Test.load(address, web3j, credentials, gasProvider);
        this.contractAddress = address;
    }

    /**
     * mint：增发代币
     */
    public CompletableFuture<TransactionReceipt> mint(String to, BigInteger amount) {
        checkContract();
        log.info("Minting {} tokens to {}", amount, to);
        return contract.mint(to, amount).sendAsync();
    }

    /**
     * transfer：代币转账
     */
    public CompletableFuture<TransactionReceipt> transfer(String to, BigInteger amount) {
        checkContract();
        log.info("Transferring {} tokens to {}", amount, to);
        return contract.transfer(to, amount).sendAsync();
    }

    /**
     * balanceOf：查询余额
     */
    public CompletableFuture<BigInteger> balanceOf(String address) {
        checkContract();
        log.info("Querying balance of {}", address);
        return contract.balanceOf(address).sendAsync();
    }

    /**
     * approve：授权他人花费
     */
    public CompletableFuture<TransactionReceipt> approve(String spender, BigInteger amount) {
        checkContract();
        log.info("Approving {} tokens to spender {}", amount, spender);
        return contract.approve(spender, amount).sendAsync();
    }

    /**
     * transferFrom：从授权账户转移代币
     */
    public CompletableFuture<TransactionReceipt> transferFrom(String from, String to, BigInteger amount) {
        checkContract();
        log.info("Transferring {} tokens from {} to {}", amount, from, to);
        return contract.transferFrom(from, to, amount).sendAsync();
    }

    /**
     * 检查合约是否已加载
     */
    private void checkContract() {
        if (contract == null) {
            throw new IllegalStateException("ERC20Test contract not deployed or loaded");
        }
    }
}
