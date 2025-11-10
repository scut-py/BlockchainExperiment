// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/token/ERC20/extensions/ERC20Permit.sol";

contract ERC20Test is ERC20 {
    /**
     * @dev 构造函数
     */
    constructor() ERC20("LSRToken", "LSRT") {
       
    }

    /**
     * @dev 铸造新代币
     * @param to 接收代币的地址
     * @param amount 铸造的代币数量
     */
    function mint(address to, uint256 amount) public {
        _mint(to, amount);
    }

    /**
     * @dev 销毁代币
     * @param from 销毁代币的地址
     * @param amount 销毁的代币数量
     * 
     *
     */
    function burn(address from, uint256 amount) public {
        _burn(from, amount);
    }

    function approve(address spender, uint256 value) public override returns (bool) {
        require(spender != address(0), "ERC20: approve to the zero address");
        return super.approve(spender, value);

}
}