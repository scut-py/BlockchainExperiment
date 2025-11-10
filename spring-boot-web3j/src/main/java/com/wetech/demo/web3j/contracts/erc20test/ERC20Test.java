package com.wetech.demo.web3j.contracts.erc20test;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.CustomError;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes1;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.14.0.
 */
@SuppressWarnings("rawtypes")
public class ERC20Test extends Contract {
    public static final String BINARY = "610160604052348015610010575f5ffd5b506040518060400160405280600881526020016726282caa37b5b2b760c11b81525080604051806040016040528060018152602001603160f81b8152506040518060400160405280600881526020016726282caa37b5b2b760c11b8152506040518060400160405280600881526020016726282caa37b5b2b760c11b815250816003908161009e9190610410565b5060046100ab8282610410565b506100bb915083905060056101a6565b610120526100ca8160066101a6565b61014052815160208084019190912060e052815190820120610100524660a05261015660e05161010051604080517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f60208201529081019290925260608201524660808201523060a08201525f9060c00160405160208183030381529060405280519060200120905090565b60805250503060c05250600880546001600160a01b031916339081179091556101a190610181601290565b61018f9060ff16600a6105c1565b61019c90620f42406105d3565b6101d8565b610655565b5f6020835110156101c1576101ba83610215565b90506101d2565b816101cc8482610410565b5060ff90505b92915050565b6001600160a01b0382166102065760405163ec442f0560e01b81525f60048201526024015b60405180910390fd5b6102115f8383610252565b5050565b5f5f829050601f8151111561023f578260405163305a27a960e01b81526004016101fd91906105ea565b805161024a8261061f565b179392505050565b6001600160a01b03831661027c578060025f8282546102719190610642565b909155506102ec9050565b6001600160a01b0383165f90815260208190526040902054818110156102ce5760405163391434e360e21b81526001600160a01b038516600482015260248101829052604481018390526064016101fd565b6001600160a01b0384165f9081526020819052604090209082900390555b6001600160a01b03821661030857600280548290039055610326565b6001600160a01b0382165f9081526020819052604090208054820190555b816001600160a01b0316836001600160a01b03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef8360405161036b91815260200190565b60405180910390a3505050565b634e487b7160e01b5f52604160045260245ffd5b600181811c908216806103a057607f821691505b6020821081036103be57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561040b57805f5260205f20601f840160051c810160208510156103e95750805b601f840160051c820191505b81811015610408575f81556001016103f5565b50505b505050565b81516001600160401b0381111561042957610429610378565b61043d81610437845461038c565b846103c4565b6020601f82116001811461046f575f83156104585750848201515b5f19600385901b1c1916600184901b178455610408565b5f84815260208120601f198516915b8281101561049e578785015182556020948501946001909201910161047e565b50848210156104bb57868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b634e487b7160e01b5f52601160045260245ffd5b6001815b6001841115610519578085048111156104fd576104fd6104ca565b600184161561050b57908102905b60019390931c9280026104e2565b935093915050565b5f8261052f575060016101d2565b8161053b57505f6101d2565b8160018114610551576002811461055b57610577565b60019150506101d2565b60ff84111561056c5761056c6104ca565b50506001821b6101d2565b5060208310610133831016604e8410600b841016171561059a575081810a6101d2565b6105a65f1984846104de565b805f19048211156105b9576105b96104ca565b029392505050565b5f6105cc8383610521565b9392505050565b80820281158282048414176101d2576101d26104ca565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b805160208083015191908110156103be575f1960209190910360031b1b16919050565b808201808211156101d2576101d26104ca565b60805160a05160c05160e051610100516101205161014051610fff6106a65f395f61083301525f61080601525f61074701525f61071f01525f61067a01525f6106a401525f6106ce0152610fff5ff3fe608060405234801561000f575f5ffd5b50600436106100fb575f3560e01c806370a082311161009357806395d89b411161006357806395d89b411461020d578063a9059cbb14610215578063d505accf14610228578063dd62ed3e1461023b575f5ffd5b806370a08231146101a457806379cc6790146101cc5780637ecebe00146101df57806384b0196e146101f2575f5ffd5b8063313ce567116100ce578063313ce567146101655780633644e5151461017457806340c10f191461017c57806342966c6814610191575f5ffd5b806306fdde03146100ff578063095ea7b31461011d57806318160ddd1461014057806323b872dd14610152575b5f5ffd5b610107610273565b6040516101149190610d64565b60405180910390f35b61013061012b366004610d98565b610303565b6040519015158152602001610114565b6002545b604051908152602001610114565b610130610160366004610dc0565b61031c565b60405160128152602001610114565b61014461033f565b61018f61018a366004610d98565b61034d565b005b61018f61019f366004610dfa565b6103b0565b6101446101b2366004610e11565b6001600160a01b03165f9081526020819052604090205490565b61018f6101da366004610d98565b6103bd565b6101446101ed366004610e11565b6103d2565b6101fa6103ef565b6040516101149796959493929190610e2a565b610107610431565b610130610223366004610d98565b610440565b61018f610236366004610ec0565b61044d565b610144610249366004610f2d565b6001600160a01b039182165f90815260016020908152604080832093909416825291909152205490565b60606003805461028290610f5e565b80601f01602080910402602001604051908101604052809291908181526020018280546102ae90610f5e565b80156102f95780601f106102d0576101008083540402835291602001916102f9565b820191905f5260205f20905b8154815290600101906020018083116102dc57829003601f168201915b5050505050905090565b5f33610310818585610583565b60019150505b92915050565b5f33610329858285610595565b610334858585610611565b506001949350505050565b5f61034861066e565b905090565b6008546001600160a01b031633146103a25760405162461bcd60e51b815260206004820152601360248201527213db9b1e481bdddb995c8818d85b881b5a5b9d606a1b60448201526064015b60405180910390fd5b6103ac8282610797565b5050565b6103ba33826107cb565b50565b6103c8823383610595565b6103ac82826107cb565b6001600160a01b0381165f90815260076020526040812054610316565b5f6060805f5f5f60606104006107ff565b61040861082c565b604080515f80825260208201909252600f60f81b9b939a50919850469750309650945092509050565b60606004805461028290610f5e565b5f33610310818585610611565b834211156104715760405163313c898160e11b815260048101859052602401610399565b5f7f6e71edae12b1b97f4d1f60370fef10105fa2faae0126114a169c64845d6126c98888886104bc8c6001600160a01b03165f90815260076020526040902080546001810190915590565b6040805160208101969096526001600160a01b0394851690860152929091166060840152608083015260a082015260c0810186905260e0016040516020818303038152906040528051906020012090505f61051682610859565b90505f61052582878787610885565b9050896001600160a01b0316816001600160a01b03161461056c576040516325c0072360e11b81526001600160a01b0380831660048301528b166024820152604401610399565b6105778a8a8a610583565b50505050505050505050565b61059083838360016108b1565b505050565b6001600160a01b038381165f908152600160209081526040808320938616835292905220545f1981101561060b57818110156105fd57604051637dc7a0d960e11b81526001600160a01b03841660048201526024810182905260448101839052606401610399565b61060b84848484035f6108b1565b50505050565b6001600160a01b03831661063a57604051634b637e8f60e11b81525f6004820152602401610399565b6001600160a01b0382166106635760405163ec442f0560e01b81525f6004820152602401610399565b610590838383610983565b5f306001600160a01b037f0000000000000000000000000000000000000000000000000000000000000000161480156106c657507f000000000000000000000000000000000000000000000000000000000000000046145b156106f057507f000000000000000000000000000000000000000000000000000000000000000090565b610348604080517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f60208201527f0000000000000000000000000000000000000000000000000000000000000000918101919091527f000000000000000000000000000000000000000000000000000000000000000060608201524660808201523060a08201525f9060c00160405160208183030381529060405280519060200120905090565b6001600160a01b0382166107c05760405163ec442f0560e01b81525f6004820152602401610399565b6103ac5f8383610983565b6001600160a01b0382166107f457604051634b637e8f60e11b81525f6004820152602401610399565b6103ac825f83610983565b60606103487f00000000000000000000000000000000000000000000000000000000000000006005610aa9565b60606103487f00000000000000000000000000000000000000000000000000000000000000006006610aa9565b5f61031661086561066e565b8360405161190160f01b8152600281019290925260228201526042902090565b5f5f5f5f61089588888888610b52565b9250925092506108a58282610c1a565b50909695505050505050565b6001600160a01b0384166108da5760405163e602df0560e01b81525f6004820152602401610399565b6001600160a01b03831661090357604051634a1406b160e11b81525f6004820152602401610399565b6001600160a01b038085165f908152600160209081526040808320938716835292905220829055801561060b57826001600160a01b0316846001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9258460405161097591815260200190565b60405180910390a350505050565b6001600160a01b0383166109ad578060025f8282546109a29190610f96565b90915550610a1d9050565b6001600160a01b0383165f90815260208190526040902054818110156109ff5760405163391434e360e21b81526001600160a01b03851660048201526024810182905260448101839052606401610399565b6001600160a01b0384165f9081526020819052604090209082900390555b6001600160a01b038216610a3957600280548290039055610a57565b6001600160a01b0382165f9081526020819052604090208054820190555b816001600160a01b0316836001600160a01b03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef83604051610a9c91815260200190565b60405180910390a3505050565b606060ff8314610ac357610abc83610cd2565b9050610316565b818054610acf90610f5e565b80601f0160208091040260200160405190810160405280929190818152602001828054610afb90610f5e565b8015610b465780601f10610b1d57610100808354040283529160200191610b46565b820191905f5260205f20905b815481529060010190602001808311610b2957829003601f168201915b50505050509050610316565b5f80807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a0841115610b8b57505f91506003905082610c10565b604080515f808252602082018084528a905260ff891692820192909252606081018790526080810186905260019060a0016020604051602081039080840390855afa158015610bdc573d5f5f3e3d5ffd5b5050604051601f1901519150506001600160a01b038116610c0757505f925060019150829050610c10565b92505f91508190505b9450945094915050565b5f826003811115610c2d57610c2d610fb5565b03610c36575050565b6001826003811115610c4a57610c4a610fb5565b03610c685760405163f645eedf60e01b815260040160405180910390fd5b6002826003811115610c7c57610c7c610fb5565b03610c9d5760405163fce698f760e01b815260048101829052602401610399565b6003826003811115610cb157610cb1610fb5565b036103ac576040516335e2f38360e21b815260048101829052602401610399565b60605f610cde83610d0f565b6040805160208082528183019092529192505f91906020820181803683375050509182525060208101929092525090565b5f60ff8216601f81111561031657604051632cd44ac360e21b815260040160405180910390fd5b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b602081525f610d766020830184610d36565b9392505050565b80356001600160a01b0381168114610d93575f5ffd5b919050565b5f5f60408385031215610da9575f5ffd5b610db283610d7d565b946020939093013593505050565b5f5f5f60608486031215610dd2575f5ffd5b610ddb84610d7d565b9250610de960208501610d7d565b929592945050506040919091013590565b5f60208284031215610e0a575f5ffd5b5035919050565b5f60208284031215610e21575f5ffd5b610d7682610d7d565b60ff60f81b8816815260e060208201525f610e4860e0830189610d36565b8281036040840152610e5a8189610d36565b606084018890526001600160a01b038716608085015260a0840186905283810360c0850152845180825260208087019350909101905f5b81811015610eaf578351835260209384019390920191600101610e91565b50909b9a5050505050505050505050565b5f5f5f5f5f5f5f60e0888a031215610ed6575f5ffd5b610edf88610d7d565b9650610eed60208901610d7d565b95506040880135945060608801359350608088013560ff81168114610f10575f5ffd5b9699959850939692959460a0840135945060c09093013592915050565b5f5f60408385031215610f3e575f5ffd5b610f4783610d7d565b9150610f5560208401610d7d565b90509250929050565b600181811c90821680610f7257607f821691505b602082108103610f9057634e487b7160e01b5f52602260045260245ffd5b50919050565b8082018082111561031657634e487b7160e01b5f52601160045260245ffd5b634e487b7160e01b5f52602160045260245ffdfea2646970667358221220465feb9dbf2614fde75c6fdefe89d6e236e70f2f335d66c0924c0c3d9352250164736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DOMAIN_SEPARATOR = "DOMAIN_SEPARATOR";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_EIP712DOMAIN = "eip712Domain";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_NONCES = "nonces";

    public static final String FUNC_PERMIT = "permit";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final CustomError ECDSAINVALIDSIGNATURE_ERROR = new CustomError("ECDSAInvalidSignature", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final CustomError ECDSAINVALIDSIGNATURELENGTH_ERROR = new CustomError("ECDSAInvalidSignatureLength", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final CustomError ECDSAINVALIDSIGNATURES_ERROR = new CustomError("ECDSAInvalidSignatureS", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    public static final CustomError ERC20INSUFFICIENTALLOWANCE_ERROR = new CustomError("ERC20InsufficientAllowance", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final CustomError ERC20INSUFFICIENTBALANCE_ERROR = new CustomError("ERC20InsufficientBalance", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final CustomError ERC20INVALIDAPPROVER_ERROR = new CustomError("ERC20InvalidApprover", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC20INVALIDRECEIVER_ERROR = new CustomError("ERC20InvalidReceiver", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC20INVALIDSENDER_ERROR = new CustomError("ERC20InvalidSender", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC20INVALIDSPENDER_ERROR = new CustomError("ERC20InvalidSpender", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC2612EXPIREDSIGNATURE_ERROR = new CustomError("ERC2612ExpiredSignature", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final CustomError ERC2612INVALIDSIGNER_ERROR = new CustomError("ERC2612InvalidSigner", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final CustomError INVALIDACCOUNTNONCE_ERROR = new CustomError("InvalidAccountNonce", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final CustomError INVALIDSHORTSTRING_ERROR = new CustomError("InvalidShortString", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final CustomError STRINGTOOLONG_ERROR = new CustomError("StringTooLong", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EIP712DOMAINCHANGED_EVENT = new Event("EIP712DomainChanged", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC20Test(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC20Test(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC20Test(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC20Test(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
        ApprovalEventResponse typedResponse = new ApprovalEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<EIP712DomainChangedEventResponse> getEIP712DomainChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EIP712DOMAINCHANGED_EVENT, transactionReceipt);
        ArrayList<EIP712DomainChangedEventResponse> responses = new ArrayList<EIP712DomainChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EIP712DomainChangedEventResponse typedResponse = new EIP712DomainChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EIP712DomainChangedEventResponse getEIP712DomainChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EIP712DOMAINCHANGED_EVENT, log);
        EIP712DomainChangedEventResponse typedResponse = new EIP712DomainChangedEventResponse();
        typedResponse.log = log;
        return typedResponse;
    }

    public Flowable<EIP712DomainChangedEventResponse> eIP712DomainChangedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEIP712DomainChangedEventFromLog(log));
    }

    public Flowable<EIP712DomainChangedEventResponse> eIP712DomainChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EIP712DOMAINCHANGED_EVENT));
        return eIP712DomainChangedEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static TransferEventResponse getTransferEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
        TransferEventResponse typedResponse = new TransferEventResponse();
        typedResponse.log = log;
        typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DOMAIN_SEPARATOR() {
        final Function function = new Function(FUNC_DOMAIN_SEPARATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(BigInteger amount) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> burnFrom(String account, BigInteger amount) {
        final Function function = new Function(
                FUNC_BURNFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>> eip712Domain(
            ) {
        final Function function = new Function(FUNC_EIP712DOMAIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes1>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>>(function,
                new Callable<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>>() {
                    @Override
                    public Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (byte[]) results.get(5).getValue(), 
                                convertToNative((List<Uint256>) results.get(6).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> nonces(String owner) {
        final Function function = new Function(FUNC_NONCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> permit(String owner, String spender,
            BigInteger value, BigInteger deadline, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_PERMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Uint256(deadline), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String to, BigInteger value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to,
            BigInteger value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC20Test load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20Test(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC20Test load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20Test(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC20Test load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new ERC20Test(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC20Test load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC20Test(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC20Test> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC20Test.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<ERC20Test> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC20Test.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ERC20Test> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC20Test.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ERC20Test> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC20Test.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class EIP712DomainChangedEventResponse extends BaseEventResponse {
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
