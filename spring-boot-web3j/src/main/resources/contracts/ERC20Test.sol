// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/token/ERC20/extensions/ERC20Permit.sol";

contract ERC20Test is ERC20, ERC20Permit {
    address private _owner;

    constructor() ERC20("LPYToken", "LPYToken") ERC20Permit("LPYToken") {
        _owner = msg.sender;
        // 初始发行1000000个代币，根据decimals()的精度
        _mint(msg.sender, 1000000 * (10 ** uint256(decimals())));
    }

    // 发行新代币，只有合约所有者可以调用
    function mint(address to, uint256 amount) public {
        require(msg.sender == _owner, "Only owner can mint");
        _mint(to, amount);
    }

    // 销毁代币
    function burn(uint256 amount) public {
        _burn(msg.sender, amount);
    }

    // 从指定地址销毁代币（需要事先授权）
    function burnFrom(address account, uint256 amount) public {
        _spendAllowance(account, msg.sender, amount);
        _burn(account, amount);
    }

    // 重写decimals函数，默认返回18
    function decimals() public view virtual override returns (uint8) {
        return 18;
    }
}